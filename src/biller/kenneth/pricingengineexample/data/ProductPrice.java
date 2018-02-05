package biller.kenneth.pricingengineexample.data;

import java.math.BigDecimal;

/**
 *
 * @author Kenneth Biller
 */
public class ProductPrice {
    
    private String competitorCode;
    private BigDecimal price;

    public ProductPrice(String competitorCode, BigDecimal price) {
        this.competitorCode = competitorCode;
        this.price = price;
    }

    public boolean isPriceValidForAverage(BigDecimal average) {
        BigDecimal upperLimit = average.multiply(new BigDecimal(1.5));
        BigDecimal lowerLimit = average.multiply(new BigDecimal(0.5));
        return (getPrice().compareTo(lowerLimit) >= 0 ) && (getPrice().compareTo(upperLimit) < 1);
    }
    
    public String getCompetitorCode() {
        return competitorCode;
    }

    public void setCompetitorCode(String competitorCode) {
        this.competitorCode = competitorCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
}
