package helpers;

import static org.testng.AssertJUnit.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.ConfigManager;
import utils.Utils;
import org.apache.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import constants.EndPoint;

public class DogServiceHelper {
// fetch the data from endpoints
	// we need to read config variables
	// Rest assure about URL ,port

	public String displayALLDogs() {
		RestAssured.baseURI = EndPoint.Get_All_Dogs;
		Response response = RestAssured.given().contentType(ContentType.JSON).get().andReturn();
		assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
		System.out.println(response.asPrettyString());
		return response.asPrettyString();
	}

	public String displaySingleBreed(String breed) {
		RestAssured.baseURI = EndPoint.Get_Single_Dog.replace("{name}", breed);

		Response response = RestAssured.given().contentType(ContentType.JSON).get().andReturn();
		// assertTrue(response.getStatusCode()== HttpStatus.SC_OK);
		System.out.println(response.asPrettyString());
		return response.asPrettyString();

	}

	public String bringBackDogImage(String breed) {
		RestAssured.baseURI = EndPoint.Get_dog_image.replace("{name}", breed);

		Response response = RestAssured.given().contentType(ContentType.JSON).get().andReturn();
		assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
		System.out.println(response.asPrettyString());
		return response.asPrettyString();
	}

	public Boolean FindDog(String breed) {
		RestAssured.baseURI = EndPoint.Get_All_Dogs;

		Response response = RestAssured.given().contentType(ContentType.JSON).get().andReturn();
		assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
		// System.out.println(response.asPrettyString());
		String message = response.jsonPath().getString("message");
		return Utils.FindValueInString(message, breed);
	}

}
