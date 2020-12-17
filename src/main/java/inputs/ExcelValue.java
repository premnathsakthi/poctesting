package inputs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelValue {


	@DataProvider(name ="fetchData")
	
	public static String[][] getData() {
		
		String[][] value = null ;
		
		try {
			FileInputStream fis = new FileInputStream("./TestData/Book1.xlsx");
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
             XSSFSheet sheet = wb.getSheetAt(0);
			
			int rowCount = sheet.getLastRowNum();
			
			int columncount = sheet.getRow(0).getLastCellNum();
			
			value = new String[rowCount][columncount];
			
           for(int i=1;i<=rowCount;i++) {
				
				XSSFRow  row = sheet.getRow(i);
				
				for(int j=0; j<columncount;j++) {
					
					String cellData = row.getCell(j).getStringCellValue();
					
					System.out.println("The value of row "+i+" anc column "+j+" is : "+cellData);
					
					value[i-1][j]=cellData;
				}
				
			}
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return value;
	
}
}
