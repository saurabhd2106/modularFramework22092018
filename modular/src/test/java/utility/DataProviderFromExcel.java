package utility;

import java.util.Properties;
import org.testng.annotations.DataProvider;

public class DataProviderFromExcel {

	private ExcelDriver excelDriver;
	private String inputFilename;
	private String sheetName;
	private Properties configProperty;
	private String configFileName;

	public DataProviderFromExcel() throws Exception {

		configFileName = System.getProperty("user.dir")+"/config/config.properties";
		configProperty = ConfigReader.readProperties(configFileName);

		inputFilename = configProperty.getProperty("inputFileName");
		sheetName = configProperty.getProperty("inputSheetName");
	}

	@DataProvider
	public Object[][] getData() throws Exception {

		Object[][] data;

		excelDriver = new ExcelDriver();

		excelDriver.openExcelWorkbook(inputFilename);

		int numberOfRows = excelDriver.getRowCountoFSheet(sheetName);

		int numberOfCellInFirstRow = excelDriver.getCellCount(sheetName, 1);
		int numberOfCellInARow;

		data = new Object[numberOfRows + 1][numberOfCellInFirstRow];

		for (int iRow = 1; iRow <= numberOfRows + 1; iRow++) {

			numberOfCellInARow = excelDriver.getCellCount(sheetName, iRow);

			for (int iCell = 1; iCell <= numberOfCellInARow; iCell++) {

				data[iRow - 1][iCell - 1] = excelDriver.getCellData(sheetName, iRow, iCell);

			}
		}

		return data;

	}
}
