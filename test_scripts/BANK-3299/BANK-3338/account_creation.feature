# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3338
# Epic: BANK-3299
# Generated on: 2025-07-15 13:38:02
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Account Creation with Fraud Detection

  Scenario: Block account creation due to high fraud risk
    Given the system is up and running
    And the fraud risk assessment logic has been implemented
    When I send a POST request to "/accounts" with high risk data
    Then I should receive an error message indicating that account creation is blocked
    And the risk scoring should not be saved in the accounts database
