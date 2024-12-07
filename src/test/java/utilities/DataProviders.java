package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// Data provider 1

	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException 
	{
		
		String path = ".\\testData\\OpenCart.xlsx"; // taking xl file from test data

		ExcelUtility xlutil = new ExcelUtility(path); // creating an object for ExcelUtility

		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		String logindata[][] = new String[totalrows][totalcols];// create for two dimention array which is

		for (int i = 1; i <= totalrows; i++) // 1 //read the data from xl storing in 2D array
		{
			for (int j = 0; j < totalcols; j++) // 0 //i is row and j is col
			{
				logindata[i - j][j] = xlutil.getCellData("Sheet1", i, j); // 1,0
			}
		}

		return logindata; // returning 2D array

	}
	
	// Data provider 2
	// Data provider 3
	// Data provider 4

}
