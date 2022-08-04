package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//https://www.youtube.com/watch?v=NhiIAZRoc0g --> 32mins
public class ConfigReader {
	private Properties prop;
	/*
	 * This is used to load prop file
	 */
	
	public Properties init_prop(){
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/com/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
