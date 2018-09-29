package temp;

import org.testng.annotations.Test;

import utility.DataProviderFromExcel;

public class DemoDataProvider {

	@Test(dataProvider="getData", dataProviderClass=DataProviderFromExcel.class)
	public void printTestData(String username, String password){
	
		System.out.println("Username : "+ username);
		
		System.out.println("Password : "+ password);
	}
}
