package com.bluevenn.test.knockout;

import org.junit.*;
import org.hamcrest.Matchers;

import com.thoughtworks.selenium.*;
import com.bluevenn.selenium.utils.SeleniumTestHelpers;
import com.bluevenn.test.knockout.pages.*;

public class EditPersonViewTest extends SeleneseTestBase 
{
	private static EditPersonViewPage editPage;
	
	@BeforeClass
	public static void testClassSetup() 
	{
		// Set up the web driver
		SeleniumTestHelpers.getWebDriver();
	}
	
	@Before
	public void testSetup() 
	{
		// Set up the page view
		editPage = new EditPersonViewPage();
	}	
	
	@Test
	public void saveEnabledIfAllValid() 
	{
		// Populate the form and ensure cancel enabled
		editPage.setText( "first name", "Fred" );
		editPage.setText( "last name", "Bloggs" );
		editPage.setText( "age", "32" );
		Assert.assertThat( editPage.getEnabled( "save button" ), Matchers.equalTo(false) );
	}
	
	@Test
	public void saveDisabledIfNoAge() 
	{
		// Populate the form and ensure cancel enabled
		editPage.setText( "first name", "Fred" );
		editPage.setText( "last name", "Bloggs" );
		editPage.setText( "age", "32" );
		Assert.assertThat( editPage.getEnabled( "save button" ), Matchers.equalTo(true) );
		editPage.setText( "age", "" );
		Assert.assertThat( editPage.getEnabled( "save button" ), Matchers.equalTo(false) );
	}
	
	@After
	public void testTeardown() 
	{
		// Perform any post-each-test-in-the-class cleanup
		
	}	
	
	@AfterClass
	public static void testClassTeardown() 
	{
		// Clear up the web driver
		SeleniumTestHelpers.resetDriver();
	}
}
