# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3966
# Epic: BANK-3931
# Generated on: 2025-07-18 16:56:06
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Role-Based Financial Approval Workflow

Scenario: Dealsheet Approval
    Given the FpmDealsheetController requires updates
    And the FpmVersionController must record approval decisions
    When a dealsheet is submitted for approval
    Then the approval status should be updated
    And the approval log should be captured

Scenario: Staffing Approval
    Given the FpmStaffingController APIs need to log status changes
    When staffing data is submitted for approval
    Then the status should be updated accordingly
    And the approver role should be determined

Scenario: Travel Approval
    Given the FpmTravelController entries must go through an approval lifecycle
    When travel expenses are submitted for approval
    Then the approval process should be successful
    And the approver should be notified
