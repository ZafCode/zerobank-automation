Feature: Pay Bills Page's specifications

  Background:
    Given the user is logged in
    When the user navigates to "Pay Bills" page

    Scenario: Verify Pay Bills page title
      Then "Pay Bills" page should have the title "Zero - Pay Bills"

    Scenario: Verify that the user is able to complete Pay operations
      Then user completes a successful Pay operation
      Then "The payment was successfully submitted." should be displayed

    Scenario: Verify that the user is able to make payment with valid requirements
      Then user tries to make a payment without entering the amount or date
      Then "Please fill out this field." message should be displayed.
      Then user tries to input alphabetical or special characters to "Amount" field
      Then Date field should not accept alphabetical characters