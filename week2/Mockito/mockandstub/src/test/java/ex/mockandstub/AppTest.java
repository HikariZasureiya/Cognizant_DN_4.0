package ex.mockandstub;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit test for simple App.
 */
public class AppTest { 
		 @Test 
		 public void testExternalApi() { 
		 ExternalApi mockApi = Mockito.mock(ExternalApi.class); 
		 when(mockApi.getData()).thenReturn("Mock Data"); 
		 MyService service = new MyService(mockApi); 
		 String result = service.fetchData(); 
		 assertEquals("Mock Data", result); 
		 } 
}
