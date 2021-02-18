package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;


import java.util.List;

public class AccountSummaryStepDefs {


    @Then("{string} page should have the title {string}")
    public void page_should_have_the_title(String string, String expectedPageTitle) {
        //new AccountActivityPage().accountActivityBtn.click();
        BrowserUtils.waitFor(2);
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
