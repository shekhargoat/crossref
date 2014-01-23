package elancesmk.crossref.main;

import java.io.IOException;

import jxl.read.biff.BiffException;
import elancesmk.crossref.excel2xml.ExcelUtilities;

public class CrossRefMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExcelUtilities excelUtilities=new ExcelUtilities();
		try {
			excelUtilities.generateXMLFiles(excelUtilities.readExcel("D:\\Elance Projects\\ICTSD - DOI upload onto Crossref\\DOI_EntryReady.xls"));
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
