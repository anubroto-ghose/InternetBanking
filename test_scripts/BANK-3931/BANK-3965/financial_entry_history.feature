# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3965
# Epic: BANK-3931
# Generated on: 2025-07-18 10:59:39
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Financial Entry History
  As a financial analyst
  I want to see the approval progress of financial entries

  Scenario: Show history of previous approvers and comments
    Given Historical approval data exists
    And User has sufficient privileges
    When I navigate to the financial entry history section
    Then I should see previous approvers and their comments displayed