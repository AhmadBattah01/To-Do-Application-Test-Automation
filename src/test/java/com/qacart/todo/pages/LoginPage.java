package com.qacart.todo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;

public class LoginPage extends BasePage {

	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "[data-testid=\"email\"]")
	private WebElement emailInput;
	
	@FindBy(css = "[data-testid=\"password\"]")
	private WebElement passwordInput;
	
	@FindBy(css = "[data-testid=\"submit\"]")
	private WebElement submitButton;
	
	public ToDoPage login(String email , String password) {
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);
		submitButton.click();
		return new ToDoPage(driver);
	}
	
	public LoginPage load(){
		driver.get(ConfigUtils.getInstance().getBaseUrl());
		return this;
	}
	
}
