# Test Case ID: TC_RetrieveHistory_001
# Generated from Jira Ticket: BANK-3100
# Epic: BANK-3083
# Generated on: 2025-07-04 14:10:37
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Retrieve forex transaction history

Scenario: Retrieve forex transaction history with valid credentials
    Given User has valid authentication credentials
    When User sends a GET request to retrieve forex transaction history
    Then The response should include date, amounts in INR and JPY, exchange rate, and transaction ID