package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.xyz.qa.base.TestBase;

public class DepositPage extends TestBase {

    // Page Factory - OR:
    @FindBy(xpath="//input[@placeholder='amount']")
    WebElement depositAmountInput;
    
    @FindBy(xpath="//button[@type='submit']")
    WebElement depositButton;
    
    @FindBy(xpath="//span[@class='error ng-binding']")
    WebElement depositStatusMessage;
    
    @FindBy(xpath="//button[normalize-space()='Transactions']")
    WebElement transcationclick;
    
    @FindBy(xpath="//strong[@class = 'ng-binding'][2]")
    WebElement currentBalance;

     

    public DepositPage(){
        PageFactory.initElements(driver, this);
    }
    
    public void enterDepositAmount(String amount) {
        depositAmountInput.sendKeys(amount);
    }
    
    public void clickDepositButton() {
        depositButton.click();
    }
    
    public String getDepositStatusMessage() {
        return depositStatusMessage.getText();
    }
    
   
    public String getcurrentbalance() {
    	return currentBalance.getText();
    }
//    public String getLastTransactionAmount() {
//      return lastTransactionAmount.getText();
//  }
    

}
