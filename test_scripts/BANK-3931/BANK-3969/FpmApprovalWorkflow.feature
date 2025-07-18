# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3969
# Epic: BANK-3931
# Generated on: 2025-07-18 16:46:18
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Approval Workflow for Financial Entries

  Scenario: Program Director views approval history
    Given Program Director is logged into the system
    And Financial entry has been approved
    When Program Director views the approval history for the financial entry
    Then The system displays timestamps for approval decisions