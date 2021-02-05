package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {

        PageFactory.initElements(Driver.get(), this);

    }


    @FindBy(id ="signin_button")
    public WebElement signInBtn;

    @FindBy(id ="user_login")
    public WebElement usernameInput;

    @FindBy(id= "user_password")
    public WebElement passwordInput;

    @FindBy(name= "submit")
    public WebElement loginBtn;

    @FindBy(id = "details-button")
    public WebElement detailsBtn;

    @FindBy(id ="proceed-link")
    public WebElement proceedLink;

    @FindBy(xpath = "//div[contains(text(),'are wrong')]")
    public WebElement invalidLoginMsg;

    public void login(String username, String password){
        signInBtn.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
        detailsBtn.click();
        proceedLink.click();
    }

    public void loginInvalid(String username, String password){
        signInBtn.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
}
