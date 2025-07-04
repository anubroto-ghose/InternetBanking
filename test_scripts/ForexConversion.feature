# Test Case ID: TC_Forex_Conversion_004
# Generated from Jira Ticket: BANK-3108
# Epic: BANK-3083
# Generated on: 2025-07-04 14:06:39
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Conversion

  Scenario: Successful forex conversion process
    Given Admin is authenticated and logged in
    When Admin triggers a currency conversion process using the endpoint POST /admin/forex/convert
    Then The conversion process successfully executes with proper error handling, displaying meaningful messages for success

  Scenario: Failed forex conversion process
    Given Admin is authenticated and logged in
    When Admin triggers a currency conversion process using the endpoint POST /admin/forex/convert
    Then The conversion process fails with proper error handling, displaying meaningful messages for failure