# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3465
# Epic: BANK-3409
# Generated on: 2025-07-14 10:48:55
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: High Risk Login

  Scenario: Additional authentication prompt for high-risk login attempt
    Given User is on the login page
    And User has high-risk fraud score
    When User enters valid username and password
    Then System detects high-risk score during login
    And User completes additional authentication steps successfully