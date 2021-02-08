package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.text.SimpleDateFormat;
import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(id= "aa_accountId")
    public WebElement accountDropDwn;

    @FindBy(id= "aa_accountId")
    public List<WebElement> dropDownMenu;

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
    public List<WebElement> descriptionResult;

    @FindBy(xpath = "//*[@id=\"all_transactions_for_account\"]/table/tbody/tr/td[3]")
    public List<WebElement> valueOfDeposit;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[4]")
    public List<WebElement> valueOfWithdrawal;

    @FindBy(id ="aa_type")
    public WebElement selectType;

    @FindBy(xpath = "//thead/tr/th")
    public List<WebElement> columnNames ;






    public static boolean comp_Dates(String date) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

            String FromDate = "2012-09-01";
            String ToDate = "2014-09-06";

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


}
