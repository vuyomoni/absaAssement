package utils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseReport {
	public ExtentReports report;
	public ExtentTest test;

	@BeforeClass
	public void beforeClass() {
		report = ExtentFactory.getReportInstance();

	}

	@AfterClass
	public void afterClass() {
		report.endTest(test);
		report.flush();
	}
}
