package biller.kenneth.pricingengineexample;

import biller.kenneth.pricingengineexample.pricing.implementation.StandardProductPricingManagerImplementation;
import biller.kenneth.pricingengineexample.exception.PricingException;

/**
 *
 * @author Kenneth Biller
 */
public class PricingApplicationMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            new StandardProductPricingManagerImplementation().executePricing();
        }
        catch (PricingException e) {
            System.out.printf("%s","Pricing engine error: " + e.toString() + "\n");
           
        }
    }
    
}
