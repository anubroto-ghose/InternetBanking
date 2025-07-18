# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3967
# Epic: BANK-3931
# Generated on: 2025-07-18 16:46:43
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Program Director Approval

  Scenario: Program Director can approve financial entries
    Given Program Director is logged into the system
    And Financial entries are pending approval
    When Program Director navigates to the approval section
    And Program Director selects a financial entry to approve
    And Program Director approves the financial entry
    Then The system displays a success message
    And Financial entry status changes to 'Approved'
    And Notifications are sent to the initiator