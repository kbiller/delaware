package biller.kenneth.pricingengineexample.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Kenneth Biller
 */
public class ProductInfo {
    
    private final String productCode;
    private final Magnitude supply;
    private final Magnitude demand;
    private final List<ProductPrice> prices;

        
    public ProductInfo(String productCode, Magnitude supply,Magnitude demand) {
        this.productCode = productCode;
        this.supply = supply;
        this.demand = demand;
        this.prices =new ArrayList<ProductPrice>();;
    }
    
    public BigDecimal getLowestPriceWithHighestCount () {
        // Since this map will be used twice, save it in a local variable first
        // to avoid computing it multiple times
        Map<BigDecimal,Long> pricesToNumberOfOccurances = getMappingOfPricesToNumberOfOccurances();
        return pricesToNumberOfOccurances.entrySet().stream()
                .filter(e-> e.getValue().equals(getHighestCount(pricesToNumberOfOccurances)))
                .min(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey).orElse(null);
    }

    public BigDecimal getAveragePrice() {
        BigDecimal sumPrices = prices.stream().map(ProductPrice::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add);
        return sumPrices.divide(new BigDecimal(getPrices().size()),RoundingMode.CEILING);
    }
        
    public List<ProductPrice> getValidPrices() {
        return prices.stream().filter(p -> p.isPriceValidForAverage(this.getAveragePrice())).collect(Collectors.toList());
    }
    public void addPrice(ProductPrice price) {
        this.getPrices().add(price);
    }
       
    public void addPrices(List<ProductPrice> prices) {
        this.getPrices().addAll(prices);
    }
        
    public String getProductCode() {
        return productCode;
    }

    public List<ProductPrice> getPrices() {
        return prices;
    }

    public Magnitude getSupply() {
        return supply;
    }

    public Magnitude getDemand() {
        return demand;
    }

    
    public Long getHighestCount(Map<BigDecimal,Long> pricesToNumberOfOccurances) {
        return pricesToNumberOfOccurances.entrySet().stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getValue).orElse(null);
    }

    private Map<BigDecimal,Long> getMappingOfPricesToNumberOfOccurances() {
        return getValidPrices().stream()
        .collect(Collectors.groupingBy(ProductPrice::getPrice,Collectors.counting()));
    }
       
}
