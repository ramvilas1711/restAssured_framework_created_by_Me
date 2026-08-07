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

import java.util.ResourceBundle;

// Userendpoints class for CRUD operation

public class userEndPoints2 {

	public static ResourceBundle getURL(){
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	
	public static Response createUser(User payload) {
		
		String postURL = getURL().getString("post_URL");
		
   Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		//.post(Routes.post_URL); another way to call from routes.properties file
		.post(postURL);
		
		return response;
	}
	
	public static Response readUser(String userName) {
		
		String get_URL = getURL().getString("get_URL");
		
		Response response = given()
				.pathParam("username", userName)
				
				.when()
				//.get(Routes.get_URL);another way to call from routes.properties file
				.get(get_URL);
		
		return response;
	}
	
	public static Response updateUser(String userName , User payloads) {
		
		String update_URL = getURL().getString("update_URL");
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payloads)
				
				.when()
				//.put(Routes.update_URL); another way to call from routes.properties file
				.put(update_URL);
				
				return response;
	}
	
	public static Response deleteUser(String userName) {
		
		String delete_URL = getURL().getString("delete_URL");
		
		Response response = given()
				.pathParam("username", userName)
				
				.when()
				//.delete(Routes.delete_URL); another way to call from routes.properties file
				.delete(delete_URL);
		
		return response;
		
	}
	
}
