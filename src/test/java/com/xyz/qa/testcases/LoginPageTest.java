package com.xyz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    
    public LoginPageTest() {
        super();
    }
    
    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage(); 
    }
    
    @Test
    public void loginPageTitleTest() {
        String title = loginPage.loginPageTitle();
        Assert.assertEquals(title, "XYZ Bank");
    }
    
    @Test
    public void customerLoginTest() {
        loginPage.customerLogin();
        
    }
    
    @Test(priority=1)
    public void loginTest() {
        loginPage.customerLogin();
        loginPage.selectCustomer("Harry Potter");
        loginPage.clickLoginButton();
        System.out.println("Login successful");
        // You can add assertions or further verifications here to ensure successful login
    }
    
   
 //   @AfterMethod
   // public void tearDown() {
   //     driver.quit();
  //  }
}
