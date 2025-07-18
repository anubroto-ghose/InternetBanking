# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3968
# Epic: BANK-3931
# Generated on: 2025-07-18 17:20:08
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Program Director can reject financial entries

  Scenario: Reject a financial entry
    Given the Program Director is logged into the system
    And there are financial entries pending approval
    When the Program Director navigates to the approval section
    And selects a financial entry to reject
    And rejects the financial entry
    Then the system displays a success message
    And the financial entry status changes to 'Rejected'
    And notifications are sent to the initiator
