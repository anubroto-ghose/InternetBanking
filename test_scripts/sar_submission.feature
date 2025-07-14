# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3462
# Epic: BANK-3409
# Generated on: 2025-07-14 10:49:33
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: SAR submission for regulatory review

  Scenario: Submitting SAR report
    Given the SAR report is reviewed and adjusted
    And compliance officer approval is obtained
    When the SAR report is submitted for regulatory review
    Then the SAR report is successfully submitted for regulatory review
