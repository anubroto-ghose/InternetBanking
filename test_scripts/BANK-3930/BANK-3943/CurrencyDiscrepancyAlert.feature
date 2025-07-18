# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3943
# Epic: BANK-3930
# Generated on: 2025-07-18 10:57:27
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Discrepancy Alert

Scenario: Display alert for currency rate discrepancy
    Given the dashboard is loaded with active financial projects
    When a discrepancy in currency rates occurs for a specific project
    Then the dashboard should promptly display an alert indicating the discrepancy
