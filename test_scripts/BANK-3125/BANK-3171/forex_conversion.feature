# Test Case ID: TC_ForexConverter_003
# Generated from Jira Ticket: BANK-3171
# Epic: BANK-3125
# Generated on: 2025-07-07 11:34:08
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Record of Forex conversion transaction

  Scenario: Verify transaction details are recorded
    Given successfully completed currency conversion from INR to JPY
    When transaction details are looked up in the ForexTransaction table
    Then verify record includes transaction timestamp, converted amount, and exchange rate