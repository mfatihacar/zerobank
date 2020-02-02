Feature: Pay Bills

  Background:
    Given the user is on the login page
    And the user enters valid credentials "username" and "password"
    And the user is on the "Pay Bills" page

  Scenario: Account summary page should have the title Zero - Pay Bills
    Then the page title should be "Pay Bills"

  Scenario: After the user makes a payment, the message "The payment was successfully submitted." should be displayed
    When the user pays $ 100 from the "Credit Card" account to "Sprint" on the "2020-02-06" with "Fee" description
    Then the message "The payment was successfully submitted." should be displayed

  Scenario:  After the user tries making a payment without entering the date, "Please fill out this field." message should be displayed
    When the user pays $ "50" from the "Savings" account to "Sprint" on the "" with "Saving" description
    Then the error message "Please fill in this field." should be displayed on the date field

  Scenario:  After the user tries making a payment without entering the amount, "Please fill out this field."  message should be displayed
    When the user pays $ "" from the "Checking" account to "Wells Fargo" on the "2020-02-11" with "Monthly payment" description
    Then the error message "Please fill in this field." should be displayed on the amount field

  @wip
  Scenario Outline: While entering data, the <field> field should not accept alphabetical or special characters
    When the user pays $ "<amount>" from the "Checking" account to "Wells Fargo" on the "<date>" with "Monthly payment" description
    Then the "<field>" should not accept the entry
    Examples:
      | field  | amount   | date       |
      | amount | Fiftysix | 2020-02-09 |
      | amount | ./!/@    | 2020-02-09 |

  @wip
  Scenario: While entering data, the date field should not accept alphabetical characters
     When the user pays $ "500" from the "Loan" account to "Apple" on the "This day" with "Loan payment" description
     Then the error message "Please fill in this field." should be displayed on the date field
