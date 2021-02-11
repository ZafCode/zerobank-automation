package com.zerobank.stepdefinitions;

import com.google.common.collect.Ordering;
import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class FindTransactionsDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new LoginStepDef().the_user_is_logged_in();
        new AccountActivityPage().navigateTo("Account Activity");
        new AccountActivityPage().findTransactions.click();
        BrowserUtils.waitFor(2);
        String subTitle = new AccountActivityPage().findTransactionsTitle.getText();
        System.out.println("subTitle = " + subTitle);
        assertTrue(subTitle.contains("Find Transactions"));

    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
       BrowserUtils.waitForVisibility(new AccountActivityPage().fromDate,5);
        new AccountActivityPage().fromDate.sendKeys(fromDate);
        new AccountActivityPage().toDate.sendKeys(toDate);
    }

    @And("clicks search")
    public void clicks_search() {
        BrowserUtils.waitFor(2);
        new AccountActivityPage().findButton.click();
        new AccountActivityPage().fromDate.clear();
        new AccountActivityPage().toDate.clear();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) throws ParseException {
        List<WebElement> Date = new AccountActivityPage().dates;
        BrowserUtils.waitFor(2);
        for (int i = 0; i < Date.size(); i++) {
            String date = Date.get(i).getText();
            System.out.println(date);
            boolean result = new AccountActivityPage().comp_Dates(date, fromDate, toDate);
            assertTrue(result);
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<Date> dateList = new AccountActivityPage().getWeblements(new AccountActivityPage().dateList);
        List<Date> sortedDateList = new AccountActivityPage().getWeblements(new AccountActivityPage().dateList);
        Collections.sort(sortedDateList);
        Collections.reverse(sortedDateList);
        System.out.println(dateList);
        System.out.println(sortedDateList);
        Assert.assertEquals(sortedDateList,dateList);
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        List<String> listOfDates = BrowserUtils.getElementsText(new AccountActivityPage().dateList);
        for (String listOfDate : listOfDates) {
            Assert.assertFalse(listOfDate.contains(date));
        }
    }


    @When("the user enters description {string}")
    public void the_user_enters_description(String str) {
        BrowserUtils.waitFor(2);
        new AccountActivityPage().description.clear();
        //new AccountActivityPage().description.sendKeys(str.toUpperCase(Locale.ROOT));
        new AccountActivityPage().description.sendKeys(str);

    }
    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String str) {
        BrowserUtils.waitFor(2);
        List<String> descWithOnline = BrowserUtils.getElementsText(new AccountActivityPage().descriptionResult);
        for (String element : descWithOnline) {
            System.out.println("element.getText() = " + element);
            assertTrue(element.contains(str));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String str) {
        BrowserUtils.waitFor(2);
       List<WebElement> descWithOffice = new AccountActivityPage().descriptionResult;
        for (WebElement element : descWithOffice) {
            assertTrue(!element.getText().contains(str));
        }
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        BrowserUtils.waitFor(2);
       List<WebElement> deposit = new AccountActivityPage().valueOfDeposit;
        assertTrue(deposit.size()>=0);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        BrowserUtils.waitFor(2);
        List<WebElement> withdrawal = new AccountActivityPage().valueOfWithdrawal;
        assertTrue(withdrawal.size()>=0);
    }

    @When("user selects type {string}")
    public void user_selects_type(String selectType) {
        Select typeDropDown = new Select(new AccountActivityPage().selectType);
        typeDropDown.selectByVisibleText(selectType);
        new AccountActivityPage().findButton.click();
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        List<WebElement> valueOfDeposit = new AccountActivityPage().valueOfWithdrawal;
        for (WebElement elementWithdrawal : valueOfDeposit) {
            System.out.println("elementWithdrawal.getText() = " + elementWithdrawal.getText());
            Assert.assertFalse(!elementWithdrawal.isDisplayed());
        }
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        List<WebElement> valueOfDeposit = new AccountActivityPage().valueOfDeposit;
        for (WebElement elementDeposit : valueOfDeposit) {
            System.out.println("elementDeposit.getText() = " + elementDeposit.getText());
            assertTrue(!elementDeposit.isDisplayed());
        }
    }



}
