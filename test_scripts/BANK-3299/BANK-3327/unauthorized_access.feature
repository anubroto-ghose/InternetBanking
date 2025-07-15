# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3327
# Epic: BANK-3299
# Generated on: 2025-07-15 13:41:27
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Unauthorized Access for High-Risk Account

  Scenario: Retrieve transactions with associated risk assessment data
    Given a high-risk account ID is available
    When the user calls the GET /accounts/{accountId}/transactions endpoint
    Then the server responds with an unauthorized access message for high-risk account
