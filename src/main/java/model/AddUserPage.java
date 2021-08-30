package model;

import static org.testng.AssertJUnit.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import utils.ElementFetch;

public class AddUserPage {
	public WebElement FirtName_textbox = ElementFetch.getWebElement("NAME", "FirstName");
	public WebElement LastName_textbox = ElementFetch.getWebElement("NAME", "LastName");
	public WebElement UserName_textbox = ElementFetch.getWebElement("NAME", "UserName");
	public WebElement Password_textbox = ElementFetch.getWebElement("NAME", "Password");
	public List<WebElement> RadiButtons = ElementFetch.getWebElements("NAME", "optionsRadios");

	public Select Role = new Select(ElementFetch.getWebElement("NAME", "RoleId"));
//Select drpCountry = new Select(driver.findElement(By.name("country")));
	public WebElement Phone = ElementFetch.getWebElement("NAME", "Mobilephone");
	public WebElement Email = ElementFetch.getWebElement("NAME", "Email");
	public WebElement SaveButton = ElementFetch.getWebElement("XPATH", "//button[@class='btn btn-success']");
	WebTablesPage TablePage;
	public WebElement CloseButton = ElementFetch.getWebElement("CLASSNAME", "btn-danger");

	public AddUserPage() {
		TablePage = new WebTablesPage();
	}

	public void addUser() {

		JSONParser jsonParser = new JSONParser();
		try {

			JSONArray ArrayUsers = (JSONArray) jsonParser
					.parse(new FileReader(System.getProperty("user.dir") + "/UsersTestData.json"));
			for (int i = 0; i < ArrayUsers.size(); i++) {

				JSONObject UsersObject = (JSONObject) ArrayUsers.get(i);
				JSONObject Users = (JSONObject) UsersObject.get("user");
				String Firstname = (String) Users.get("FirstName");
				String LastName = (String) Users.get("LastName");
				String email = (String) Users.get("Email");
				String phone = (String) Users.get("Cell");
				String Roles = (String) Users.get("Role");
				String Password = (String) Users.get("Password");
				String Customer = (String) Users.get("Customer");
				String userName = (String) Users.get("UserName") + Math.random() * 100;
				JSONObject User = (JSONObject) Users.get("user");

				FirtName_textbox = ElementFetch.getWebElement("NAME", "FirstName");
				LastName_textbox = ElementFetch.getWebElement("NAME", "LastName");
				UserName_textbox = ElementFetch.getWebElement("NAME", "UserName");
				Password_textbox = ElementFetch.getWebElement("NAME", "Password");
				RadiButtons = ElementFetch.getWebElements("NAME", "optionsRadios");
				Role = new Select(ElementFetch.getWebElement("NAME", "RoleId"));
				Email = ElementFetch.getWebElement("NAME", "Email");
				Phone = ElementFetch.getWebElement("NAME", "Mobilephone");
				SaveButton = ElementFetch.getWebElement("XPATH", "//button[@class='btn btn-success']");
				FirtName_textbox.clear();
				FirtName_textbox.sendKeys(Firstname);
				LastName_textbox.clear();
				LastName_textbox.sendKeys(LastName);
				UserName_textbox.clear();
				UserName_textbox.sendKeys(userName);
				Password_textbox.clear();
				Password_textbox.sendKeys(Password);

				if (Roles.equals("Admin")) {
					Role.selectByIndex(2);
					;
				} else if (Roles.equals("Sales Team")) {
					Role.selectByIndex(0);
				} else {
					Role.selectByIndex(1);
				}
				if (Customer.equals("Company AAA")) {
					RadiButtons.get(0).click();
				} else {
					RadiButtons.get(1).click();
				}
				Email.clear();
				Email.sendKeys(email);
				Phone.clear();
				Phone.sendKeys(phone);
				SaveButton.click();
				assertTrue("Assert Table is not displayed", TablePage.SmartTable.isDisplayed());
				assertTrue(Firstname + " User does not appear on list",
						this.CheckUsers(Firstname, LastName, userName, email, phone, Roles));
				WebElement RedifinedSaveButton = ElementFetch.getWebElement("XPATH",
						"//button[@class='btn btn-link pull-right']");
				RedifinedSaveButton.click();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public Boolean CheckUsers(String FirstName, String LastName, String Username, String email, String Phone,
			String role) {

		List<WebElement> rows = TablePage.SmartTable.findElements(By.tagName("tr"));
		String RowValues = "";
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				// System.out.print(col.getText() + "\t");
				RowValues += " " + col.getText();
			}
			if (this.CheckValueinString(RowValues, FirstName) && this.CheckValueinString(RowValues, LastName)
					&& this.CheckValueinString(RowValues, Username) && this.CheckValueinString(RowValues, email)
					&& this.CheckValueinString(RowValues, Phone) && this.CheckValueinString(RowValues, role)) {
				return true;
			}
			// System.out.println();
		}
		return false;

	}

	public Boolean CheckValueinString(String Test, String Value) {
		String pattern = "\\b" + Value + "\\b";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(Test);
		return m.find();
	}
}
