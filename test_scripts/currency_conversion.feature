# Test Case ID: TC_Conversion_001
# Generated from Jira Ticket: BANK-3056
# Epic: BANK-749
# Generated on: 2025-07-04 18:28:06
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

  Scenario: Fallback to last known exchange rate during API downtime
    Given the external API is unreachable
    When I attempt to convert currency
    Then the conversion function should return the last known good exchange rate without errors
