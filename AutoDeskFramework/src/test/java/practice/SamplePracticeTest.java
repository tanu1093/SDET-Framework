package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.autodest.genericUtils.ExcelUtility;
import com.autodest.genericUtils.IConstant;

public class SamplePracticeTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String sheetName = "Sheet1";
		String expTestID = "tc_29";
		String expColHEader = "TestName";
		
		int expTestRow = 0;
		int expHeader = 0;
		FileInputStream fis = new FileInputStream(IConstant.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
	    
    for(int i=0; i<rowCount ; i++) {		
		Row row = sh.getRow(i);
		String zeroColData= row.getCell(0).getStringCellValue();
        if(expTestID.contentEquals(zeroColData)) {
        	//System.out.println("test is availbale");
        	expTestRow = i;
        	break;
        }
    }

    
    int expColHeader = expTestRow-1;
    
        int colCount = sh.getRow(expColHeader).getLastCellNum();
         for(int j=0 ; j <colCount ; j++) {
        	   String actColHeader = sh.getRow(expColHeader).getCell(j).getStringCellValue();
        	   if(actColHeader.equals(expColHEader)) {
        		        //System.out.println("header is avibale ");
        		        expHeader = j;
        		        break;
        	   }
         }
         

      
      String data = sh.getRow(expTestRow).getCell(expHeader).getStringCellValue();
      System.out.println(data);
    
	}

}
