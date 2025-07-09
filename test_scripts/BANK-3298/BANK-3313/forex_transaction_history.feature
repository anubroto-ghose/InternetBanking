# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3313
# Epic: BANK-3298
# Generated on: 2025-07-09 09:44:21
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Verify user can navigate to transaction history and specific exchanges

  Scenario: User can navigate to transaction history
    Given User is logged into the forex exchange platform
    When User navigates to the transaction history section
    Then User successfully views transaction history

  Scenario: User can access specific exchange
    Given User is logged into the forex exchange platform
    When User selects a specific forex exchange from the history
    Then User can access specific details of a past forex exchange
