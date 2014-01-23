package elancesmk.crossref.excel2xml;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import elancesmk.crossref.dao.CrossRefReportDOI;

/**
 * This Class uses 
 * @author Shirshendu Shekhar Das
 *
 */
public class ExcelUtilities {
	
	public List<CrossRefReportDOI> readExcel(String strFileName)throws IOException, BiffException{
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(strFileName));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		Sheet sheet=workbook.getSheet(0);
		String cellContent=sheet.getCell(0, 0).getContents();
		System.out.println(cellContent);
		List<CrossRefReportDOI> crossRefReportDOIs=new ArrayList<CrossRefReportDOI>();		
		for(int rowCount =1;!cellContent.isEmpty();rowCount++){
			Cell[] rowCells=sheet.getRow(rowCount);
			cellContent=rowCells[0].getContents();

			int colCount=1;
			CrossRefReportDOI crossRefReportDOI=new CrossRefReportDOI();
			for(Cell cell:rowCells){
				if(colCount<=5){
					try{
						String authorCellContent=cell.getContents();
						crossRefReportDOI.addAuthor(cell.getContents());						
					}catch(NullPointerException ne){
						ne.printStackTrace();
					}
				}else if(colCount==6)crossRefReportDOI.setYearOfPublication(cell.getContents());
				else if (colCount==7)crossRefReportDOI.setTitle(cell.getContents());
				else if (colCount==8)crossRefReportDOI.setUrl(cell.getContents());
				else if (colCount==9)crossRefReportDOI.setDoi(cell.getContents());				
				colCount++;
			}
			System.out.println("Json of entry: "+new Gson().toJson(crossRefReportDOI));
			crossRefReportDOIs.add(crossRefReportDOI);
		}
		return crossRefReportDOIs;
	}
	
	public String generateXMLFiles(List<CrossRefReportDOI> crossRefReportDOIs){
		if(crossRefReportDOIs==null)throw new NullPointerException("No Entries sent for conversion to XMl");
		StringBuffer bodyXml=new StringBuffer();
		for(CrossRefReportDOI crossRefReportDOI:crossRefReportDOIs){
			//TODO Prepare the contributor section
			StringBuffer authorXML=new StringBuffer();
			for(String author:crossRefReportDOI.getAuthors()){
				String newContributorSection=Constants.contributorXml;
				String[] authorNames=author.split(",", 1);
				newContributorSection=newContributorSection.replaceAll("[FN]", authorNames.length<2?author:authorNames[0]);
				newContributorSection=newContributorSection.replaceAll("[LN]", authorNames.length<2?"  ":authorNames[1]);
				authorXML.append(newContributorSection);
			}
			//TODO Prepare the body section
			String newBodySection=Constants.bodyXML;
			newBodySection=newBodySection.replaceAll("[AUTHORS]", authorXML.toString());
			newBodySection=newBodySection.replaceAll("[TITLE]", crossRefReportDOI.getTitle());
			newBodySection=newBodySection.replaceAll("[YOP]", crossRefReportDOI.getYearOfPublication());
			newBodySection=newBodySection.replaceAll("[DOI]", crossRefReportDOI.getDoi());
			newBodySection=newBodySection.replaceAll("[URL]", crossRefReportDOI.getUrl());
			bodyXml.append(newBodySection);
			
		}
		
		//TODO Prepare the Head Section
		String headSection=Constants.mainXml;
		headSection=headSection.replace("[BODY]", bodyXml.toString());
		headSection=headSection.replace("[TIMESTAMP]", new Timestamp(new Date().getTime()).toString());
		System.out.println(headSection.toString());
		return headSection;
		
	}
}
