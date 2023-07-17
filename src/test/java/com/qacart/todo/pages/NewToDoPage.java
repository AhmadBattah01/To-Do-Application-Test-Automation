package com.qacart.todo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;

public class NewToDoPage extends BasePage {

	public NewToDoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "[data-testid=\"new-todo\"]")
	private WebElement newTodoInput;
	
	@FindBy(css = "[data-testid=\"submit-newTask\"]")
	private WebElement submitButton;
	
	public NewToDoPage load(){
		driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.NEW_TODO_PAGE_ENDPOINT);
		return this;
	}
	
	public ToDoPage addNewTask(String item) {
		newTodoInput.sendKeys(item);
		submitButton.click();
		return new ToDoPage(driver);
	}

}
