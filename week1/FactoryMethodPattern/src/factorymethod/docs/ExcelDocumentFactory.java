package factorymethod.docs;

public class ExcelDocumentFactory extends DocumentFactory{
	public Document createDocument() {
		this.doc = new ExcelDocument();
		return this.doc;
	}	
}
