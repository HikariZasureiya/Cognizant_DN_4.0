package factorymethod.docs;

public class WordDocumentFactory extends DocumentFactory {
	public Document createDocument() {
		this.doc = new WordDocument();
		return this.doc;
	}	
}
