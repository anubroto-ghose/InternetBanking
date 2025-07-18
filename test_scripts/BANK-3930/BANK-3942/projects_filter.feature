# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3942
# Epic: BANK-3930
# Generated on: 2025-07-18 10:57:44
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: User can filter projects based on currency type

  Scenario: Filter projects by specific currency
    Given the dashboard is loaded with active financial projects
    And the currency type filter feature is enabled
    When the user selects a specific currency type to filter projects
    Then the dashboard should display only projects with the selected currency type after applying the filter