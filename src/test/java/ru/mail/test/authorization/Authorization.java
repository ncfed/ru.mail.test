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
		driver.findElement(By.cssSelector("textarea[class*='js-input compose__labels__input']")).sendKeys(constants.email);
		driver.findElement(By.name("Subject")).sendKeys("Test letter");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id,'toolkit')]")));
		driver.findElement(By.id("tinymce")).sendKeys("Hello, quality assurance world!");
		driver.switchTo().parentFrame();
		driver.findElement(By.cssSelector("div[class*='b-toolbar__btn b-toolbar__btn_ b-toolbar__btn_false js-shortcut']")).click();
	}

}
