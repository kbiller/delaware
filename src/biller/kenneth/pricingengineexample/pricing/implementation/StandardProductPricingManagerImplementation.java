package biller.kenneth.pricingengineexample.pricing.implementation;

import biller.kenneth.pricingengineexample.data.Magnitude;
import biller.kenneth.pricingengineexample.data.ProductInfo;
import biller.kenneth.pricingengineexample.data.ProductPrice;
import biller.kenneth.pricingengineexample.exception.PricingException;
import biller.kenneth.pricingengineexample.exception.PricingInputDataException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Kenneth Biller
 */
public class StandardProductPricingManagerImplementation extends AbstractProductPricingManager {

    public final static String inputFileName = "C:\\inputFiles\\input.txt";
    
    private static final String CHAR_REPRESENTING_HIGH_MAGNITUDE = "H";
    private static final String CHAR_REPRESENTING_LOW_MAGNITUDE = "L";

    
    
    @Override
    public List<ProductInfo> loadProductInfo() throws PricingException {
        List<ProductInfo> piList= null;
        Map<String,ProductInfo> productsByCode = new HashMap<>();
         try (Scanner sc = new Scanner(new File(inputFileName))){
            if ( sc.hasNextInt()) {
                int numProducts = sc.nextInt();
                piList = getProductInfos(numProducts,productsByCode,sc);
                if ( sc.hasNextInt()) {
                    int numPrices = sc.nextInt();
                    processPrices(numPrices,productsByCode,sc);
                }
            }
        }
        catch (IOException ie) {
             throw new PricingInputDataException("Problem loading product info",ie);
        }
        return piList;
    }


    
    @Override
    protected BigDecimal computeProductPrice(ProductInfo productInfo) throws PricingException {
        return StandardPricingEngine.getInstance().calcOurProductPrice(productInfo);
    }

    @Override
    protected void outputProductPrice(String productCode, BigDecimal ourPrice) {
        System.out.printf(productCode + " ");
        System.out.printf("%02.1f\n",ourPrice);
    }
    
    
    private List<ProductInfo> getProductInfos(int numProducts,Map<String,ProductInfo> productsByCode, Scanner sc) throws PricingException{
        List<ProductInfo> piList = new ArrayList<>();
        for ( int i = 1; i <= numProducts; i++ ) {
            if ( sc.hasNextLine()) {
                String productCode = sc.next();
                Magnitude supply = getNextParameter(sc);
                Magnitude demand = getNextParameter(sc);
                ProductInfo pi = new ProductInfo(productCode,supply,demand);
                productsByCode.put(productCode, pi);
                piList.add(pi);
            }
            else {
                throw new PricingException("Lines of product data found in the file does not match the count");
            }
        }   
        return piList;
    }

    
    private Magnitude getNextParameter(Scanner sc) throws PricingException{
        Magnitude magnitude;
        String parameter = sc.next();
        if ( parameter.equals(CHAR_REPRESENTING_HIGH_MAGNITUDE) ) {
            magnitude = Magnitude.HIGH;
        }
        else if ( parameter.equals(CHAR_REPRESENTING_LOW_MAGNITUDE)) {
            magnitude = Magnitude.LOW;
        }
        else {
            throw new PricingException("Expected pricing parameter mot found");
        }
        return magnitude;
    }
 
    private void processPrices(int numPrices,Map<String,ProductInfo> productsByCode, Scanner sc) throws PricingException{
        ProductInfo pi = null;
        for ( int i = 1; i <= numPrices; i++ ) {
            if ( sc.hasNextLine()) {
                String productCode = sc.next();
                if ( productCode != null ) {
                    pi = productsByCode.get(productCode);
                    if ( pi == null ) {
                        throw new PricingException("Product info and parameters mot found for " + productCode);
                    }
                    pi.addPrice(parsePriceLine(sc));
                }
                else {
                    throw new PricingException("Expected price data mot found for " + productCode);
                }
            }
            else {
                throw new PricingException("Lines of price data found in the file does not match the count");
            }
        }
    }
    
    private ProductPrice parsePriceLine(Scanner sc) {
        String competitorName = sc.next();
        BigDecimal price = sc.nextBigDecimal();
        return new ProductPrice(competitorName,price); 
    }
    
}
