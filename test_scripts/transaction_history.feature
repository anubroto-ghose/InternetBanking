# Test Case ID: TC_ViewTransaction_002
# Generated from Jira Ticket: BANK-2953
# Epic: BANK-749
# Generated on: 2025-07-04 15:39:11
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: View Transaction History

  Scenario: View transaction history with no data
    Given the user is logged into the application
    And the user has not performed any currency conversions
    When the user navigates to the transaction history section
    Then the transaction history section should inform the user that no conversion data is available
