# Test Case ID: TC_Conversion_004
# Generated from Jira Ticket: BANK-3073
# Epic: BANK-749
# Generated on: 2025-07-04 18:24:53
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Real-time currency conversion rate updates

  Scenario: User checks the conversion rate for INR
    Given the user is on the currency conversion page
    When the user inputs a valid INR amount of "1000"
    And waits for a few seconds
    Then the conversion rate displayed should reflect the latest rate
    And the conversion rate should be a valid number
