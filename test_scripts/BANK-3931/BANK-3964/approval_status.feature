# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3964
# Epic: BANK-3931
# Generated on: 2025-07-18 11:00:07
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Display Approval Status

  Scenario: Verify approval status is displayed
    Given Financial entry page is accessible
    And User has appropriate permissions
    When The financial entry page is opened
    Then Check for the display of approval status
