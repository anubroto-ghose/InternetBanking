# Test Case ID: TC_Conversion_005
# Generated from Jira Ticket: BANK-3064
# Epic: BANK-749
# Generated on: 2025-07-04 18:26:48
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion during API Downtime

  Scenario: User attempts to convert currency when API is down
    Given the external API is down
    When the user initiates the currency conversion
    Then the user should see a message indicating cached rates are being used
    And the user interface should remain responsive