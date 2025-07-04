# Test Case ID: TC_Conversion_001
# Generated from Jira Ticket: BANK-3060
# Epic: BANK-749
# Generated on: 2025-07-04 18:27:38
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

  Scenario: Fallback to cached exchange rate during API downtime
    Given the external API is down
    When I attempt to convert currency from "USD" to "EUR" with amount "100"
    Then the system should use the last known exchange rate and display "85.00"
