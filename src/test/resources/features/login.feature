@login
Feature: Login functionality


  Scenario: Verify that only authorized users should be able to login to the application
    Given the user is on the login page
    When user logs in with valid credentials
    Then Account summary page should be displayed

  Scenario: Verify that users should not able to login with wrong username
    Given the user is on the login page
    When user logs in with wrong username
    Then error message "Login and/or password are wrong." should be displayed

  Scenario: Verify that users should not able to login with wrong password
    Given the user is on the login page
    When user logs in with wrong password
    Then error message "Login and/or password are wrong." should be displayed

  Scenario: Verify that users should not able to login with blank username
    Given the user is on the login page
    When user logs in with blank username
    Then error message "Login and/or password are wrong." should be displayed

  Scenario: Verify that users should not able to login with wrong username
    Given the user is on the login page
    When user logs in with blank password
    Then error message "Login and/or password are wrong." should be displayed


