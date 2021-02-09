@login @all
Feature: Login functionality

  Background:
    Given the user is on the login page

  Scenario: Verify that only authorized users should be able to login to the application
    When user logs in with valid credentials
    Then Account summary page should be displayed


  Scenario Outline: Verify that users should not able to login with invalid credentials

    When user logs in with "<username>" and "<password>"
    Then error message "Login and/or password are wrong." should be displayed

      Examples:
      |username|password|
      |wrong   |password|
      |username|wrong   |
      |wrong   |wrong   |
      |        |password|
      |username|        |
      |        |        |




