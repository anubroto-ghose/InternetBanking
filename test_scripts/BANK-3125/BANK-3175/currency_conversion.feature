# Test Case ID: TC_ConvertCurrency_002
# Generated from Jira Ticket: BANK-3175
# Epic: BANK-3125
# Generated on: 2025-07-07 11:32:00
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

Scenario: Convert INR to JPY with invalid amount parameter (TC_ConvertCurrency_002)
    Given the endpoint /accounts/forex/convert is accessible via POST request
    And the request includes an invalid amount parameter in INR
    When a POST request is sent to /accounts/forex/convert
    Then verify that the response indicates an error or failure due to an invalid amount parameter