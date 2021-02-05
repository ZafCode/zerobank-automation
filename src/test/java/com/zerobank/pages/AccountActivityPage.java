package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(id= "aa_accountId")
    public WebElement accountDropDwn;

    @FindBy(id= "aa_accountId")
    public List<WebElement> dropDownMenu;

    @FindBy(linkText = "Account Activity")
    public WebElement accountActivity;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactions;

    @FindBy(xpath = "//div/h2[.='Find Transactions']")
    public WebElement findTransactionsTitle;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(xpath = "//div/button[@type='submit']")
    public WebElement findButton;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']/table/tbody/tr/td[1]")
    public List<WebElement> dates;

    @FindBy(id = "aa_description")
    public WebElement description;

    @FindBy(xpath = "//*[@id=\"filtered_transactions_for_account\"]/table/tbody/tr/td[2]")
    public WebElement descriptionResult;

    @FindBy(xpath = "//*[@id=\"all_transactions_for_account\"]/table/tbody/tr/td[3]")
    public WebElement valueOfDeposit;

    @FindBy(id ="aa_type")
    public WebElement selectType;








    public static boolean comp_Dates(String date) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

            String FromDate = "2012-09-01";
            String ToDate = "2012-09-06";

            java.util.Date Fdate = fmt.parse(FromDate);
            java.util.Date Tdate = fmt.parse(ToDate);
            java.util.Date ActualDate = fmt.parse(date);

            if (ActualDate.compareTo(Fdate) >= 0 && ActualDate.compareTo(Tdate) <= 0) {
                return true;
            }
        } catch (Exception FAIL) {
            System.out.println(FAIL);
        }
        return false;
    }



    public void navigateTo(String value){
        BrowserUtils.waitFor(4);
        Select dropDownMenu = new Select(accountDropDwn);
        dropDownMenu.selectByValue(value);
    }

    public String getText(){
        String actual = new Select(accountDropDwn).getFirstSelectedOption().getText();
        System.out.println("actual = " + actual);
        return actual;
    }

}
