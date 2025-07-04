# Test Case ID: TC_AccessSecure_003
# Generated from Jira Ticket: BANK-3102
# Epic: BANK-3083
# Generated on: 2025-07-04 14:09:44
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Secure access to forex transaction history endpoint

Scenario: Access secure forex transaction history without authentication
    Given User does not have valid authentication credentials
    When User attempts to access the endpoint to retrieve forex transaction history without authentication
    Then The system should deny access to the endpoint without valid credentials
