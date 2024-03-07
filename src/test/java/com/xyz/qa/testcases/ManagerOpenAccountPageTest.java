package com.xyz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.ManagerOpenAccountPage;

public class ManagerOpenAccountPageTest extends TestBase {
    ManagerOpenAccountPage openAccountPage;
    
    public ManagerOpenAccountPageTest() {
        super();
    }
    
    @BeforeMethod
    public void setUp() {
        initialization();
        openAccountPage = new ManagerOpenAccountPage(); 
    }
    
    @Test
    public void verifyOpenAccountAlertMessage() {
        // Click on Bank Manager Login
        openAccountPage.BankManagerLogin();
        
        // Click on Open Account
        openAccountPage.openAccount();
        
        // Select customer name from dropdown
        openAccountPage.selectCustomerName("Harry Potter");
        
        // Select currency from dropdown
        openAccountPage.selectCurrency("Dollar");
        
        // Click on Process button
        openAccountPage.clickProcessButton();
        
        // Get the alert message text
        String alertMessage = openAccountPage.getAlertMessageText();
        
        // Assert the alert message text
        Assert.assertTrue(alertMessage.contains("Account created successfully"));
        
        // Click OK on the alert
        openAccountPage.acceptAlert();
    }
    
    @Test
    public void verifyOpenAccountAlertMessage1() {
        // Click on Bank Manager Login
        openAccountPage.BankManagerLogin();
        
        // Click on Open Account
        openAccountPage.openAccount();
        
        // Click on Process button without selecting customer name and currency
        openAccountPage.clickProcessButton();
        
        // Get the alert message text
//        String alertMessage = openAccountPage.getAlertMessageText();
//        

        String warningMessage = openAccountPage.getWarningMessage();
        Assert.assertEquals(warningMessage, "Please select an item in the list.");
        
        // Click OK on the alert
       // openAccountPage.acceptAlert();
    }
    
  //  @AfterMethod
   // public void tearDown() {
   //     driver.quit();
   // }
}
