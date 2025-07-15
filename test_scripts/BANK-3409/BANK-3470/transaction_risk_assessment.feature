# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3470
# Epic: BANK-3409
# Generated on: 2025-07-15 13:28:13
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Transaction Risk Assessment

  Scenario: Assess risk of a transaction in real-time
    Given a logged-in user "testuser" with sufficient balance
    When the user initiates a transaction of amount "100"
    Then the system should assess the transaction risk within "100" milliseconds
    And the transaction should be processed successfully
