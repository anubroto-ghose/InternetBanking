# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3969
# Epic: BANK-3931
# Generated on: 2025-07-18 16:55:30
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Financial Approval History

  Scenario: Program Director views approval history
    Given Program Director is logged into the system
    And Financial entry has been approved
    When Program Director views the approval history for the financial entry
    Then System displays timestamps for approval decisions