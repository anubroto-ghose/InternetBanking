# Test Case ID: TC_Compliance_001
# Generated from Jira Ticket: BANK-3140
# Epic: BANK-3124
# Generated on: 2025-07-07 16:44:39
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion Compliance

  Scenario: Attempt currency conversion that violates regulations
    Given the currency conversion regulations are defined
    When the user attempts to convert an invalid currency
    Then the system should reject the conversion and provide a compliance error message
