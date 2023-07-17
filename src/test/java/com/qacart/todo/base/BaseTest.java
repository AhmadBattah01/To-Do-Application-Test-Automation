package com.qacart.todo.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utils.CookieUtils;

import io.qameta.allure.Allure;
import io.restassured.http.Cookie;

public class BaseTest {
	protected ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}
	
	public WebDriver getDriver() {
		return this.driver.get();
	}
	
	@BeforeMethod
	public void setup() {
		WebDriver driver = new DriverFactory().initializeDriver();
		setDriver(driver);
	}
	
	@AfterMethod
	public void Teardown(ITestResult result) {
		String testCaseName = result.getMethod().getMethodName();
		File desFile = new File("screenshoot"+File.separator+testCaseName+".png");
		takeScreenshot(desFile);
		getDriver().quit();
	}
	
	public void injectCookiesToBrowser(List<Cookie> restAssuredCookies) {
		List<org.openqa.selenium.Cookie> seleniumCookies = CookieUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);
		for(org.openqa.selenium.Cookie cookie : seleniumCookies) {
			getDriver().manage().addCookie(cookie);
		}
	}
	
	public void takeScreenshot(File destFile) {
		File srcfile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile,destFile);
			InputStream inputStream = new FileInputStream(srcfile);
			Allure.addAttachment("screenshots", inputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
		
	
	
}
