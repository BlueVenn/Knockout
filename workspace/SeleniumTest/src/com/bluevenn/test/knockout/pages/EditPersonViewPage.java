package com.bluevenn.test.knockout.pages;

import org.openqa.selenium.*;
import com.bluevenn.selenium.utils.*;

// Page class to control all manipulation of the edit view
public class EditPersonViewPage extends SeleniumTestPage
{
	// Class constructor
	public EditPersonViewPage()
	{
		super();
		
		// For now just reset the app back to the start page
		SeleniumTestHelpers.executeURL( SeleniumTestHelpers.getBaseUrl() );
		
		
		// Set up my control definitions
		pageControlIds.put( "first name", webDriver.findElement( By.id( "fname" ) ) );
		pageControlIds.put( "last name", webDriver.findElement( By.id( "lname" ) ) );
		pageControlIds.put( "age", webDriver.findElement( By.id( "age" ) ) );
		pageControlIds.put( "is flintstone name", webDriver.findElement( By.id( "isflinstone" ) ) );
		pageControlIds.put( "save button", webDriver.findElement( By.id( "addbtn" ) ) );
		pageControlIds.put( "cancel button", webDriver.findElement( By.id( "cancelbtn" ) ) );
		
		// Typical page set up example from Selenium...
		// Check that we're on the right page.
//        if (!"Login".equals(currentDriver.getTitle())) 
//        {
//            // Alternatively, we could navigate to the login page, perhaps logging out first
//            throw new IllegalStateException("This is not the login page");
//        }
	}	
}
