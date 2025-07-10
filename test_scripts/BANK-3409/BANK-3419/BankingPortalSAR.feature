# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3419
# Epic: BANK-3409
# Generated on: 2025-07-10 09:05:51
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Manual review of generated SAR before submission

  Scenario: User reviews generated SAR
    Given a Suspicious Activity Report is automatically generated
    When the user reviews the content and details
    Then the user should be able to validate the accuracy before submission