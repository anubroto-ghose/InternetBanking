# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3315
# Epic: BANK-3298
# Generated on: 2025-07-09 09:42:30
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction

  Scenario: Successful forex transaction
    Given user is logged into the banking portal
    And user has sufficient balance in their account
    When user initiates a forex transaction to convert 1000 INR to JPY
    Then verify the exchange rate
    And check the total converted amount
    And ensure the forex transaction is successful
    And verify the transaction details in the account statement