package biller.kenneth.pricingengineexample.pricing;

import biller.kenneth.pricingengineexample.exception.PricingException;


/**
 *
 * @author Kenneth Biller
 */
public interface ProductPricingManager {
    
    public void executePricing() throws PricingException;
}
