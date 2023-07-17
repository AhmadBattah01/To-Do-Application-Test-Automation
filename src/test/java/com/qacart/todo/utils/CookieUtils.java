package com.qacart.todo.utils;

import java.util.ArrayList;
import java.util.List;

import io.restassured.http.Cookie;

public class CookieUtils {

	public static List<org.openqa.selenium.Cookie> convertRestAssuredCookiesToSeleniumCookies(List<Cookie> restAssuredCookies) {
		List<org.openqa.selenium.Cookie> seleniumCookies =new ArrayList<>();
		for (io.restassured.http.Cookie cookie : restAssuredCookies) {
		    org.openqa.selenium.Cookie seleniumCookie = new org.openqa.selenium.Cookie(cookie.getName(),cookie.getValue());
		    seleniumCookies.add(seleniumCookie);
		}
		return seleniumCookies;
	}
}
