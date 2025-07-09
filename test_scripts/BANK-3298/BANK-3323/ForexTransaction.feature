# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3323
# Epic: BANK-3298
# Generated on: 2025-07-09 09:34:55
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction Feature

  Scenario: Failed forex transaction from INR to JPY due to insufficient funds
    Given user has insufficient funds in their INR account
    And user has selected to convert from INR to JPY
    And conversion rate is currently favorable
    When user initiates a forex transaction from INR to JPY
    Then system handles the request
    And insufficient funds message is displayed to the user

