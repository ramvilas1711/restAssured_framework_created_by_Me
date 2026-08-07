package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class dataDrivenTests {
	
	@Test(priority=1,dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String userId, String username, String firstName, String lastName, String email, String password, String phone) {
		
		User userPayloads = new User();
		userPayloads.setId(Integer.parseInt(userId));
		userPayloads.setUsername(username);
		userPayloads.setFirstName(firstName);
		userPayloads.setLastName(lastName);
		userPayloads.setEmail(email);
		userPayloads.setPassword(password);
		userPayloads.setPhone(phone);
		
		
		Response response = userEndPoints.createUser(userPayloads);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority=2 ,dataProvider = "UserNames", dataProviderClass= DataProviders.class)
	public void testDeleteUserByName(String username) {
		
		Response response = userEndPoints.deleteUser(username);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
