package biller.kenneth.pricingengineexample.exception;

/**
 *
 * @author Kenneth Biller
 */
public class PricingException extends Exception {

    public PricingException() {
    }

    public PricingException(String string) {
        super(string);
    }

    public PricingException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public PricingException(Throwable thrwbl) {
        super(thrwbl);
    }

    public PricingException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
    
    
}
