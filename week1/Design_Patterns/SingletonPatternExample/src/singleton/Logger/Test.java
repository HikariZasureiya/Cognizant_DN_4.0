package singleton.Logger;

public class Test {
	public Logger loggerid = Logger.getInstance();
	
	public void UniqueInstanceChecker(Logger instance) {
		
		// same logger instance has same object id.
		if( instance == loggerid) {
			System.out.println("Same logger instance");
		}
	}
	
	
	
	
}
