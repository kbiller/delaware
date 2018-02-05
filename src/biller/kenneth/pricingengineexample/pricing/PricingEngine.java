package biller.kenneth.pricingengineexample.pricing;

import biller.kenneth.pricingengineexample.data.ProductInfo;
import biller.kenneth.pricingengineexample.exception.PricingException;
import java.math.BigDecimal;

/**
 *
 * @author Kenneth Biller
 */
public interface PricingEngine {
    
        BigDecimal calcOurProductPrice(ProductInfo productInfo) throws PricingException;

}
