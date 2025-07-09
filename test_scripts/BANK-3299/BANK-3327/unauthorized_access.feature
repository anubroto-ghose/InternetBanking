# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3327
# Epic: BANK-3299
# Generated on: 2025-07-09 09:43:41
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Unauthorized Access for High-Risk Account

  Scenario: Validate unauthorized access message for high-risk account
    Given I have a high-risk account
    When I try to access the transactions
    Then I should see the message 'Unauthorized Access'
