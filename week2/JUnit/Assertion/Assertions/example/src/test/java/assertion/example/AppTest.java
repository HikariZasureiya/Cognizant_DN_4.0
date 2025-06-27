package assertion.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void multiplyTest() {
    	Calc oh = new Calc();
    	assertEquals(69 , oh.multiply(23, 3));
    }
    
    @Test
    public void trueornot() {
    	Calc oh = new Calc();
    	assertTrue(69 > oh.multiply(23, 3));
    }
    
    @Test
    public void falseornot() {
    	Calc oh = new Calc();
    	assertFalse(69 > oh.multiply(23, 3));
    }
    
    @Test
    public void nullornot() {
    	Calc oh = null;
    	assertNull(oh);
    }
    
    @Test
    public void notnullornot() {
    	Calc oh = new Calc();
    	assertNotNull(oh);
    }
    
    
    
    
}
