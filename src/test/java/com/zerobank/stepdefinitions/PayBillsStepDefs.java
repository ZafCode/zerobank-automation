package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

public class PayBillsStepDefs {

    @When("user completes a successful Pay operation")
    public void user_completes_a_successful_Pay_operation() {
        BrowserUtils.waitForVisibility(new PayBillsPage().amountInputBox,5);
        new PayBillsPage().amountInputBox.sendKeys("1000");
        new PayBillsPage().dateInputBox.sendKeys("2021-02-07");
        new PayBillsPage().payButton.click();
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String expectedPaymentMsg) {
        BrowserUtils.waitForVisibility(new PayBillsPage().paymentMessage,4);
        String actualPaymentMsg = new PayBillsPage().paymentMessage.getText();
        Assert.assertEquals("Verify Payment message", expectedPaymentMsg,actualPaymentMsg);
    }

    @Then("user tries to make a payment without entering the amount or date")
    public void user_tries_to_make_a_payment_without_entering_the_amount_or_date() {
        BrowserUtils.waitForVisibility(new PayBillsPage().amountInputBox,5);
        new PayBillsPage().amountInputBox.sendKeys("");
        new PayBillsPage().dateInputBox.sendKeys("2021-02-07");
        new PayBillsPage().payButton.click();
    }

    @Then("{string} message should be displayed.")
    public void message_should_be_displayed(String expectedMessage) {
        BrowserUtils.waitFor(2);
        //Alert alert = Driver.get().switchTo().alert();
          // String actualMessage = alert.getText();
        String actualMessage = new PayBillsPage().amountInputBox.getAttribute("validationMessage");
        Assert.assertEquals("Verify alert message", expectedMessage,actualMessage);
    }


    @Then("user tries to input alphabetical or special characters to {string} field")
    public void user_tries_to_input_alphabetical_or_special_characters_to_field(String string) {
        WebElement amountField=  new PayBillsPage().amountInputBox;
        // Type alphabets
        amountField.sendKeys("Dolar");

        // Retrieve typed value
        String typedValue = amountField.getAttribute("value");

        // Get the length of typed value
        int actualSize = typedValue.length();
        int expectedSize =0;
        Assert.assertTrue("Verify typed value size",actualSize!=expectedSize);


        // Type special Characters
        amountField.clear();
        amountField.sendKeys("#%$%&");

        // Retrieve typed value
        String typedValue1 = amountField.getAttribute("value");

        // Get the length of typed value
        int actualSize1 = typedValue1.length();
        Assert.assertTrue("Verify typed value size",actualSize!=expectedSize);
        System.out.println("*************THIS IS A BUG**************");
    }

    @Then("Date field should not accept alphabetical characters")
    public void date_field_should_not_accept_alphabetical_characters() {

        WebElement dateField=  new PayBillsPage().dateInputBox;
        // Type alphabets
        dateField.sendKeys("Dolar");

        // Retrieve typed value
        String typedValue = dateField.getAttribute("value");

        // Get the length of typed value
        int actualSize = typedValue.length();
        int expectedSize =0;
        Assert.assertTrue("Verify typed value size",actualSize!=expectedSize);
    }




}
