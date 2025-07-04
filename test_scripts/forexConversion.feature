# Test Case ID: TC_Forex_004
# Generated from Jira Ticket: BANK-3098
# Epic: BANK-3083
# Generated on: 2025-07-04 14:11:36
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Conversion

  Scenario: Error message for malformed forex conversion request
    Given User is on the forex conversion page
    When User makes a forex conversion request with malformed data
    Then User should see the appropriate error message
