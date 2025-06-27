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
	
	//act
    @Test
    public void calculation() {
    	res = cal.mul(3,23);
    	cal = null;
    }
    
    
    //assert
    @AfterEach
	public void makecal1() {
		assertTrue(70 > res);
		assertNull(cal);
	}
}
