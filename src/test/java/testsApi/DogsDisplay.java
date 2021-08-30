package testsApi;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import helpers.DogServiceHelper;
import utils.BaseReport;

public class DogsDisplay extends BaseReport {

	private DogServiceHelper dogservice;

	@Test
	public void displayDogs() {// performs api request to display all dogs in console
		test = report.startTest("Test: Display all dogs");
		dogservice = new DogServiceHelper();

		test.log(LogStatus.INFO, dogservice.displayALLDogs());

	}

}
