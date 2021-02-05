package com.zerobank.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSummaryPage extends BasePage{

    @FindBy(xpath = "//td/a[.='Savings']")
    public WebElement savings;

    @FindBy(linkText = "Brokerage")
    public WebElement brokerage;

    @FindBy(linkText = "Checking")
    public WebElement checking;

    @FindBy(linkText = "Credit Card")
    public WebElement creditCard;

    @FindBy(linkText = "Loan")
    public WebElement loan;




}
