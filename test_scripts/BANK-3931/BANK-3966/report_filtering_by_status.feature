# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3966
# Epic: BANK-3931
# Generated on: 2025-07-18 10:59:13
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Filtering by status in reports
  As a financial analyst
  I want to see the approval progress of financial entries

  Scenario: Filter reports by approval status
    Given Report generation functionality is available
    And Financial entry statuses vary
    When I access the report filtering section
    And apply filter for approval status
    Then Reports should show entries filtered by status (Pending, Approved, Rejected) accurately