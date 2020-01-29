Feature: Account Summary

  Background:
    Given the user is on the login page
    And the user enters valid credentials "username" and "password"
    And the user is on the "Account Summary" page

  Scenario: Account summary page should have the title Zero - Account Summary
    Then the page title should be "Account Summary"

  Scenario: Account summary page should have Cash Account - Investment Accounts - Credit Accounts - Loan Accounts
    Then the page should contain the following account types
    |Cash Accounts|Investment Accounts|Credit Accounts|Loan Accounts|

   Scenario: Credit Accounts table should have Account - Credit Card - Balance columns
     Then the credit accounts table should have the following columns
     |Account|Credit Card|Balance|


