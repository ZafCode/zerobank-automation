package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityStepDefs {
    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().savings.click();
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        String actualTitle = Driver.get().getTitle();
        Assert.assertTrue(actualTitle.contains("Activity"));
    }

    @Then("Account drop down should have Savings selected")
    public void account_drop_down_should_have_Savings_selected() {

        Select dropDown = new Select(new AccountActivityPage().accountDropDwn);
        String selectedMenu = dropDown.getFirstSelectedOption().getText();
        String expectedMenu = "Savings";
        Assert.assertEquals(expectedMenu,selectedMenu);
    }

    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().brokerage.click();
    }

    @Then("Account drop down should have Brokerage selected")
    public void account_drop_down_should_have_Brokerage_selected() {
        Select dropDown = new Select(new AccountActivityPage().accountDropDwn);
        String selectedMenu = dropDown.getFirstSelectedOption().getText();
        String expectedMenu = "Brokerage";
        Assert.assertEquals(expectedMenu,selectedMenu);
    }

    @When("the user clicks on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().checking.click();
    }

    @Then("Account drop down should have Checking selected")
    public void account_drop_down_should_have_Checking_selected() {
        Select dropDown = new Select(new AccountActivityPage().accountDropDwn);
        String selectedMenu = dropDown.getFirstSelectedOption().getText();
        String expectedMenu = "Checking";
        Assert.assertEquals(expectedMenu,selectedMenu);
    }

    @When("the user clicks on Credit card link on the Account Summary page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().creditCard.click();
    }

    @Then("Account drop down should have Credit Card selected")
    public void account_drop_down_should_have_Credit_Card_selected() {
        Select dropDown = new Select(new AccountActivityPage().accountDropDwn);
        String selectedMenu = dropDown.getFirstSelectedOption().getText();
        String expectedMenu = "Credit Card";
        Assert.assertEquals(expectedMenu,selectedMenu);
    }

    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().loan.click();
    }

    @Then("Account drop down should have Loan selected")
    public void account_drop_down_should_have_Loan_selected() {
        Select dropDown = new Select(new AccountActivityPage().accountDropDwn);
        String selectedMenu = dropDown.getFirstSelectedOption().getText();
        String expectedMenu = "Loan";
        Assert.assertEquals(expectedMenu,selectedMenu);
    }

}
