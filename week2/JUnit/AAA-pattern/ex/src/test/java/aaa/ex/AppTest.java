package aaa.ex;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AppTest {
	Calc cal;
	float res;
	
	
	//arrange
	@BeforeEach
	public void makecal() {
		cal = new Calc();
	}
	
	
    @Test
    public void calculation() {
    	//act
    	res = cal.mul(3,23);
    	
    	//assert
    	assertTrue(70 > res);
		assertNotNull(cal);
    	
    }
    
    
    //teardown
    @AfterEach
	public void makecal1() {
    	cal = null;	
	}
}
