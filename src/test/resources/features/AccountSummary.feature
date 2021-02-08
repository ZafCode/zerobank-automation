@summary
Feature: Account Summary Page's specifications

  Background:
    Given the user is logged in


  Scenario: Verify Account summary page title
    When the user navigates to "Account Summary" page
    Then "Account Summary" page should have the title "Zero - Account Summary"

  Scenario: Verify Account summary page account types
    Then Account summary page should have to following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |






