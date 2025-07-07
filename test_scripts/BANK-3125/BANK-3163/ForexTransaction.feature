# Test Case ID: TC_Forex_004
# Generated from Jira Ticket: BANK-3163
# Epic: BANK-3125
# Generated on: 2025-07-07 11:38:41
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction Logging

  Scenario: Logging of failed forex transactions
    Given the user is authenticated
    And has a valid amount in the account
    When the user navigates to forex section
    And enters valid conversion details
    And triggers a conversion failure
    Then the system should log the failed transaction
    And inform the user about the failure reason