package singleton.Logger;


public class Logger {
	private static Logger loginstance = new Logger();
	
	private Logger() {
		System.out.println("logger constructor");
	}
	
	public static Logger getInstance() {
		return loginstance;
	}
	
	public void ALogMethod() {
		System.out.println("This is a method of the Logger");
	}
}


