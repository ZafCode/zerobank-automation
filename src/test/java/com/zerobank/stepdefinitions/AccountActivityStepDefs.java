package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;


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
    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String string) {
        String actualTitle = Driver.get().getTitle();
        Assert.assertTrue("Verify page title contain",actualTitle.contains(string));
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String string) {
        Select dropDown = new Select(new AccountActivityPage().accountDropDwn);
        String selectedMenu = dropDown.getFirstSelectedOption().getText();
        Assert.assertEquals("Verify selected menu",string,selectedMenu);
    }

    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().brokerage.click();
    }


    @When("the user clicks on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().checking.click();
    }


    @When("the user clicks on Credit card link on the Account Summary page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().creditCard.click();
    }

    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().loan.click();
    }



}
