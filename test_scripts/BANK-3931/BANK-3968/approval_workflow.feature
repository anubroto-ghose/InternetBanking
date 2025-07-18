# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3968
# Epic: BANK-3931
# Generated on: 2025-07-18 16:33:10
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Role-Based Approval Workflow

Scenario: Program Director rejects a financial entry
    Given Program Director is logged into the system
    And Financial entries are pending approval
    When Program Director navigates to the approval section
    And Program Director selects a financial entry to reject
    And Program Director rejects the financial entry
    Then The system displays a success message
    And Financial entry status changes to 'Rejected'
    And Notifications are sent to the initiator
