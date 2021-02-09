package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        new LoginPage().login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));
    }

    @Then("Account summary page should be displayed")
    public void account_summary_page_should_be_displayed() {
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Zero - Account Summary";
        Assert.assertEquals("Verify page title", expectedTitle,actualTitle);
    }

    @When("user logs in with {string} and {string}")
    public void user_logs_in_with_and(String username, String password) {
        new LoginPage().loginInvalid( username,password );
    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String string) {
        String expectedMsg = "Login and/or password are wrong.";
        String actualMsg = new LoginPage().invalidLoginMsg.getText();
        Assert.assertEquals("Verify wrong login message", expectedMsg,actualMsg);
    }

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    new LoginPage().login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));
    }
}
