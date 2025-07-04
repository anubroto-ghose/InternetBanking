# Test Case ID: TC_Conversion_003
# Generated from Jira Ticket: BANK-3111
# Epic: BANK-3083
# Generated on: 2025-07-04 14:05:05
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

Scenario: Verify retrieval of exchange rate from third-party API
    Given the system has connectivity to the third-party API for exchange rates
    When I initiate the currency conversion process
    Then I monitor the communication with the external API
    And the system successfully retrieves the exchange rate from the third-party API
    And the conversion process uses the correct exchange rate for the conversion