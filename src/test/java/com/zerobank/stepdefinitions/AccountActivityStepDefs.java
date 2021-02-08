package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class AccountActivityStepDefs {

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {
        List<WebElement> links = new AccountActivityPage().links;
        for (WebElement element : links) {
            if(element.getText().equals(link)){
                element.click();
                break;
            }

        }
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

    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String pageName) {
        new AccountActivityPage().navigateTo(pageName);
    }

    @Then("In the Account drop down default option should be Savings.")
    public void in_the_Account_drop_down_default_option_should_be_Savings() {
        Select dropDown = new Select(new AccountActivityPage().accountDropDwn);
        String selectedMenu = dropDown.getFirstSelectedOption().getText();
        Assert.assertEquals("Verify selected menu","Savings",selectedMenu);
    }

    @Then("Account drop down should have the following options:")
    public void account_drop_down_should_have_the_following_options(List<String> expectedOptions) {
        List<String> dropDownOptions = BrowserUtils.getElementsText(new AccountActivityPage().dropDownMenu);
        for (String dropDownOption : dropDownOptions) {

            for (String option : expectedOptions) {

                Assert.assertTrue(dropDownOption.contains(option));
            }
        }
    }

    @Then("Transactions table should have column names")
    public void transactions_table_should_have_column_names(List<String> expectedColumnNames) {
        List<String> actualColumnNames = BrowserUtils.getElementsText(new AccountActivityPage().columnNames);
        Assert.assertEquals(expectedColumnNames.toString(),actualColumnNames.toString());

    }


}
