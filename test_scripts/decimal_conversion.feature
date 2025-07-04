# Test Case ID: TC_Conversion_005
# Generated from Jira Ticket: BANK-2961
# Epic: BANK-749
# Generated on: 2025-07-04 15:36:53
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Decimal Conversion in Banking Portal

  Scenario: Verify correct decimal handling in conversion
    Given the system is prepared for decimal values in INR
    When I input a decimal amount of "1000.50" in INR
    And I submit the conversion request
    Then the application should handle decimal values in INR appropriately
    And the system should correctly convert decimal amounts to "USD 12.34"