package com.zerobank.pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[1]")
    public List<WebElement> dates;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[1]")
    public List<WebElement> dateList;

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

    @FindBy (xpath = "//td/a")
    public List<WebElement> links;






    public boolean comp_Dates(String date, String fromDate, String toDate) throws ParseException {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

            String FromDate = fromDate;
            String ToDate = toDate;

            java.util.Date Fdate = fmt.parse(FromDate);
            java.util.Date Tdate = fmt.parse(ToDate);
            java.util.Date ActualDate = fmt.parse(date);

            if (ActualDate.compareTo(Fdate)>=0 && ActualDate.compareTo(Tdate)<=0 ){
                return true;
            }
        } catch (Exception FAIL) {
            System.out.println(FAIL);
        }
        return false;
    }


    public List<Date> getWeblements(List<WebElement> parListElement){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        List<Date> dateList = new ArrayList<>();
        try{
            for (WebElement webElement : parListElement) {
                dateList.add(dateFormat.parse(webElement.getText()));
            }

        }catch (ParseException e){
            e.printStackTrace();
        }
        return dateList;
    }


}
