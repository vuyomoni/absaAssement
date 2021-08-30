package model;

import org.openqa.selenium.WebElement;


import utils.ElementFetch;

public class WebTablesPage {
public	WebElement SmartTable = ElementFetch.getWebElement("CLASSNAME", "smart-table");
public	WebElement addButton = ElementFetch.getWebElement("XPATH", "//button[@class='btn btn-link pull-right']s");

}
