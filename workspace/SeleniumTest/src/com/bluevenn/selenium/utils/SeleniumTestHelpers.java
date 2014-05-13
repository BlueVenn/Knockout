package com.bluevenn.selenium.utils; 

import java.net.URL;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebDriver;

public class SeleniumTestHelpers 
{
	// Get base URL of the application
	public static String getBaseUrl()
	{
		// Get server name
		String serverName = getSeleniumConfiguration().getServerName();
		return String.format( "http://%1$s/knockout/knockout.html" , serverName);
	}
	
	// Get the selenium configuration settings
	private static SeleniumConfiguration seleniumConfiguration;
	public static SeleniumConfiguration getSeleniumConfiguration() 
	{
		// If not set up do so now
		if( seleniumConfiguration == null )
		{
			seleniumConfiguration = new SeleniumConfiguration();
		}		
		return seleniumConfiguration;
	}
			
	// Get the current active web driver	
	private static WebDriver webDriver;
	public static WebDriver getWebDriver() 
	{
		// If not set up do so now
		if( webDriver == null )
		{
			webDriver = new ChromeDriver();
		}		
		return webDriver;
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
		if( webDriver != null )
		{
			try
			{
				webDriver.quit();
			}
			catch( Exception ex )
			{
				// Don't care just trying to clear down 
			}
			webDriver = null;			
		}
		
		// Now we have fully cleared down restart
		getWebDriver();
	}
	
	// Get a path for a class
    public static String whereFrom(Object o) 
    {
	  if ( o == null ) 
	  {
	    return null;
	  }
	  Class<?> c = o.getClass();
	  ClassLoader loader = c.getClassLoader();
	  if ( loader == null ) {
	    // Try the bootstrap loader - obtained from the System Class Loader.
	    loader = ClassLoader.getSystemClassLoader();
	    while ( loader != null && loader.getParent() != null ) {
	      loader = loader.getParent();
	    }
	  }
	  if (loader != null) {
	    String name = c.getCanonicalName();
	    URL resource = loader.getResource(name.replace(".", "/") + ".class");
	    if ( resource != null ) {
	      return resource.toString();
	    }
	  }
	  return "Unknown";
   	}    	
}
