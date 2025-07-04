# Test Case ID: TC_Conversion_005
# Generated from Jira Ticket: BANK-2961
# Epic: BANK-749
# Generated on: 2025-07-04 15:51:34
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Decimal Handling in Conversion

  Scenario: Verify correct decimal handling in conversion
    Given the banking portal is open
    When I input a decimal amount of "100.50" in INR
    And I click the convert button
    Then I should see the converted amount as "Converted Amount: 0.0125 USD"