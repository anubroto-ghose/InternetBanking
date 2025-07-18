# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3965
# Epic: BANK-3931
# Generated on: 2025-07-18 17:21:27
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Financial Entry Approval History

  Scenario: View approval history of financial entries
    Given historical approval data exists
    And user has sufficient privileges
    When the user navigates to the financial entry history section
    Then the previous approvers along with their comments should be visible in the history section
      | Approver      | Comment                     |
      | John Doe      | Approved                    |
      | Jane Smith    | Needs more info             |