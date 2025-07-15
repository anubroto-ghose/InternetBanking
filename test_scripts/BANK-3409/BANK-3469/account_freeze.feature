# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3469
# Epic: BANK-3409
# Generated on: 2025-07-15 13:28:29
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Account Freeze Based on Alert

  Scenario: Freeze account due to high-risk transaction alert
    Given an alert for a high-risk transaction is displayed
    When I access the flagged alert detail
    And I initiate the account freezing process
    Then the system successfully freezes the account associated with the flagged alert
