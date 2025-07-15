# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3337
# Epic: BANK-3299
# Generated on: 2025-07-15 13:38:21
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Account Creation with Fraud Detection

  Scenario: Successful account creation with low fraud risk assessment
    Given the system is up and running
    And the fraud risk assessment logic has been implemented
    When I send a POST request to "/accounts" with the following details:
      | accountName    | initialDeposit |
      | Test Account   | 1000           |
    Then the account is created successfully
    And the risk scoring is saved in the accounts database
