# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3940
# Epic: BANK-3930
# Generated on: 2025-07-18 10:58:32
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Verify dashboard displays all active financial projects with real-time currency conversions

Scenario: View all active financial projects
    Given the dashboard module is open
    When I check for active financial projects
    Then I should see all projects displayed

Scenario: Verify real-time currency conversions
    Given the currency conversion data is up-to-date
    When I view the dashboard
    Then I should see currency conversions updated dynamically
