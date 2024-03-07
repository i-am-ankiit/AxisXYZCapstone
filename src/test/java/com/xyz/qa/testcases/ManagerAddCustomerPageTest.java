package com.xyz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.ManagerAddCustomerPage;

public class ManagerAddCustomerPageTest extends TestBase {
    ManagerAddCustomerPage addCustomerPage;
    
    public ManagerAddCustomerPageTest() {
        super();
    }
    
    @BeforeMethod
    public void setUp() {
        initialization();
        addCustomerPage = new ManagerAddCustomerPage(); 
    }
    
    @Test
    public void verifyAddCustomerAlertMessage() {
        
        addCustomerPage.BankManagerLogin();
        
        
        addCustomerPage.addCustomer();
        
        
        addCustomerPage.enterFirstName("Anup");
        addCustomerPage.enterLastName("Tyagi");
        addCustomerPage.enterPostCode("56090");
        
        
        addCustomerPage.clickAddCustomerButton();
        
        
        String alertMessage = addCustomerPage.getAlertMessageText();
        
       
        Assert.assertTrue(alertMessage.contains("Customer added successfully"));

        
        
        addCustomerPage.acceptAlert();
    }
    @Test
    public void verifyInvalidDataAlertMessage() {
        addCustomerPage.BankManagerLogin();
        addCustomerPage.addCustomer();
        // Invalid first name, last name, and postcode
        addCustomerPage.enterFirstName("0000");
        addCustomerPage.enterLastName("0000");
        addCustomerPage.enterPostCode("@#$%");
        addCustomerPage.clickAddCustomerButton();
        String alertMessage = addCustomerPage.getAlertMessageText();
        Assert.assertTrue(alertMessage.contains("Invalid data entered"));
        addCustomerPage.acceptAlert();
    }
    
  //  @AfterMethod
   // public void tearDown() {
   //     driver.quit();
   // }
}
