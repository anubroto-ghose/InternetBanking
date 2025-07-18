# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3941
# Epic: BANK-3930
# Generated on: 2025-07-18 10:57:52
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Dashboard Data Refresh

  Scenario: Data on dashboard is refreshed at regular intervals
    Given the Dashboard is loaded with active financial projects
    And Automatic refreshing logic is implemented
    When I wait for the dashboard data to be refreshed
    Then I check if the displayed data is updated with new currency rates
