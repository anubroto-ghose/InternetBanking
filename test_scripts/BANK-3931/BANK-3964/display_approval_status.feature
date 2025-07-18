# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3964
# Epic: BANK-3931
# Generated on: 2025-07-18 16:47:15
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Display approval status on financial entry pages
  Scenario: Verify approval status is displayed
    Given Financial entry page is accessible
    And User has appropriate permissions
    When I open the financial entry page
    Then I should see the approval status displayed
