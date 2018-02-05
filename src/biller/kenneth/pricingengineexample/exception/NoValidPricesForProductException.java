package biller.kenneth.pricingengineexample.exception;

/**
 *
 * @author Kenneth Biller
 */
public class NoValidPricesForProductException extends PricingException{

    public NoValidPricesForProductException() {
    }

    public NoValidPricesForProductException(String string) {
        super(string);
    }

    public NoValidPricesForProductException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
}
