package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Locale;

public class FindTransactionsDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new LoginStepDef().the_user_is_logged_in();
        new AccountActivityPage().accountActivity.click();
        new AccountActivityPage().findTransactions.click();
        BrowserUtils.waitFor(2);
        String subTitle = new AccountActivityPage().findTransactionsTitle.getText();
        System.out.println("subTitle = " + subTitle);
        Assert.assertTrue(subTitle.contains("Find Transactions"));

    }

    @When("the user enters date range from “{int}-{int}-{int}” to “{int}-{int}-{int}”")
    public void the_user_enters_date_range_from_to(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6) {
        BrowserUtils.waitFor(2);
        new AccountActivityPage().fromDate.sendKeys();
        new AccountActivityPage().toDate.sendKeys();
    }


    @And("clicks search")
    public void clicks_search() {
        BrowserUtils.waitFor(2);
        new AccountActivityPage().findButton.click();
    }

    @Then("results table should only show transactions dates between “{int}-{int}-{int}” to “{int}-{int}-{int}”")
    public void results_table_should_only_show_transactions_dates_between_to(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6) {
        List<WebElement> Date = new AccountActivityPage().dates;

        for (int i = 0; i < Date.size(); i++) {
            String date = Date.get(i).getText();
            new AccountActivityPage().comp_Dates(date);
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String str) {
        BrowserUtils.waitFor(2);
        new AccountActivityPage().description.clear();
        new AccountActivityPage().description.sendKeys(str.toUpperCase(Locale.ROOT));

    }
    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String str) {
        BrowserUtils.waitFor(2);
        List<WebElement> descWithOnline = Driver.get().findElements(By.xpath("//*[@id=\"filtered_transactions_for_account\"]/table/tbody/tr/td[2]"));

        for (WebElement element : descWithOnline) {
            System.out.println("element.getText() = " + element.getText());
            Assert.assertTrue(element.getText().contains(str));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String str) {
        BrowserUtils.waitFor(2);
        List<WebElement> descWithOffice = Driver.get().findElements(By.xpath("//*[@id=\"filtered_transactions_for_account\"]/table/tbody/tr/td[2]"));
        for (WebElement element : descWithOffice) {
            Assert.assertTrue(element.getText().contains(str));

        }
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        BrowserUtils.waitFor(2);
        List<WebElement> valueOfDeposit = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[3]"));
        for (WebElement elementDeposit : valueOfDeposit) {
            System.out.println("elementDeposit.getText() = " + elementDeposit.getText());
            Assert.assertTrue(elementDeposit.isDisplayed());
        }
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        BrowserUtils.waitFor(2);
        List<WebElement> valueOfDeposit = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[4]"));
        for (WebElement elementWithdrawal : valueOfDeposit) {
            System.out.println("elementWithdrawal.getText() = " + elementWithdrawal.getText());
            Assert.assertTrue(elementWithdrawal.isDisplayed());
        }
    }

    @When("user selects type “Deposit”")
    public void user_selects_type_Deposit() {
        Select typeDropDown = new Select(new AccountActivityPage().selectType);
        typeDropDown.selectByVisibleText("Deposit");
        new AccountActivityPage().findButton.click();
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        List<WebElement> valueOfDeposit = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[4]"));
        for (WebElement elementWithdrawal : valueOfDeposit) {
            System.out.println("elementWithdrawal.getText() = " + elementWithdrawal.getText());
            Assert.assertFalse(!elementWithdrawal.isDisplayed());
        }
    }

    @When("user selects type “Withdrawal”")
    public void user_selects_type_Withdrawal() {
        Select typeDropDown = new Select(new AccountActivityPage().selectType);
        typeDropDown.selectByVisibleText("Withdrawal");
        new AccountActivityPage().findButton.click();
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        List<WebElement> valueOfDeposit = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[4]"));
        for (WebElement elementDeposit : valueOfDeposit) {
            System.out.println("elementDeposit.getText() = " + elementDeposit.getText());
            Assert.assertFalse(!elementDeposit.isDisplayed());
        }
    }



}
