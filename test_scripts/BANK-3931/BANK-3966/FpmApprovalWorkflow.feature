# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3966
# Epic: BANK-3931
# Generated on: 2025-07-18 16:46:52
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Financial Approval Workflow

Scenario: User applies filter for approval status in report
    Given the report generation functionality is available
    And financial entry statuses vary
    When the user accesses the report filtering section
    And applies filter for approval status
    Then the reports should show entries filtered by status accurately