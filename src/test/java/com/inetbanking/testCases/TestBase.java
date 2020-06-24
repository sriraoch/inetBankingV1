package com.inetbanking.testCases;


import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.log4testng.Logger;


public class TestBase {

public String baseUrl="https//www.google.com";
public String username="sc768h";
public String pwd="Hercules111";
public static WebDriver driver;
public static Logger logger;

@BeforeClass
public void setUp()
{
System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"Drivers//chromedriver.exe");	
		driver= new ChromeDriver();
		logger=Logger.getLogger();
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
}

@AfterClass
public void tearDown() {
	
	driver.quit();
}
}
