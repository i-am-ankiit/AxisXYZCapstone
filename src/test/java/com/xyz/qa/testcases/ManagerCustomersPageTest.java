package com.xyz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.ManagerCustomersPage;

public class ManagerCustomersPageTest extends TestBase {
    ManagerCustomersPage customersPage;
    
    public ManagerCustomersPageTest() {
        super();
    }
    
    @BeforeMethod
    public void setUp() {
        initialization();
        customersPage = new ManagerCustomersPage(); 
    }
    
    @Test
    public void verifyCustomerDetailsAndDelete() {
        // Click on Bank Manager Login
        customersPage.BankManagerLogin();
        
        // Click on Customers
        customersPage.clickCustomers();
        
        
        customersPage.fnamesort();
        
        // Search for customer by name
        customersPage.searchCustomer("Albus");
        
        // Verify customer details
        String firstName = customersPage.getFirstName();
        String lastName = customersPage.getLastName();
        String postCode = customersPage.getPostCode();
        String accountNumber = customersPage.getAccountNumber();
        
        Assert.assertEquals(firstName, "Albus");
        Assert.assertEquals(lastName, "Dumbledore");
        Assert.assertEquals(postCode, "E55656");
        Assert.assertEquals(accountNumber, "1010 1011 1012");
        
        // Click on Delete
        customersPage.clickDelete();
    }
    
   // @AfterMethod
   // public void tearDown() {
    //    driver.quit();
   // }
}
