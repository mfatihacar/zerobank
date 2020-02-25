Feature: Purchase Foreign Currency

  Background:
    Given the user is on the login page
    And the user enters valid credentials "username" and "password"
    And the user is on the "Pay Bills" page
    And the user accesses the "Purchase Foreign Currency" tab
    And the user waits for the page to load

  Scenario: Available currencies
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Hong Kong (dollar)    |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Sweden (krona)        |

  Scenario: Error message for not selecting currency
    When the user enters Amount 100 chooses US Dollar and clicks on Calculate Costs
    Then the error popup should display the message "Please, ensure that you have filled all the required fields with valid values."

  Scenario: Error message for not entering value
    When the user selects "Australia (dollar)" chooses US Dollar and clicks on Calculate Costs
    Then the error popup should display the message "Please, ensure that you have filled all the required fields with valid values."