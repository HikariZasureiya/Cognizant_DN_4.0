package ex1.verifying;


public class MyService {
	ExternalApi api;
	MyService(ExternalApi api){
		this.api = api;
	}
	
	public String fetchData(){
		return this.api.getData();
	}
}
