# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3968
# Epic: BANK-3931
# Generated on: 2025-07-18 16:55:41
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Program Director rejects financial entries

  Scenario: Program Director rejects a financial entry
    Given Program Director is logged in
    And Financial entries are pending approval
    When Program Director navigates to the approval section
    And Program Director selects a financial entry to reject
    And Program Director rejects the financial entry
    Then the system should display a success message
    And the financial entry status should change to 'Rejected'
    And notifications are sent to the initiator