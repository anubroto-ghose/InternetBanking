# Test Case ID: TC_APISecurity_001
# Generated from Jira Ticket: BANK-3138
# Epic: BANK-3124
# Generated on: 2025-07-07 16:45:07
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: API Security

  Scenario: Access API without authentication
    Given the API endpoint is set up
    When I send a request to the API endpoint without authentication
    Then I should receive a 401 Unauthorized response
