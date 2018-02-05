package biller.kenneth.pricingengineexample.data;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Kenneth Biller
 */
public class ProductInfoTest {
    
    public ProductInfoTest() {
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

    /**
     * Test of getLowestPriceWithHighestCount method, of class ProductInfo.
     */
    @Test
    public void testGetLowestValidPriceWithHighestCount() {
        System.out.println("getLowestPriceWithHighestCount");
        ProductInfo productInfo = new ProductInfo("testprod1",Magnitude.HIGH,Magnitude.HIGH);
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("1")));
        productInfo.addPrice(new ProductPrice("CA",new BigDecimal("10")));
        productInfo.addPrice(new ProductPrice("T",new BigDecimal("10")));
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("20")));
        productInfo.addPrice(new ProductPrice("V",new BigDecimal("20")));
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("30")));
        BigDecimal expResult = new BigDecimal(10);
        BigDecimal result = productInfo.getLowestPriceWithHighestCount();
        assertEquals(expResult, result);
    }

        /**
     * Test of getLowestPriceWithHighestCount method, of class ProductInfo.
     */
    @Test
    public void testGetInvalidPricesExcluded() {
        System.out.println("getLowestPriceWithHighestCount");
        ProductInfo productInfo = new ProductInfo("testprod1",Magnitude.HIGH,Magnitude.HIGH);
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("1")));
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("1")));
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("1")));
        productInfo.addPrice(new ProductPrice("CA",new BigDecimal("10")));
        productInfo.addPrice(new ProductPrice("T",new BigDecimal("10")));
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("20")));
        productInfo.addPrice(new ProductPrice("V",new BigDecimal("20")));
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("30")));
        BigDecimal expResult = new BigDecimal(10);
        BigDecimal result = productInfo.getLowestPriceWithHighestCount();
        assertEquals(expResult, result);
    }
    /**
     * Test of getAveragePrice method, of class ProductInfo.
     */
    @Test
    public void testGetAveragePrice() {
        System.out.println("getAveragePrice");
        ProductInfo productInfo = new ProductInfo("testprod1",Magnitude.HIGH,Magnitude.HIGH);
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("1")));
        productInfo.addPrice(new ProductPrice("CA",new BigDecimal("10")));
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("20")));
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("30")));
        BigDecimal expResult = new BigDecimal("16");
        BigDecimal result = productInfo.getAveragePrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValidPrices method, of class ProductInfo.
     */
    @Test
    public void testGetValidPrices() {
        System.out.println("getValidPrices");
        ProductInfo productInfo = new ProductInfo("testprod1",Magnitude.HIGH,Magnitude.HIGH);
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("1")));
        productInfo.addPrice(new ProductPrice("CA",new BigDecimal("10")));
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("20")));
        productInfo.addPrice(new ProductPrice("CB",new BigDecimal("30")));
        List<ProductPrice> prices = productInfo.getValidPrices();
        assertEquals(2,prices.size());
    }
    
}
