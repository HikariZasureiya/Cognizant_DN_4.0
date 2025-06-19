package Search.functions;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {
	
	public static void main(String args[]) {
		Product prodarr[] = new Product[5];
		prodarr[0] = new Product(10 , "p1" , "c1");
		prodarr[1] = new Product(5 , "p2" , "c1");
		prodarr[2] = new Product(1 , "p3" , "c2");
		prodarr[3] = new Product(20 , "p5" , "c2");
		prodarr[4] = new Product(69 , "p420" , "c1");
	
		ArrayList<Product> arraylistprod = new ArrayList<Product>(Arrays.asList(prodarr));
		
		LinearSearch lin = new LinearSearch();
		BinarySearch bin = new BinarySearch();
		
		
		Product p1 = lin.LinearSearchById(arraylistprod, 20);
		p1.showDetails();
		Product p2 = bin.BinarySearchById(arraylistprod, 69);
		p2.showDetails();
	}
	
	
}
