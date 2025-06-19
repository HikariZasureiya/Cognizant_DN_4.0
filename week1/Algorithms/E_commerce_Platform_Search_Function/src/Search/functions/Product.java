package Search.functions;

public class Product {
		int productId;
		String productName;
		String category;
		
		Product(int productId , String productName , String category){
			this.productId = productId;
			this.productName = productName;
			this.category = category;
		}
		
		public void showDetails() {
			System.out.println("productId: "+this.productId+ "\n" + "productName: "+this.productName+ "\n" + "category: "+this.category+ "\n");
		}
}
