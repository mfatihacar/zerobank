Feature: Account Activity

  Background:
    Given the user is on the login page
    And the user enters valid credentials "username" and "password"
    And the user is on the "Account Activity" page

  Scenario: Account summary page should have the title Zero - Account Activity
    Then the page title should be "Account Activity"

  Scenario: In the Account dropdown, default option should be Savings
    Then the default account option should be "Savings"

  Scenario: Account dropdown should have Savings - Checking - Loan - Credit Card - Brokerage options
     Then the account dropdown should have the following options
     |Checking|Savings|Loan|Credit Card|Brokerage|

   Scenario: Transactions table should have Date - Description - Deposit - Withdrawal columns
     Then the transactions table should have the following columns
     |Date|Description|Deposit|Withdrawal|
