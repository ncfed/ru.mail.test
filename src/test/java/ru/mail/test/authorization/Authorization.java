package ru.mail.test.authorization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.mail.test.constants.Constants;
import ru.mail.test.drivers.WebDrivers;

public class Authorization {
	
	Constants constants = new Constants();
	WebDrivers webDrivers = new WebDrivers();
	
	public void loginAndSend(String user, String password) {
		WebDriver driver = webDrivers.fireFoxDriver(constants.url);
		driver.findElement(By.name("Login")).sendKeys(constants.user);
		driver.findElement(By.name("Password")).sendKeys(constants.password);
		driver.findElement(By.id("mailbox__auth__button")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.className("b-toolbar__item")).click();
		driver.findElement(By.name("To")).sendKeys(constants.email);
		driver.findElement(By.name("Subject")).sendKeys("Test");
		driver.findElement(By.name("send")).click();
	}

}
