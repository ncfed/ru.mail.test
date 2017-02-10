package ru.mail.test.main;

import java.io.IOException;

import ru.mail.test.constants.Constants;
import ru.mail.test.drivers.WebDrivers;
import ru.mail.test.authorization.Authorization;

public class Main {
	
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		Constants constants = new Constants();
		WebDrivers driver = new WebDrivers();
		Authorization authorization = new Authorization();
		authorization.loginAndSend(constants.user, constants.password);
	}
	
}
