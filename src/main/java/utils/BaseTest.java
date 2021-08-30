package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;

public class BaseTest {
	public static WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
    public static	ExtentTest logger;

	@BeforeMethod
	public void beforeTestMethod() {
		this.setUpDriver("chrome");
		report = ExtentFactory.getReportInstance();
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
		
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			
			String screenshotPath = this.getScreenhot(driver, result.getName());
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}

		
		
		report.endTest(test);
		report.flush();
		driver.quit();

	}

	public void setUpDriver(String BrowserName) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		opt.addArguments("disable-extensions");
		opt.addArguments("--start-maximized");
//			opt.addArguments("--start-maximized");
//			opt.addArguments("--start-maximized");
//			opt.addArguments("--start-maximized");
		capabilities.setCapability(ChromeOptions.CAPABILITY, opt);
		driver = new ChromeDriver(opt);

	}

	public String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

}
