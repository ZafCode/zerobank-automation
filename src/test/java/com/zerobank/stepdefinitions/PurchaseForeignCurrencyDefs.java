package com.zerobank.stepdefinitions;


import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.util.List;
import java.util.Map;

public class PurchaseForeignCurrencyDefs {

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        new LoginStepDef().the_user_is_logged_in();
        new PayBillsPage().payBills.click();
        new PayBillsPage().purchaseForeignCurrency.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencies ) {
        BrowserUtils.waitFor(2);
        List<String> actualCurrencies = BrowserUtils.getElementsText(new PayBillsPage().currency);
        for (String actualCurrency : actualCurrencies) {
            for (String currency : currencies) {
                Assert.assertTrue(actualCurrency.contains(currency));
            }
        }
    }


    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        BrowserUtils.waitFor(2);
        new PayBillsPage().amount.sendKeys("300");
        new PayBillsPage().calculateCostsBtn.click();
        }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        String alertExpectedText ="Please, ensure that you have filled all the required fields with valid values.";
        String alertActualText = alert.getText();
        Assert.assertEquals("Verify the alert message",alertExpectedText,alertActualText);
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        BrowserUtils.waitFor(2);
        new PayBillsPage().amount.sendKeys("");
        new PayBillsPage().calculateCostsBtn.click();
    }
}


