package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import api.endpoints.userEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
		
	Faker faker;
	User userPayloads;
	public Logger logger;
	
	@BeforeClass
	public void setupData() {
		
		faker = new Faker();
		userPayloads = new User();
		
		userPayloads.setId(faker.idNumber().hashCode());
		userPayloads.setUsername(faker.name().username());
		userPayloads.setFirstName(faker.name().firstName());
		userPayloads.setLastName(faker.name().lastName());
		userPayloads.setEmail(faker.internet().safeEmailAddress());
		userPayloads.setPassword(faker.internet().password(5,10));
		userPayloads.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger = LogManager.getLogger(this.getClass());
	}

	@Test(priority=1)
	public void testPostUser() {
		
		logger.info("==================reading user info====================");
		
		Response response = userEndPoints2.createUser(userPayloads);
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		
		logger.info("================== user info display===================");
	}
	
	@Test(priority=2)
	public void testGetUserByName() {
		
		logger.info("================== GetUserByName===================");
		
		Response response = userEndPoints2.readUser(this.userPayloads.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("================== display GetUserByName===================");
		
	}
	
	@Test(priority=3)
	public void testUpdateUserByName() {
		
		logger.info("================== UpdateUserByName===================");
		
		userPayloads.setFirstName(faker.name().firstName());
		userPayloads.setLastName(faker.name().lastName());
		userPayloads.setEmail(faker.internet().safeEmailAddress());
		Response response = userEndPoints2.updateUser(this.userPayloads.getUsername(), userPayloads);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response afterResponse = userEndPoints2.readUser(this.userPayloads.getUsername());
		
		afterResponse.then().log().all();
		
		Assert.assertEquals(afterResponse.getStatusCode(), 200);
		
		logger.info("==================display UpdateUserByName===================");
	}
	
	@Test(priority=4)
	public void testDeleteByUser() {
		
		logger.info("==================DeleteByUser===================");
		
		Response response = userEndPoints2.deleteUser(this.userPayloads.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("==================display DeleteByUser===================");
		
	}
}
