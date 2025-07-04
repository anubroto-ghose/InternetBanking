# Test Case ID: TC_Conversion_002
# Generated from Jira Ticket: BANK-3057
# Epic: BANK-749
# Generated on: 2025-07-04 18:27:53
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

  Scenario: Error handling when API is down
    Given the external API is unreachable
    When I attempt to convert currency
    Then I should see an error message indicating that the API is down and fallback is not possible
