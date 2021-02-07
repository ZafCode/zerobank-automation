package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AccountSummaryStepDefs {

    @Then("Account summary page should have the title {string}")
    public void account_summary_page_should_have_the_title(String expectedPageTitle) {
       String actualPageTitle = Driver.get().getTitle();
       Assert.assertEquals("Verify page title", expectedPageTitle,actualPageTitle);
    }

    @Then("Account summary page should have to following account types")
    public void account_summary_page_should_have_to_following_account_types(List<String> expectedAccountTypes) {
        List<String> actualAccountTypes = BrowserUtils.getElementsText(new AccountSummaryPage().accountTypes);
        System.out.println(expectedAccountTypes);
        System.out.println(actualAccountTypes);
        Assert.assertEquals("Verify account types", expectedAccountTypes,actualAccountTypes);
    }
}
