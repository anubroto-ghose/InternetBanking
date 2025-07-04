# Test Case ID: TC_Forex_001_TC_Login_002
# Generated from Jira Ticket: BANK-3093
# Epic: BANK-3083
# Generated on: 2025-07-04 14:13:51
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Conversion

  Background:
    Given User is authenticated and authorized
    And Valid user credentials are available

  Scenario: Test forex conversion with invalid credentials
    When User navigates to the forex conversion page
    And Enters invalid credentials
    And Initiates conversion request
    Then System should display an error message
