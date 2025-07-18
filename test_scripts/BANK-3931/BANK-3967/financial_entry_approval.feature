# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3967
# Epic: BANK-3931
# Generated on: 2025-07-18 17:20:34
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Financial Entry Approval

  Scenario: Program Director approves financial entry
    Given the Program Director is logged in
    And there are financial entries pending approval
    When the Program Director navigates to the approval section
    And selects a financial entry to approve
    And approves the financial entry
    Then the system displays a success message
    And the financial entry status changes to 'Approved'
    And notifications are sent to the initiator