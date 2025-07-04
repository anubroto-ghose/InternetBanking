# Test Case ID: TC_Forex_002
# Generated from Jira Ticket: BANK-3096
# Epic: BANK-3083
# Generated on: 2025-07-04 14:12:28
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Conversion

  Background:
    Given User is authenticated with an invalid authentication token

  Scenario: Unsuccessful forex conversion with invalid auth token
    When User attempts to convert forex
    Then System rejects the request and does not execute the conversion