Feature: Add new payee under pay bills

  Background:
    Given the user is on the login page
    And the user enters valid credentials "username" and "password"
    And the user is on the "Pay Bills" page
    And the user accesses the "Add New Payee" tab

  Scenario Outline: Add a new payee
    When the user creates new payee using following information
      | Payee Name    | <Payee Name>    |
      | Payee Address | <Payee Address> |
      | Account       | <Account>       |
      | Payee Details | <Payee Details> |
    Then the payee added message "The new payee <Payee Name> was successfully created." should be displayed
    Examples:
      | Payee Name                               | Payee Address                    | Account  | Payee Details |
      | The Law Offices of Hyde, Price & Scharks | 100 Same st, Anytown, USA, 10001 | Checking | XYZ account   |