package DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class ReadFromPdf {

	public static void main(String[] args) throws Throwable {
		
		File fis=new File("./src/test/resources/Programsoncollection.pdf");
				PDDocument doc=PDDocument.load(fis);
				int pages=doc.getNumberOfPages();
				System.out.println(pages);
				
				PDFTextStripper pdfdata=new PDFTextStripper();
				//String data = pdfdata.getText(doc);
				//System.out.println(data);

				 pdfdata.setStartPage(2);
				 String read = pdfdata.getText(doc);
				System.out.println(read);

	}

}
