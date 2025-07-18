# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3966
# Epic: BANK-3931
# Generated on: 2025-07-18 17:20:57
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Financial Entry Report Filtering

  Scenario: Filter by approval status
    Given the report generation functionality is available
    When I access the report filtering section
    And I apply the filter for approval status "Approved"
    Then the reports should show entries filtered by status accurately
    And the report should contain entries with status "Approved"