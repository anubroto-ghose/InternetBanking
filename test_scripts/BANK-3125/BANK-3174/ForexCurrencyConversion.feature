# Test Case ID: TC_ConvertCurrency_001
# Generated from Jira Ticket: BANK-3174
# Epic: BANK-3125
# Generated on: 2025-07-07 11:32:31
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

Scenario: Convert INR to JPY with valid amount parameter
    Given the endpoint /accounts/forex/convert is accessible via POST request
    And the request includes a valid amount parameter in INR
    When a POST request is sent to /accounts/forex/convert with a valid amount parameter in INR
    Then verify that the response includes the converted amount in JPY and the current exchange rate
    And confirm that the forex conversion transaction is recorded in the forex_transactions table