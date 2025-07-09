# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3328
# Epic: BANK-3299
# Generated on: 2025-07-09 09:42:48
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Transaction Risk Assessment

  Scenario: Retrieve transactions with associated risk assessment data
    Given the GET /accounts/{accountId}/transactions endpoint is available
    And transactions with fraud risk assessment data are present in the system
    When I call the GET /accounts/{accountId}/transactions endpoint
    Then the response should include risk assessment data for each transaction
    And high-risk transactions should be appropriately marked
    And low-risk transactions should not be flagged as high-risk
