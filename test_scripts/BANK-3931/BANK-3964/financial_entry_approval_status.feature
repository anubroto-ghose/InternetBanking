# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3964
# Epic: BANK-3931
# Generated on: 2025-07-18 17:21:47
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Display Approval Status on Financial Entry Pages

  Scenario: View approval status as a financial analyst
    Given the financial entry page is accessible
    And the user has appropriate permissions
    When the user opens the financial entry page
    Then the approval status should be visibly displayed on the financial entry page
    And the approval status should show 'Pending' or appropriate status
