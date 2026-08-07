package api.endpoints;

//get - https://petstore.swagger.io/v2/user/{usernmae}
//post - https://petstore.swagger.io/v2/user
//update - https://petstore.swagger.io/v2/user/{username}
//delete - https://petstore.swagger.io/v2/user/{username}
//main url = https://petstore.swagger.io/v2


public class Routes {
	
	public static String base_URL = "https://petstore.swagger.io/v2";
	
	// for User model	
	public static String post_URL = base_URL+"/user";	
	public static String get_URL = base_URL+"/user/{username}";
	public static String update_URL = base_URL+"/user/{username}";
	public static String delete_URL = base_URL+"/user/{username}";

}
