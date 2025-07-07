# Test Case ID: TC_ConvertCurrency_003
# Generated from Jira Ticket: BANK-3176
# Epic: BANK-3125
# Generated on: 2025-07-07 11:31:23
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Verify response time for currency conversion

  Scenario: Measure response time for currency conversion request
    Given the endpoint /accounts/forex/convert is accessible
    When a POST request is sent with valid amount parameters in INR
    Then measure the response time and ensure it is returned within 2 seconds
