# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3311
# Epic: BANK-3298
# Generated on: 2025-07-09 09:45:50
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Exchange
  Scenario: Successful forex exchange with maximum amount
    Given User is on the forex exchange interface
    And User has valid credentials and balance for exchange
    When User selects the 'From' currency and 'To' currency
    And User enters the maximum allowable amount to exchange
    And User clicks on the 'Exchange' button
    Then The exchange should be processed successfully
    And User should receive a success message for the exchange