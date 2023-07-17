package com.qacart.todo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;

public class ToDoPage extends BasePage {

	public ToDoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "[data-testid=\"welcome\"]")
	private WebElement welcomeMessage;
	
	@FindBy(css = "[data-testid=\"add\"]")
	private WebElement addButton;
	
	@FindBy(css = "[data-testid=\"todo-text\"]")
	private WebElement toDoItem;
	
	@FindBy(css = "[data-testid=\"delete\"]")
	private WebElement deleteButton;
	
	@FindBy(css = "[data-testid=\"no-todos\"]")
	private WebElement noTodoMessageDisplayed;

	public ToDoPage load(){
		driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.TODO_PAGE_ENDPOINT);
		return this;
	}
	
	public boolean isWelcomeMessageDisplayed() {
		return welcomeMessage.isDisplayed();
	}
	
	public NewToDoPage clickOnAddButton() {
		addButton.click();
		return new NewToDoPage(driver);

	}
	public String getTodoText() {
		return toDoItem.getText();
	}
	
	public ToDoPage clickOnDeleteButton() {
		deleteButton.click();
		return new ToDoPage(driver);
	}
	public Boolean isNoTodoMessageDisplayed() {
		return noTodoMessageDisplayed.isDisplayed();
	}
}	

