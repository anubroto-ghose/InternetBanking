# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3969
# Epic: BANK-3931
# Generated on: 2025-07-18 17:19:44
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Approval History

  Scenario: View approval history timestamps
    Given the Program Director is logged into the system
    And a financial entry has been approved
    When the Program Director views the approval history for the financial entry
    Then the system displays timestamps for approval decisions
