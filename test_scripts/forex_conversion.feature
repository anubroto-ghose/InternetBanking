# Test Case ID: TC_Forex_001
# Generated from Jira Ticket: BANK-3092
# Epic: BANK-3083
# Generated on: 2025-07-04 14:14:17
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Conversion

  Background:
    Given User is authenticated and authorized
    And Valid user credentials are available

  Scenario: Successful forex conversion with valid credentials
    When User navigates to forex conversion endpoint
    And Inputs valid user credentials
    And Initiates a conversion request
    Then System successfully executes forex conversion
    And Correct conversion details are displayed to the user