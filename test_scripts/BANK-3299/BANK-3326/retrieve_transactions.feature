# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3326
# Epic: BANK-3299
# Generated on: 2025-07-09 09:44:43
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Retrieve Transactions Without Risk Assessment Data

Scenario: Retrieval of transactions without risk assessment data
  Given a valid account ID is available
  And the account has transactions without associated risk assessment data
  When the GET /accounts/{accountId}/transactions endpoint is called
  Then the response should not include risk assessment data for any transaction

Priority: Medium
Type: Story