package com.awfi.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class ConfigReader {

	private Properties properties;

	public ConfigReader() {
		properties = new Properties();
		try {
			ClassLoader classLoader = ConfigReader.class.getClassLoader();
			URL resourceURL = classLoader.getResource("config.properties");
			String filePath = new File(resourceURL.getFile()).getAbsolutePath();

			FileInputStream fileInputStream = new FileInputStream(filePath);
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

}
