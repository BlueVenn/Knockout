package com.bluevenn.selenium.utils; 

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebDriver;

public class SeleniumTestHelpers 
{
	// Get base URL of the application
	public static String getBaseUrl(){ return "http://localhost/knockout/knockout.html"; }
	
	// Get the current active web driver
	private static WebDriver m_WebDriver;
	public static WebDriver getWebDriver() 
	{
		// If not set up do so now
		if( m_WebDriver == null )
		{
			m_WebDriver = new ChromeDriver();
		}		
		return m_WebDriver;
	}
	
	// Connect to the root application URL
	public static WebDriver executeURL( String urlToExecute  )
	{
		WebDriver currDriver = getWebDriver();
		currDriver.get( urlToExecute );
		return currDriver;
	}
	
	// Close down and reset any existing driver
	public static void resetDriver()
	{
		if( m_WebDriver != null )
		{
			try
			{
				m_WebDriver.quit();
			}
			catch( Exception ex )
			{
				// Don't care just trying to clear down 
			}
			m_WebDriver = null;			
		}
		
		// Now we have fully cleared down restart
		getWebDriver();
	}
}
