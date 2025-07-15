# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3328
# Epic: BANK-3299
# Generated on: 2025-07-15 13:41:10
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Transaction Retrieval with Risk Assessment

  Scenario: Retrieve transactions with associated risk assessment data
    Given the GET /accounts/{accountId}/transactions endpoint is available
    And transactions with fraud risk assessment data are present in the system
    When I call the GET /accounts/12345/transactions endpoint
    Then the response should contain risk assessment data alongside transaction details
    And high-risk transactions should be clearly identified
    And low-risk transactions should not be flagged as high-risk
