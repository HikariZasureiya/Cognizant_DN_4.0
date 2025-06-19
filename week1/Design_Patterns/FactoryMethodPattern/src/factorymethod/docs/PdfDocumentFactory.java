package factorymethod.docs;

public class PdfDocumentFactory extends DocumentFactory{
	public Document createDocument() {
		this.doc = new PdfDocument();
		return this.doc;
	}	
}
