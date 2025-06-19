package Search.functions;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class customcomp implements Comparator<Product>{
	 @Override
     public int compare(Product obj1, Product obj2) {
         return Integer.compare(obj1.productId, obj2.productId);
     }
	
}
public class BinarySearch {
	public Product BinarySearchById(ArrayList<Product> arr , int id ){
		 Collections.sort(arr, new customcomp());
		 int l = 0;
		 int r = arr.size();
		 
		 while(l < r) {
			 int mid = l+(r-l)/2;
			 
			 if(arr.get(mid).productId == id) {
				 System.out.println("Found Item.");
				 return arr.get(mid);
			 }
			 if(arr.get(mid).productId < id) {
				 l = mid+1;
			 }
			 else
				 r = mid;
		 }
		 
		 System.out.println("Item not found.");
		 return null;	 
	}
}
