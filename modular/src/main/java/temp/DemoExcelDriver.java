package temp;

import utility.ExcelDriver;

public class DemoExcelDriver {

	public static void main(String[] args) {
		
		try {
			
			String filename = System.getProperty("user.dir")+"/output/testdata.xlsx";
			
			String sSheetName = "Test Data";
			ExcelDriver excelDriver = new ExcelDriver();
			
			excelDriver.createExcelWorkbook(filename);
			
			excelDriver.openExcelWorkbook(filename);
			
			excelDriver.createSheet(sSheetName);
			
			excelDriver.setCellData(sSheetName, 1, 1, "Saurabh");
			excelDriver.setCellData(sSheetName, 1, 2, "Dhingra");
			
			excelDriver.setCellData(sSheetName, 2, 1, "Rahul");
			excelDriver.setCellData(sSheetName, 2, 2, "Grover");
			
			excelDriver.save();
			
			excelDriver.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
