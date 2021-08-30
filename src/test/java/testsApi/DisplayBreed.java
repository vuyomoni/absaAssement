package testsApi;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import helpers.DogServiceHelper;
import utils.BaseReport;

public class DisplayBreed extends BaseReport {
	private DogServiceHelper dogservice;

	@Test
	public void displayBreed() { // Displays a specific breed
		test = report.startTest("Test: Display specific Breed");
		dogservice = new DogServiceHelper();
		test.log(LogStatus.INFO, dogservice.displaySingleBreed("retriever"));

	}

}
