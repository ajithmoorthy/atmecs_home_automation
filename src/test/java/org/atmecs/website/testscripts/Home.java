package org.atmecs.website.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.atmecs.website.constants.FileConstants;
import org.atmecs.website.helper.ActionHelper;
import org.atmecs.website.helper.ValidaterHelper;
import org.atmecs.website.pages.HomePage;
import org.atmecs.website.testbase.TestBase;
import org.atmecs.website.utils.ExcelReader;
import org.atmecs.website.utils.PropertiesReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Home extends TestBase {
	PropertiesReader propread=new PropertiesReader();
	ActionHelper help=new ActionHelper();
	ValidaterHelper validate=new ValidaterHelper();
	HomePage home=new HomePage();
	ExcelReader excelread=new ExcelReader();
	@DataProvider(name = "breadcrumbdata")
	public String[][] getValidationData() throws IOException {
		String Excelarray[][] = null;
		Excelarray = excelread.excelDataProviderArray(FileConstants.TEST_PATH);
		return Excelarray;
	}
	@Test(dataProvider="breadcrumbdata")
	public void homeValidation(String title1,String title2,String title3,String title4,String title5,String title6,String title7,String bread1,String bread2,String bread3,String bread4,String bread5,String bread6) throws IOException, InterruptedException {
		Properties prop=propread.KeyValueLoader(FileConstants.HOME_PATH);
		logger=extentObject.startTest("Home page validation");
		home.pageValidation(driver, prop,title1,title2,title3,title4,title5,title6,title7,bread1,bread2,bread3,bread4,bread5,bread6);	
	}

}
