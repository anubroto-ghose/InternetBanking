Feature: Multiple Concurrent Forex Rate Retrieval

Scenario: Simulate 100 concurrent forex rate retrieval requests
    Given the forex rate retrieval API is operational
    When 100 requests for forex rate retrieval are sent concurrently
    Then monitor the response time and error rates

Examples:
    | Request No. | Currency | Rate Expected |
    | 1           | USD      | 100           |
    | 2           | EUR      | 100           |
    | 3           | JPY      | 100           |