# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3965
# Epic: BANK-3931
# Generated on: 2025-07-18 16:56:17
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Display Previous Approvers and Comments

    Scenario: Verify previous approvers and comments are displayed
        Given Historical approval data exists
        And User has sufficient privileges
        When User navigates to the financial entry history section
        Then Previous approvers along with their comments should be visible
