# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3468
# Epic: BANK-3409
# Generated on: 2025-07-14 10:48:20
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Review Alert

Scenario: Analyst marks alert as reviewed
	Given An unreviewed alert is present on the dashboard
	When Select the alert on the dashboard
	And Mark the alert as reviewed
	Then The alert is flagged as reviewed, indicating that the analyst has acknowledged the notification