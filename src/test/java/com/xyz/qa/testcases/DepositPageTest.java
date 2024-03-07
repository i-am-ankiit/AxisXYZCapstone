package com.xyz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.CustomerAccountPage;
import com.xyz.qa.pages.DepositPage;
import com.xyz.qa.pages.LoginPage;

public class DepositPageTest extends TestBase {
    LoginPage loginPage;
    CustomerAccountPage accountPage;
    DepositPage depositPage;
    
    public DepositPageTest() {
        super();
    }
    
    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage(); 
        accountPage = loginPage.loginAsCustomer("Harry Potter"); 
    }
    
    @Test(priority=3)
    public void depositAmountAndVerifyTransaction() {
        
        depositPage = accountPage.clickDepositButton();
        
        String[] amounts = {"1000","-1000"}; // Array of amounts to test
        
        for (String amount : amounts) {
            depositPage.enterDepositAmount(amount);
            depositPage.clickDepositButton();
            
            // For positive amounts, verify success message and last transaction amount
            if (!amount.startsWith("-")) {
                String depositStatusMessage = depositPage.getDepositStatusMessage();
                Assert.assertEquals(depositStatusMessage, "Deposit Successful");
                
                String Currentbalance = depositPage.getcurrentbalance();
                Assert.assertEquals(Currentbalance, "1000");
                
                // Verify the last transaction amount
//                depositPage.clicktranscation();
//                String lastTransactionAmount = depositPage.getLastTransactionAmount();                Assert.assertEquals(lastTransactionAmount,"1000"); 
            }
        }
    }
    


    
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
}
