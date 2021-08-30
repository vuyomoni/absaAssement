package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseTest;

public class ElementFetch {
	public static WebElement getWebElement(String IdentifierType, String Identifiervalue) {
		switch (IdentifierType) {
		case "ID":
			return BaseTest.driver.findElement(By.id(Identifiervalue));

		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(Identifiervalue));
		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(Identifiervalue));
		case "TAGNAME":
			return BaseTest.driver.findElement(By.tagName(Identifiervalue));
		case "lINKTEXT":
			return BaseTest.driver.findElement(By.linkText(Identifiervalue));
		case "CLASSNAME":
			return BaseTest.driver.findElement(By.className(Identifiervalue));
		case "NAME":
			return BaseTest.driver.findElement(By.name(Identifiervalue));

		}
		return null;
	}

	public static List<WebElement> getWebElements(String IdentifierType, String Identifiervalue) {
		switch (IdentifierType) {
		case "ID":
			return BaseTest.driver.findElements(By.id(Identifiervalue));

		case "CSS":
			return BaseTest.driver.findElements(By.cssSelector(Identifiervalue));
		case "XPATH":
			return BaseTest.driver.findElements(By.xpath(Identifiervalue));
		case "TAGNAME":
			return BaseTest.driver.findElements(By.tagName(Identifiervalue));
		case "lINKTEXT":
			return BaseTest.driver.findElements(By.linkText(Identifiervalue));
		case "CLASSNAME":
			return BaseTest.driver.findElements(By.className(Identifiervalue));
		case "NAME":
			return BaseTest.driver.findElements(By.name(Identifiervalue));
		}
		return null;
	}

	public static void clickretry(WebElement w) {
		WebElement element = new WebDriverWait(BaseTest.driver, 10).until(ExpectedConditions.elementToBeClickable(w));
		((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", element);
	}

}
