package biller.kenneth.pricingengineexample.pricing.implementation;

import biller.kenneth.pricingengineexample.pricing.ProductPricingManager;
import biller.kenneth.pricingengineexample.data.ProductInfo;
import biller.kenneth.pricingengineexample.exception.PricingException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Kenneth Biller
 */
public abstract class AbstractProductPricingManager implements ProductPricingManager {

    @Override
    public final void executePricing() throws PricingException {
        List<ProductInfo> products = this.loadProductInfo();
        for (ProductInfo productInfo:products ) {
            BigDecimal ourPrice = computeProductPrice(productInfo);
            outputProductPrice(productInfo.getProductCode(),ourPrice);
        }
    }
    
    abstract List<ProductInfo> loadProductInfo() throws PricingException;

    abstract BigDecimal computeProductPrice(ProductInfo productInfo)  throws PricingException;

    abstract void outputProductPrice(String productCode, BigDecimal ourPrice);
    
}