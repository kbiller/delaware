package biller.kenneth.pricingengineexample.pricing.implementation;

import biller.kenneth.pricingengineexample.data.Magnitude;
import biller.kenneth.pricingengineexample.data.ProductInfo;
import biller.kenneth.pricingengineexample.data.ProductPrice;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Kenneth Biller
 */
public class StandardProductPricingManagerImplementationTest {
    
    public StandardProductPricingManagerImplementationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }



    @Test
    public void testComputeProductPriceHighSupplyHighDemand() throws Exception {
        System.out.println("computeProductPrice");
        ProductInfo productInfo = new ProductInfo("testprod1",Magnitude.HIGH,Magnitude.HIGH);
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("1.00")));
        productInfo.addPrice(new ProductPrice("CA",new BigDecimal("10.00")));
        productInfo.addPrice(new ProductPrice("T",new BigDecimal("10.00")));
        productInfo.addPrice(new ProductPrice("W",new BigDecimal("20.00")));
        productInfo.addPrice(new ProductPrice("Z",new BigDecimal("20.00")));
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("20.00")));
        productInfo.addPrice(new ProductPrice("V",new BigDecimal("20.00")));
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("30.00")));
        StandardProductPricingManagerImplementation instance = new StandardProductPricingManagerImplementation();
        BigDecimal expResult = new BigDecimal("20.00");
        BigDecimal result = instance.computeProductPrice(productInfo);
        assertEquals(expResult, result);
    }


    @Test
    public void testComputeProductPriceHighSupplyLowDemand() throws Exception {
        System.out.println("computeProductPrice");
        ProductInfo productInfo = new ProductInfo("testprod1",Magnitude.HIGH,Magnitude.LOW);
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("1.00")));
        productInfo.addPrice(new ProductPrice("CA",new BigDecimal("10.00")));
        productInfo.addPrice(new ProductPrice("T",new BigDecimal("10.00")));
        productInfo.addPrice(new ProductPrice("W",new BigDecimal("20.00")));
        productInfo.addPrice(new ProductPrice("Z",new BigDecimal("20.00")));
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("20.00")));
        productInfo.addPrice(new ProductPrice("V",new BigDecimal("20.00")));
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("30.00")));
        StandardProductPricingManagerImplementation instance = new StandardProductPricingManagerImplementation();
        BigDecimal expResult = new BigDecimal("19.0000");
        BigDecimal result = instance.computeProductPrice(productInfo);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testComputeProductPriceLowSupplyHighDemand() throws Exception {
        System.out.println("computeProductPrice");
        ProductInfo productInfo = new ProductInfo("testprod1",Magnitude.LOW,Magnitude.HIGH);
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("1.00")));
        productInfo.addPrice(new ProductPrice("CA",new BigDecimal("10.00")));
        productInfo.addPrice(new ProductPrice("T",new BigDecimal("10.00")));
        productInfo.addPrice(new ProductPrice("W",new BigDecimal("20.00")));
        productInfo.addPrice(new ProductPrice("Z",new BigDecimal("20.00")));
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("20.00")));
        productInfo.addPrice(new ProductPrice("V",new BigDecimal("20.00")));
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("30.00")));
        StandardProductPricingManagerImplementation instance = new StandardProductPricingManagerImplementation();
        BigDecimal expResult = new BigDecimal("21.0000");
        BigDecimal result = instance.computeProductPrice(productInfo);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testComputeProductPriceLowSupplyLowDemand() throws Exception {
        System.out.println("computeProductPrice");
        ProductInfo productInfo = new ProductInfo("testprod1",Magnitude.LOW,Magnitude.LOW);
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("1.00")));
        productInfo.addPrice(new ProductPrice("CA",new BigDecimal("10.00")));
        productInfo.addPrice(new ProductPrice("T",new BigDecimal("10.00")));
        productInfo.addPrice(new ProductPrice("W",new BigDecimal("20.00")));
        productInfo.addPrice(new ProductPrice("Z",new BigDecimal("20.00")));
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("20.00")));
        productInfo.addPrice(new ProductPrice("V",new BigDecimal("20.00")));
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("30.00")));
        StandardProductPricingManagerImplementation instance = new StandardProductPricingManagerImplementation();
        BigDecimal expResult = new BigDecimal("22.0000");
        BigDecimal result = instance.computeProductPrice(productInfo);
        assertEquals(expResult, result);
    }
    
}
