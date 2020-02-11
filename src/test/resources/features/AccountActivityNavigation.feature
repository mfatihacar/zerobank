Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user is on the login page
    And the user enters valid credentials "username" and "password"
    And the user is on the "Account Summary" page

  Scenario Outline: <accountType> account redirect
    When the user clicks on "<accountType>" link on the Account Summary page
    Then the page title should be "Account Activity"
    And Account drop down should have "<accountType>" selected
    Examples:
      | accountType |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |

