package com.qacart.todo.Api;

import static io.restassured.RestAssured.given;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.Task;
import com.qacart.todo.utils.ConfigUtils;

import io.restassured.response.Response;

public class TaskApi {
	public void addTask(String token) {
		Task task = new Task("learn selenium", false);
		
		Response response = given()
				.baseUri(ConfigUtils.getInstance().getBaseUrl())
				.header("Content-Type","application/json")
				.body(task)
				.auth().oauth2(token)		//bearer token
		.when()
				.post(EndPoint.API_TASK_ENDPOINT)
		.then()
				.log().all()
				.extract().response();
		
		if(response.statusCode() != 201) {
			throw new RuntimeException("something went wrong in adding todo");
		}
	}

}
