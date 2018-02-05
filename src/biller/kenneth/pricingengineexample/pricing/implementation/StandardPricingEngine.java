package biller.kenneth.pricingengineexample.pricing.implementation;

import biller.kenneth.pricingengineexample.pricing.PricingEngine;
import biller.kenneth.pricingengineexample.data.Magnitude;
import biller.kenneth.pricingengineexample.data.ProductInfo;
import biller.kenneth.pricingengineexample.exception.PricingException;
import biller.kenneth.pricingengineexample.exception.NoValidPricesForProductException;
import java.math.BigDecimal;

/**
 *
 * @author Kenneth Biller
 */
public class StandardPricingEngine implements PricingEngine{
    
    private static PricingEngine engine = new StandardPricingEngine();

    public static PricingEngine getInstance() {
        return engine;
    }
    
    
    @Override
    public BigDecimal calcOurProductPrice(ProductInfo productInfo) throws PricingException{
        if (productInfo == null) {
            throw new IllegalArgumentException("product info can not be null");
        }
        if (productInfo.getValidPrices().size() == 0 ) {
            throw new NoValidPricesForProductException("Must have at least one VALID starting price for the product");
        }
        BigDecimal selectedStartingCompetitorPrice = chooseStartingPrice(productInfo);
        return getAdjustedProductPrice(productInfo,selectedStartingCompetitorPrice);
    }
    
    protected BigDecimal chooseStartingPrice(ProductInfo productInfo) {
        return productInfo.getLowestPriceWithHighestCount();
    }
    
    protected BigDecimal getAdjustedProductPrice(ProductInfo productInfo,BigDecimal startingPrice) {
        BigDecimal adjustedPrice = startingPrice;
        if ( productInfo.getSupply() == Magnitude.HIGH ) {
            if ( productInfo.getDemand() == Magnitude.LOW ) {
                adjustedPrice = adjustedPrice.multiply(new BigDecimal("0.95"));
            }
            //Note:  the rule is that if supplu is high and demand is high, do nothing to starting price
        }
        else {
            if ( productInfo.getDemand() == Magnitude.HIGH ) {
                adjustedPrice = adjustedPrice.multiply(new BigDecimal("1.05"));
            }
            else {
                adjustedPrice = adjustedPrice.multiply(new BigDecimal("1.1"));
            }            
        }
        return adjustedPrice;
    }
    
    
}
