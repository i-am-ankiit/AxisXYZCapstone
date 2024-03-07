package com.xyz.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.CustomerAccountPage;
import com.xyz.qa.pages.LoginPage;
import com.xyz.qa.util.TestUtil;

public class CustomerAccountPageTest extends TestBase {
    LoginPage loginPage;
    CustomerAccountPage accountPage;
    
    public CustomerAccountPageTest() {
        super();
    }
    
    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        accountPage = loginPage.loginAsCustomer("Harry Potter");
        
    }
    
    @Test(priority=2)
    public void verifyCustomerAccountDetails() {
        String headerName = accountPage.getHeaderName();
        Assert.assertEquals(headerName, "XYZ Bank");

        String customerName = accountPage.getCustomerName();
        Assert.assertEquals(customerName, "Harry Potter");
        
        String CustomerAccDetails = accountPage.getAccountdetails();
        Assert.assertEquals(CustomerAccDetails,CustomerAccDetails );  
        System.out.println("Account details:"+CustomerAccDetails);
        
//        accountPage.clickDepositButton();
//        accountPage.clickWithdrawButton();
        
       
    }
    
//    @AfterMethod
//   public void tearDown() {
//        driver.quit();
//    }
}
