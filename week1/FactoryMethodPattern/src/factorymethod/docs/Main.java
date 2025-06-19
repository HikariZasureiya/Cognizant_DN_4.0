package factorymethod.docs;

public class Main {

	public static void main(String[] args) {
		
		//instantiating documents
		WordDocumentFactory wrdf = new WordDocumentFactory();
		PdfDocumentFactory pdff = new PdfDocumentFactory();
		ExcelDocumentFactory exclf = new ExcelDocumentFactory();
	
		//factory creates instances
		Document word = wrdf.createDocument();
		Document pdf = pdff.createDocument();
		Document excel = exclf.createDocument();
	
		//mentions their types
		word.doctypeis();
		pdf.doctypeis();
		excel.doctypeis();
	}

}
