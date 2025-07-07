# Test Case ID: TC_Forex_001
# Generated from Jira Ticket: BANK-3160
# Epic: BANK-3125
# Generated on: 2025-07-07 11:40:02
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Conversion

  Scenario: Successful forex conversion with valid authentication
    Given User is authenticated and authorized
    And User has sufficient funds in account
    When User navigates to forex conversion section
    And User enters valid conversion details
    And User initiates the conversion process
    Then User's account balance is updated
    And User receives a confirmation notification
