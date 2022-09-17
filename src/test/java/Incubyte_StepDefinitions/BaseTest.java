package Incubyte_StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import POM.Page;

public class BaseTest {

	public Page page;
	public WebDriver driver;
	public Properties prop;

	public BaseTest() {

		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream("src\\main\\resources\\Configuration\\config.properties");
					
			try {
				prop.load(ip);
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

}
