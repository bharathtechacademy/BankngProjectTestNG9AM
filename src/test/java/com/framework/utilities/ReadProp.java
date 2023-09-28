package com.framework.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProp {
	
	//will have common method to read data from properties file
	
	public static Properties readData(String filename) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(filename); //read the file 
			prop.load(fis);//load all properties from file into variable
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

}
