/**
 * Test Case ID: TC_ConvertCurrency_004
 * Generated from Jira Ticket: BANK-3177
 * Epic: BANK-3125
 * Generated on: 2025-07-07 11:31:06
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BankingPortalIntegrationTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void testInvalidForexEndpoint() {
    WebDriver driver = new ChromeDriver();
    driver.get("http://localhost:" + port + "/accounts/forex/convert");
    String pageTitle = driver.getTitle();
    Assertions.assertTrue(pageTitle.contains("Error") || pageTitle.contains("Failure"));
    driver.quit();
  }
}