# Test Case ID: TC_Forex_Conversion_003
# Generated from Jira Ticket: BANK-3107
# Epic: BANK-3083
# Generated on: 2025-07-04 14:07:10
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Viewing transaction history for forex conversions

  Background:
    Given Admin is logged in to the system

  Scenario: Admin views forex transaction history
    When Admin navigates to the transaction history section
    Then The system displays a list of all forex transactions made by users, including conversion details