package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PayBillsPage extends BasePage{

    @FindBy(id="pay_bills_tab")
    public WebElement payBills;

    @FindBy(linkText = "Add New Payee")
    public WebElement addNewPayee;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddress;

    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccount;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetails;

    @FindBy(id = "add_new_payee")
    public WebElement addButton;

    @FindBy(id ="alert_content")
    public WebElement addPayeeMsg;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement purchaseForeignCurrency;

    @FindBy(id = "pc_currency")
    public List<WebElement> currency;

    @FindBy(id ="pc_amount")
    public WebElement amount;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostsBtn;

    @FindBy(id = "sp_amount")
    public WebElement amountInputBox;

    @FindBy(id = "sp_date")
    public WebElement dateInputBox;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(xpath = "//div[@id='alert_content']/span")
    public WebElement paymentMessage;




    public void addPayee(String payName, String payAddress, String account, String details){
        BrowserUtils.waitForClickablility(addNewPayee,4);
        payeeName.sendKeys(payName);
        payeeAddress.sendKeys(payAddress);
        payeeAccount.sendKeys(account);
        payeeDetails.sendKeys(details);
        addButton.click();
    }

}
