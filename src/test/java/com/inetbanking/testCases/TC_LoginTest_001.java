package com.inetbanking.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

class TC_LoginTest_001 extends TestBase {
	

@Test
public void loginTest() {
	
	driver.get(baseUrl);
	LoginPage lp = new LoginPage(driver);
	log.info("creating an obj")
	lp.setUserName(username);
	log.info("creating an obj")
	lp.setPassword(pwd);
	lp.clickSubmit();
	
	if(driver.getTitle().equals("guru99"))
	{
		Assert.assertTrue(true);
		
	}
	else  {
		
		Assert.assertTrue(false);
	}
	
}
	
}
