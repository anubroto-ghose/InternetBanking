# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3309
# Epic: BANK-3299
# Generated on: 2025-07-09 09:45:30
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Transaction Retrieval

  Scenario: Retrieve transactions with risk assessment data
    Given a valid account ID is available
    And the account has transactions with risk assessment data
    When calling the GET /accounts/{accountId}/transactions endpoint
    Then verify that the response includes risk assessment data for each transaction
    And ensure that high-risk transactions are properly marked
    And accessing transaction history is successful for low-risk transactions
    And unauthorized access is prevented for high-risk accounts