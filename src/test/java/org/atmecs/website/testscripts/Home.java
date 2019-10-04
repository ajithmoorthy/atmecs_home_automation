package org.atmecs.website.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.atmecs.website.constants.FileConstants;
import org.atmecs.website.helper.ActionHelper;
import org.atmecs.website.helper.ValidaterHelper;
import org.atmecs.website.pages.ExploreHomePage;
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
	ExploreHomePage explore=new ExploreHomePage();
	public int index=0;
	@DataProvider(name = "breadcrumbdata")
	public String[][] getValidationData() throws IOException {
		String Excelarray[][] = null;
		Excelarray = excelread.excelDataProviderArray(FileConstants.TEST_PATH);
		return Excelarray;
	}
	@Test(dataProvider="breadcrumbdata")
	public void homeValidation(String title,String breadcrumb) throws IOException, InterruptedException {
		Properties prop=propread.KeyValueLoader(FileConstants.HOME_PATH);
		while(index<=5) {
		if(index==0) {
			explore.validateExplore(driver, prop, title,breadcrumb);
			index++;
		}
		else {
		home.pageValidation(driver, prop,title,breadcrumb,index);
		index++;
		}
		}

	}

}
