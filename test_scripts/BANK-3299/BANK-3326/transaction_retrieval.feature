# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3326
# Epic: BANK-3299
# Generated on: 2025-07-15 13:41:47
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Transaction Retrieval

  Scenario: Retrieve transactions without risk assessment data
    Given a valid account ID
    And the account has transactions without associated risk assessment data
    When I call the GET /accounts/{accountId}/transactions endpoint
    Then the response should contain all transactions without risk assessment data
    And no risk assessment data should be present in the response
