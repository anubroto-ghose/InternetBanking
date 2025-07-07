# Test Case ID: TC_Forex_001
# Generated from Jira Ticket: BANK-3151
# Epic: BANK-3124
# Generated on: 2025-07-07 16:41:33
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction

  Scenario: Successful initiation of forex transaction from INR to JPY
    Given the customer has a valid account with sufficient INR amount
    When the customer initiates a forex transaction from INR to JPY
    Then the transaction should be confirmed within 2 seconds
    And the customer's INR amount should be deducted
    And the equivalent JPY amount should be credited
    And no error messages should be displayed
