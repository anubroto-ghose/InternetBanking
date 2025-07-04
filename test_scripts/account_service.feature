# Test Case ID: TC_Conversion_001
# Generated from Jira Ticket: BANK-2949
# Epic: BANK-749
# Generated on: 2025-07-04 15:40:15
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Fallback strategy for exchange rates

  Scenario: Use last known exchange rate when API is unreachable
    Given the external API for exchange rates is unreachable
    When I trigger the exchange rate retrieval
    Then the system should use the last known exchange rate
    And I should be informed about the use of cached rates
