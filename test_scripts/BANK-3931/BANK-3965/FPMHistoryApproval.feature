# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3965
# Epic: BANK-3931
# Generated on: 2025-07-18 16:47:04
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Show history of previous approvers and comments

  Scenario: [US-02] As a financial analyst, I want to see the approval progress of financial entries
    Given Historical approval data exists
    And User has sufficient privileges
    When I navigate to the financial entry history section
    Then I should see the display of previous approvers and comments