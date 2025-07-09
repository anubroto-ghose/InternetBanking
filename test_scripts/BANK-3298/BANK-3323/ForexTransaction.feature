# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3323
# Epic: BANK-3298
# Generated on: 2025-07-09 09:34:07
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Failed forex transaction from INR to JPY due to insufficient funds

  Scenario: User initiates forex transaction with insufficient funds
    Given User is logged in
    And User has insufficient funds in their INR account
    And User has selected to convert from INR to JPY
    When User initiates a forex transaction
    Then Insufficient funds message is displayed
    And User's INR balance remains unchanged
    And User receives notification of failed transaction