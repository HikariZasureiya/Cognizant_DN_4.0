package Search.functions;
import java.util.ArrayList;
import java.util.Iterator;

public class LinearSearch {
	public Product LinearSearchById(ArrayList<Product> arr , int id ){
		Iterator<Product> it = arr.iterator();
		int i = 0;
		while(it.hasNext()) {
			i++;
			Product prod = it.next(); 
			if( prod.productId == id) {
				System.out.println("found item at position: "+i);
				return prod;
			}
		}
		if( i == 0) {
			System.out.println("item not found");
			return null;
		}
		return null;
	}
}
