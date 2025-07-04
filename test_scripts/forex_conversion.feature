# Test Case ID: TC_Forex_001_TC_Login_003
# Generated from Jira Ticket: BANK-3094
# Epic: BANK-3083
# Generated on: 2025-07-04 14:13:24
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Conversion
  
  Scenario: User accesses forex conversion without login
    Given User is not authenticated
    When User access the forex conversion endpoint
    Then User should be redirected to the login page