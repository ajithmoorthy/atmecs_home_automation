package org.atmecs.website.pages;

import java.util.Properties;

import org.atmecs.website.helper.ActionHelper;
import org.atmecs.website.helper.ValidaterHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	ValidaterHelper validate=new ValidaterHelper();
	ActionHelper help= new ActionHelper();
	public void pageValidation(WebDriver driver,Properties prop,String title1,String title2,String title3,String title4,String title5,String title6,String title7,String bread1,String bread2,String bread3,String bread4,String bread5,String bread6) throws InterruptedException {
		driver.manage().window().maximize();
		validate.validateTitle(driver, title1);
		help.clickElement(prop.getProperty("loc.btn.explore"),driver);
		validate.validateTitle(driver,title2);
		validateBread(driver, prop.getProperty("loc.linktext.breadcrumb"),bread1);
		recurMethod(driver, prop);
		help.clickElement(prop.getProperty("loc.btn.moreinfo1"), driver);
		validate.validateTitle(driver, title3);
		validateBread(driver, prop.getProperty("loc.linktext.breadcrumb"),bread2);
		recurMethod(driver, prop);
		help.clickElement(prop.getProperty("loc.btn.moreinfo2"), driver);
		validate.validateTitle(driver,title4);
		validateBread(driver, prop.getProperty("loc.linktext.breadcrumb"),bread3);
		recurMethod(driver, prop);
		help.clickElement(prop.getProperty("loc.btn.moreinfo3"), driver);
		validate.validateTitle(driver,title5);
		validateBread(driver, prop.getProperty("loc.linktext.breadcrumb"),bread4);
		recurMethod(driver, prop);
		help.clickElement(prop.getProperty("loc.btn.moreinfo4"), driver);
		validate.validateTitle(driver,title6);
		validateBread(driver, prop.getProperty("loc.linktext.breadcrumb"),bread5);
		recurMethod(driver, prop);
		help.clickElement(prop.getProperty("loc.btn.moreinfo5"), driver);
		validate.validateTitle(driver,title7);
		validateBread(driver, prop.getProperty("loc.linktext.breadcrumb"), bread6);
	}
	public void recurMethod(WebDriver driver,Properties prop) {
		help.mouseOver(prop.getProperty("loc.linktxt.home"), driver);
		help.clickElement(prop.getProperty("loc.linktxt.home"), driver);
	}
	public void validateBread(WebDriver driver,String locator,String expect){
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		String text=validate.webElementgetText(driver,locator);
		validate.assertValidate(text,expect);
	}
}
