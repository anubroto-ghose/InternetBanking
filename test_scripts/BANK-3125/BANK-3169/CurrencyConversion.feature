# Test Case ID: TC_ForexConverter_001
# Generated from Jira Ticket: BANK-3169
# Epic: BANK-3125
# Generated on: 2025-07-07 11:35:26
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

  Scenario: Successful currency conversion from INR to JPY
    Given the user is logged in as an admin
    And the admin has access to the /admin/forex/convert endpoint
    When a POST request is sent to /admin/forex/convert with the INR amount to convert
    Then the response includes the converted amount in JPY
    And the exchange rate used for the conversion is provided