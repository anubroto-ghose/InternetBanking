# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3462
# Epic: BANK-3409
# Generated on: 2025-07-15 13:30:20
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Submit SAR Report

  Scenario: Compliance officer submits the SAR report for regulatory review
    Given the SAR report has been reviewed and adjusted
    And compliance officer approval is obtained
    When the compliance officer submits the SAR report
    Then the SAR report should be successfully submitted for regulatory review
