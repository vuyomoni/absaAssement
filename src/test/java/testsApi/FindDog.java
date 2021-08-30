package testsApi;

import helpers.DogServiceHelper;
import utils.BaseReport;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.Test;

public class FindDog extends BaseReport {

	private DogServiceHelper dogservice;

	@Test
	public void displayDogs() {// performs api request to display all dogs and find one in the list
		test = report.startTest("Test: Find specific dog");
		String dogBreed = "retriever";
		dogservice = new DogServiceHelper();
		Boolean dogIsInListMessage = dogservice.FindDog(dogBreed);
		assertTrue(dogBreed + " The retriver is not within list", dogIsInListMessage);
		test.log(LogStatus.PASS, "Verify " + dogBreed + " is withing list");
	}

}
