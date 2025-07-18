# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3951
# Epic: BANK-3930
# Generated on: 2025-07-18 10:53:48
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Financial Entry Submission

Scenario: Submit financial entries successfully
    Given the user is on the financial entry submission portal
    And dealsheets and budgets are ready for submission
    When the user uploads dealsheets and budgets
    And submits the financial entries for approval
    Then the financial entries are submitted without errors