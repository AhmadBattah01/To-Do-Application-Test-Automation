package com.qacart.todo.testcases;

import org.testng.annotations.Test;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import junit.framework.Assert;
@Feature("Auth Feature")
public class LoginTest extends BaseTest{
	@Story("login with email and password")
	@Test (description = "Test the login functionality with email and password")
	public void shouldBeAbleToLoginWithEmailAndPassword() {
		LoginPage LoginPage = new LoginPage(getDriver());
		Assert.assertTrue(
				LoginPage
				.load()
				.login(ConfigUtils.getInstance().getEmail(),ConfigUtils.getInstance().getPassword())
				.isWelcomeMessageDisplayed());	
	}
	
			
}
