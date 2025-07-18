# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3969
# Epic: BANK-3931
# Generated on: 2025-07-18 16:41:21
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Approval Workflow for Financial Entries

  Scenario: Program Director views approval history for financial entry
    Given Program Director is logged into the system
    And Financial entry has been approved
    When Program Director views the approval history
    Then The system should display timestamps for approval decisions