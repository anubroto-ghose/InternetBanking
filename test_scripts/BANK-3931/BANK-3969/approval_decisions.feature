# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3969
# Epic: BANK-3931
# Generated on: 2025-07-18 17:05:42
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Approval Decisions Log

  Scenario: View approval timestamps
    Given Program Director is logged into the system
    And Financial entry has been approved
    When Program Director views the approval history for the financial entry
    Then The system displays timestamps for approval decisions