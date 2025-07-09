# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3312
# Epic: BANK-3298
# Generated on: 2025-07-09 09:45:10
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Exchange Page

Scenario: User can easily select currency and enter exchange amount
    Given User is on the forex exchange page
    When User clicks on the currency selection dropdown
    And User selects a currency option
    And User enters an amount to exchange
    Then User successfully selects a currency
    And User is able to enter the exchange amount