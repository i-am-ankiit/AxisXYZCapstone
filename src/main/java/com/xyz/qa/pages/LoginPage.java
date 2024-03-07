package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import com.xyz.qa.base.TestBase;
public class LoginPage extends TestBase {

	
	
			@FindBy(xpath="//button[normalize-space()='Customer Login']")
			WebElement customerLoginBtn;
			
			@FindBy(xpath="//select[@id='userSelect']")
			WebElement namedropdown;
			

            @FindBy(xpath="//button[normalize-space()='Login']")
            WebElement loginButton;  
            
            @FindBy(xpath="//button[normalize-space()='Logout']")
            WebElement logoutButton;
          
            
            //constructor to initialize elements
            public LoginPage(){
    			PageFactory.initElements(driver, this);
    		}
            
            public void customerLogin(){
                
                customerLoginBtn.click();
            
            }
            public String loginPageTitle() {
            	return driver.getTitle();
            }
            
            public void selectCustomer(String customerName){
                Select select = new Select(namedropdown);
                select.selectByVisibleText(customerName);
                
            }
            
            public void clickLoginButton(){
            	loginButton.click();
            }
            
            // Method to perform customer login using provided customer name.
            // Returns a CustomerAccountPage object after successful login.
            public CustomerAccountPage loginAsCustomer(String customerName) {
                customerLogin();
                selectCustomer(customerName);
                clickLoginButton();
                return new CustomerAccountPage();
            }
            
            
}