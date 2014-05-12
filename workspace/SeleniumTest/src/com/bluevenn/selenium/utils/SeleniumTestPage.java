package com.bluevenn.selenium.utils;

import java.util.*;
import org.openqa.selenium.*;

// Base page class to control all manipulation of elements on pages simplifies 
// and centralises all request for control over page elements
public class SeleniumTestPage
{
	// Members
	protected final WebDriver webDriver;
	protected Hashtable<String, WebElement> pageControlIds;
	
	// Class constructor
	public SeleniumTestPage()
	{
		webDriver = SeleniumTestHelpers.getWebDriver();
		
		// Initialise the dictionary
		pageControlIds = new Hashtable<String,WebElement>();
	}
	
	// Get / Set Text
	public String getText( String elementName )
	{
		WebElement currElement = pageControlIds.get( elementName );
		return currElement.getText();
	}
	public void setText( String elementName, String textValue )
	{
		WebElement currElement = pageControlIds.get( elementName );
		currElement.clear();
		currElement.sendKeys(textValue);
	}
	
	// Get / Set Checkbox
	public boolean getChecked( String elementName )
	{
		WebElement currElement = pageControlIds.get( elementName );
		return currElement.isSelected();
	}
	public void setChecked( String elementName, boolean checkedValue )
	{
		WebElement currElement = pageControlIds.get( elementName );
		if( currElement.isSelected() != checkedValue )
			currElement.click();
	}
	
	// Click Element
	public void clickElement( String elementName )
	{
		WebElement currElement = pageControlIds.get( elementName );
		currElement.click();
	}

	// Get element enabled state
	public boolean getEnabled( String elementName )
	{
		WebElement currElement = pageControlIds.get( elementName );
		return currElement.isEnabled();		
	}	
}
