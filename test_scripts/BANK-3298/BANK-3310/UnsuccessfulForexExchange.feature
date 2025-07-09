# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3310
# Epic: BANK-3298
# Generated on: 2025-07-09 09:46:25
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Unsuccessful forex exchange with incorrect credentials

  Scenario: User has incorrect credentials for forex exchange
    Given User is on the forex exchange interface
    And User has incorrect credentials or insufficient balance for exchange
    When User selects the 'From' currency and 'To' currency
    And User enters a valid amount to exchange
    And User clicks on the 'Exchange' button
    Then The exchange should not be processed
    And User should receive an error message for the exchange