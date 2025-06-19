package singleton.Logger;

public class Main {

	public static void main(String[] args) {
		
		//test object init
		Test test = new Test();
		
		// logger instances
		Logger log1 = Logger.getInstance();
		Logger log2 = Logger.getInstance();
		Logger log3 = Logger.getInstance();
		
		//checks if the instance is same
		test.UniqueInstanceChecker(log1);
		test.UniqueInstanceChecker(log2);
		test.UniqueInstanceChecker(log3);	
	}
}
