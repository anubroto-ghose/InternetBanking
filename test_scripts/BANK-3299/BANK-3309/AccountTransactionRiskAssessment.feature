# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3309
# Epic: BANK-3299
# Generated on: 2025-07-15 13:42:06
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Account Transaction Risk Assessment

  Scenario: Retrieve transactions with associated risk assessment data
    Given a valid account ID "12345"
    And the account has transactions with associated risk assessment data
    When the user calls the GET /accounts/12345/transactions endpoint
    Then the response should contain all transactions with their associated risk assessment data
    And high-risk transactions should be properly marked in the response
    And viewing transaction history is successful for low-risk transactions
    And unauthorized access is prevented for high-risk accounts
