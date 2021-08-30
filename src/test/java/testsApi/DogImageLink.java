package testsApi;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import helpers.DogServiceHelper;
import utils.BaseReport;

public class DogImageLink extends BaseReport {
	private DogServiceHelper dogservice;

	@Test
	public void displayBreed() {// displays link of image on console
		test = report.startTest("Test: Display specific Breed image link");
		dogservice = new DogServiceHelper();
		test.log(LogStatus.INFO, dogservice.bringBackDogImage("retriever"));
	}

}
