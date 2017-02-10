package ru.mail.test.drivers;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.mail.test.constants.Constants;

public class WebDrivers {
	
	Constants constants = new Constants();
	
	public WebDriver fireFoxDriver(String url) {
		WebDriver driver = new FirefoxDriver();
		driver.get(constants.url);
		return driver;
	}
}
