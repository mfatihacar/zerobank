@wip
Feature: Account Summary

  Background:
    Given the user is on the login page
    And the user enters valid credentials "username" and "password"
    And the user is on the "Account Summary" page

  Scenario: Account summary page should have the title Zero - Account Summary
    Then the page title should be "Account Summary"


