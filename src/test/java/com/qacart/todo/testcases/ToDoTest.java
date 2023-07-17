package com.qacart.todo.testcases;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.qacart.todo.Api.RegisterApi;
import com.qacart.todo.Api.TaskApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.NewToDoPage;
import com.qacart.todo.pages.ToDoPage;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;



@Feature("To do feature")
public class ToDoTest extends BaseTest{
	@Story("add todo")
	@Test (description = "Should be able to add new todo")
	public void ShouldBeAbleToAddNewToDo(){
		RegisterApi registerApi = new RegisterApi();
		registerApi.register();
		
		NewToDoPage newToDoPage = new NewToDoPage(getDriver());
		newToDoPage.load();
		injectCookiesToBrowser(registerApi.getCookies());
		AssertJUnit.assertEquals(
				newToDoPage.load()
				.addNewTask("learn selenium")
				.getTodoText(),"learn selenium");
	}
	@Story("delete todo")
	@Test (description ="should be able to delete todo")
	public void shouldBeAbleToDeleteToDo() {
		RegisterApi registerApi = new RegisterApi();
		registerApi.register();
		
		TaskApi taskApi = new TaskApi();
		taskApi.addTask(registerApi.getToken());
		
		ToDoPage toDoPage = new ToDoPage(getDriver());
		toDoPage.load();
		
		injectCookiesToBrowser(registerApi.getCookies());

		Assert.assertTrue(
				toDoPage
				.load()
				.clickOnDeleteButton()
				.isNoTodoMessageDisplayed());
		}
}
