package api.endpoints;
import org.testng.annotations.Test;

import api.payload.User;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

// Userendpoints class for CRUD operation

public class userEndPoints {

	public static Response createUser(User payload) {
		
   Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.post_URL);
		
		return response;
	}
	
	public static Response readUser(String userName) {
		
		Response response = given()
				.pathParam("username", userName)
				
				.when()
				.get(Routes.get_URL);
		
		return response;
	}
	
	public static Response updateUser(String userName , User payloads) {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payloads)
				
				.when()
				.put(Routes.update_URL);
				
				return response;
	}
	
	public static Response deleteUser(String userName) {
		
		Response response = given()
				.pathParam("username", userName)
				
				.when()
				.delete(Routes.delete_URL);
		
		return response;
		
	}
	
}
