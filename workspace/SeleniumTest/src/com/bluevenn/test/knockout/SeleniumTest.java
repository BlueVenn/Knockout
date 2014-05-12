package com.bluevenn.test.knockout;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

import com.bluevenn.selenium.utils.*;

public class SeleniumTest {

	public static void main(String[] args) 
	{
		WebDriver activeWebDriver = SeleniumTestHelpers.getWebDriver();
		activeWebDriver.get("http://localhost/knockout/knockout.html");
		
		Assert.assertThat( activeWebDriver.getTitle(), Matchers.equalTo("Simple Knockout Example") );
		
		WebElement firstNameElement = activeWebDriver.findElement(By.id("fname"));
		firstNameElement.sendKeys("Bambam");
		WebElement surnameElement = activeWebDriver.findElement(By.id("lname"));
		surnameElement.sendKeys("Rubble");
		
		activeWebDriver.quit();
	}
}
