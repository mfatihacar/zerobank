Feature: Login

  Background:
    Given the user is on the login page

  Scenario: Only authorized users should be able to login

    When the user enters valid credentials "username" and "password"
    Then the user should land in the "Account Summary" page

  Scenario Outline: Users with wrong or blank username or password should not be able to login <scenario>
    When the user enters invalid credentials "<username>" and "<password>"
    Then Error message "Login and/or password are wrong." should be displayed
    Examples:
      | username      | password      | scenario        |
      | wrongusername | password      | -wrong username |
      | username      | wrongpassword | -wrong password |
      |               | password      | -blank username |
      | username      |               | -blank password |