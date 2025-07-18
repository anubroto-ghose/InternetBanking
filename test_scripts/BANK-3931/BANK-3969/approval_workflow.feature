# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3969
# Epic: BANK-3931
# Generated on: 2025-07-18 10:57:44
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Approval Workflow

  Scenario: Program Director approves financial entry
    Given Program Director is logged into the system
    And Financial entry has been approved
    When Program Director views the approval history for the financial entry
    Then The system should display timestamps for approval decisions