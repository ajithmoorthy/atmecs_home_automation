package org.atmecs.website.pages;

import java.util.Properties;

import org.atmecs.website.helper.ActionHelper;
import org.atmecs.website.helper.ValidaterHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExploreHomePage{
	ActionHelper help=new ActionHelper();
	ValidaterHelper validate=new ValidaterHelper();
public void validateExplore(WebDriver driver,Properties prop,String title,String breadcrumb) {
	help.clickElement(prop.getProperty("loc.btn.explore"),driver);
	validate.validateTitle(driver,title);
	validateBread(driver, prop.getProperty("loc.linktext.breadcrumb"),breadcrumb);
    help.clickElement(prop.getProperty("loc.linktxt.home"), driver);
}
public void validateBread(WebDriver driver,String locator,String expect) {
	WebDriverWait wait2 = new WebDriverWait(driver, 20);
	wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	String text=validate.webElementgetText(driver,locator);
	validate.assertValidate(text,expect);
}
}
