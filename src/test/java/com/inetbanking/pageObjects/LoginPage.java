package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.testCases.TestBase;

public class LoginPage extends TestBase {
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
 @FindBy(name="uid")
 WebElement userId;
 
 @FindBy(name="password")
 WebElement pwd;
 
 @FindBy (name="btnLogin")
 WebElement btnLogin;


public void setUserName (String uname) {
	
	userId.sendKeys(uname);
}
public void setPassword(String pass) {
	
	pwd.sendKeys(pass);
}
public void clickSubmit() {
	
	btnLogin.click();
}


}

