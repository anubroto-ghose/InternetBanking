Feature: User Authentication System
  As a banking customer
  I want to securely log into my account
  So that I can access my financial information

  Background:
    Given the banking application is running
    And the user database is accessible

  Scenario: Successful login with valid credentials
    Given a user with email "john.doe@email.com" and password "SecurePass123!" exists in the system
    When the user attempts to login with email "john.doe@email.com" and password "SecurePass123!"
    Then the login should be successful
    And the user should be redirected to the dashboard
    And the authentication token should be valid

  Scenario: Failed login with invalid password
    Given a user with email "john.doe@email.com" and password "SecurePass123!" exists in the system
    When the user attempts to login with email "john.doe@email.com" and password "WrongPassword"
    Then the login should fail
    And an "Invalid credentials" error message should be displayed
    And no authentication token should be provided

  Scenario Outline: Multiple login attempts with different credentials
    Given a user with email "<email>" and password "<correct_password>" exists in the system
    When the user attempts to login with email "<email>" and password "<attempted_password>"
    Then the login result should be "<expected_result>"

    Examples:
      | email                | correct_password | attempted_password | expected_result |
      | user1@bank.com       | Pass123!         | Pass123!          | success         |
      | user2@bank.com       | Secret456!       | wrong123          | failure         |
      | user3@bank.com       | Secure789!       | Secure789!        | success         |
