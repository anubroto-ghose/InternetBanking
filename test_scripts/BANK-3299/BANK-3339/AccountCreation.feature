# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3339
# Epic: BANK-3299
# Generated on: 2025-07-15 13:37:37
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Account Creation without Fraud Risk Assessment

  Scenario: Successful account creation
    Given the system is up and running
    And the fraud risk assessment logic has not been implemented
    When I send a POST request to "/accounts" with the following details:
      | accountName    | initialDeposit |
      | Test Account   | 1000           |
    Then the account should be created successfully
    And the risk scoring field should remain empty in the accounts database
