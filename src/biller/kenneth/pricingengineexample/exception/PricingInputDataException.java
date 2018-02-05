package biller.kenneth.pricingengineexample.exception;

/**
 *
 * @author Kenneth Biller
 */
public class PricingInputDataException extends PricingException {

    public PricingInputDataException() {
    }

    public PricingInputDataException(String string) {
        super(string);
    }

    public PricingInputDataException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
}
