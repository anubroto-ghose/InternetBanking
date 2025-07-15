# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3472
# Epic: BANK-3409
# Generated on: 2025-07-15 13:27:34
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Automatic flagging of transactions during high-risk periods

  Scenario: Flagging transactions during high-risk patterns
    Given the user is logged in as "testuser"
    When the user simulates high-risk transaction patterns
    Then the system should automatically flag the transaction
    And the flagged transaction should be handled appropriately
