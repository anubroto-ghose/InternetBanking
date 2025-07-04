# Test Case ID: TC_ResponseTime_004
# Generated from Jira Ticket: BANK-3103
# Epic: BANK-3083
# Generated on: 2025-07-04 14:09:11
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction History Response Time

  Scenario: Retrieve forex transaction history response time
    Given User has valid authentication credentials
    When User requests to retrieve forex transaction history
    Then Response time should be under 2 seconds