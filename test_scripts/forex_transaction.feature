# Test Case ID: TC_Conversion_005
# Generated from Jira Ticket: BANK-3113
# Epic: BANK-3083
# Generated on: 2025-07-04 14:04:20
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Record forex transaction in the database

Scenario: Verify record of forex transaction in the database
    Given the user is logged in and initiates a currency conversion
    Given a successful conversion from INR to JPY is completed
    When checking the database for the recorded forex transaction entry
    Then the database should contain a new entry for the forex transaction
    And the transaction details should match the conversion parameters