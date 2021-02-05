package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        new LoginStepDef().the_user_is_logged_in();
        new PayBillsPage().payBills.click();
        new PayBillsPage().addNewPayee.click();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> payeeInfo) {
        BrowserUtils.waitFor(2);
        new PayBillsPage().addPayee(payeeInfo.get("Payee Name"), payeeInfo.get("Payee Address"),payeeInfo.get("Account"),payeeInfo.get("Payee details"));
    }

    @Then("message The new payee {string} was successfully created. should be displayed")
    public void message_The_new_payee_was_successfully_created_should_be_displayed(String string) {
        String expected = "The new payee "+string+" was successfully created.";
        String actual = new PayBillsPage().addPayeeMsg.getText();
        Assert.assertEquals(expected,actual);
    }

}
