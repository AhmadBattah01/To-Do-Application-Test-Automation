package com.qacart.todo.Api;

import java.util.List;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.UserUtils;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class RegisterApi {

	private static List<Cookie> restAssureCookies;
	private String accessToken;
	
	private String userId;
	
	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public List<Cookie> getCookies() {
		return restAssureCookies;
	}
	
	public String getToken() {
		return accessToken;
	}
	public void register(){
		User user = new UserUtils().generateRandomUser();
	
		Response response = RestAssured.
			given()
				.baseUri(ConfigUtils.getInstance().getBaseUrl())
				.header("Content-Type","application/json")
				.body(user)
				.log().all()
			.when()
				.post(EndPoint.API_REGISTER_ENDPOINT)
			.then()
				.log().all()
				.extract().response();
		if(response.statusCode() != 201) {
			throw new RuntimeException("Something went wrong with the request");
		}
				

		restAssureCookies = response.getDetailedCookies().asList();
		accessToken = response.path("access_token");
		userId= response.path("userID");
		firstName = response.path("firstName");
	}
	
}