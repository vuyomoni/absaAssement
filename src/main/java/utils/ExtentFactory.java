package utils;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {

	public static ExtentReports getReportInstance() {
		ExtentReports extent;
		String Path = System.getProperty("user.dir") + "/ReportResults.html";
		extent = new ExtentReports(Path, false);

		return extent;
	}
}
