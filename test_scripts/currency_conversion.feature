# Test Case ID: TC_Conversion_003
# Generated from Jira Ticket: BANK-3072
# Epic: BANK-749
# Generated on: 2025-07-04 18:25:07
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Conversion

  Scenario: Convert zero INR amount to USD
    Given the user is on the currency conversion page
    When the user inputs '0' into the conversion field
    And the user clicks the 'Convert' button
    Then the displayed USD value should be '0'