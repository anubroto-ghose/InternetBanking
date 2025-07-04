# Test Case ID: TC_Forex_005
# Generated from Jira Ticket: BANK-3099
# Epic: BANK-3083
# Generated on: 2025-07-04 14:11:08
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Protection of passwords in Forex conversion API calls

Scenario: User sends a request to the forex conversion endpoint
    Given User sends a request to the forex conversion endpoint
    Then API call made to the forex conversion endpoint should protect passwords and sensitive data
    And User should receive the converted amount with correct currency
