@summary
Feature: Account Summary Page's specifications

  Background:
    Given the user is logged in


  Scenario: Verify that Account summary page have the title Zero – Account Summary.
    Then Account summary page should have the title "Zero - Account Summary"
    Then Account summary page should have to following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |






