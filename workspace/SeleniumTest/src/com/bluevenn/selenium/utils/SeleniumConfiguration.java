package com.bluevenn.selenium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SeleniumConfiguration 
{
	private String configFileName = "Selenium.config"; 
	
	public SeleniumConfiguration()
	{
		// Assign sensible defaults
		serverName = "localhost";
		
		// Set up all values
		readConfig();
	}
	
	private String serverName;
	public String getServerName()
	{
		return this.serverName;
	}
	
    private void readConfig()
    {
        // Find the classpath as a start point for locating the config file
        String classPath = SeleniumTestHelpers.whereFrom(this);
        if( classPath == null )
        {
        	return;
        }
        if( classPath.startsWith("file:/" ) )
        	classPath = classPath.substring(6);
        String fileName;
        
        try
        {
        	// Locate the file by scanning up the classpath
        	do
        	{        		
        		int posOfLastSep = classPath.lastIndexOf("/");
        		if( posOfLastSep == -1 )
        		{
        			// File not found - stick with defaults
        			return;
        		}
        		
        		// Trim the string        	        		
        		classPath = classPath.substring(0, posOfLastSep );
        		fileName = String.format("%s/%s", classPath, configFileName );
        		
        		// Check file exists
        		File testFile = new File( fileName );
        		if( testFile.exists() )
        		{
        			break;
        		}        			        	
        	} while( true );
        		        	
            // Open the configuration file name
            InputStream configFileStream = new FileInputStream(fileName);
            Properties propVals = new Properties();

            // Load the properties file
            propVals.load( configFileStream );

            // Get the value for app.name key
            this.serverName = propVals.getProperty("app.servername");
            
            // Cleanup
            configFileStream.close();            
        } 
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }		
}
