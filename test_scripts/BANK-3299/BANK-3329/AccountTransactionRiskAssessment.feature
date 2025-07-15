# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3329
# Epic: BANK-3299
# Generated on: 2025-07-15 13:40:50
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Retrieve transactions with high risk flag

  Scenario: Fetch transactions and assess risk
    Given the GET /accounts/{accountId}/transactions endpoint is available
    And transactions with fraud risk assessment data are present in the system
    When I call the GET /accounts/12345/transactions endpoint
    Then the response should contain transactions marked as high risk
    And the transactions marked as high risk should have the appropriate flag
    And the transactions without high risk should not be mistakenly labeled as high-risk
