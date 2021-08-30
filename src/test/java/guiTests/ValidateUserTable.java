package guiTests;

import static org.testng.AssertJUnit.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import helpers.DogServiceHelper;
import model.WebTablesPage;
import model.AddUserPage;
import utils.BaseTest;

public class ValidateUserTable extends BaseTest {
	@Test
	public void ValidateUsersAdded() { // Displays a specific breed
		test = report.startTest("Test: Users have been added");
		WebTablesPage TablePage = new WebTablesPage();

		assertTrue("Assert Table is not displayed", TablePage.SmartTable.isDisplayed());
		assertTrue("Assert Table is not displayed", TablePage.addButton.isDisplayed());
		TablePage.addButton.click();
		AddUserPage AddUserPage = new AddUserPage();
		AddUserPage.addUser();

		test.log(LogStatus.INFO, "Table was displayed");

	}

}