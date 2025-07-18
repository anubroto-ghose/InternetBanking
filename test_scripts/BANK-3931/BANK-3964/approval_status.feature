# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3964
# Epic: BANK-3931
# Generated on: 2025-07-18 16:42:11
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Display approval status on financial entry pages

  Scenario: Verify approval status is displayed
    Given the financial entry page is accessible
    And the user has appropriate permissions
    When the user opens the financial entry page
    Then the approval status should be displayed
