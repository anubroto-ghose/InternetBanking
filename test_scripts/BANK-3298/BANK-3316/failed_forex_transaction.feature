# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3316
# Epic: BANK-3298
# Generated on: 2025-07-09 09:41:29
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Failed forex transaction due to insufficient balance

Scenario: User initiates a forex transaction with insufficient balance
    Given the user has insufficient balance in their account
    And the user is logged into the banking portal
    When the user initiates a forex transaction for converting 5000 INR to JPY
    Then the forex transaction should fail due to insufficient balance
    And the user receives an error message indicating the transaction failure