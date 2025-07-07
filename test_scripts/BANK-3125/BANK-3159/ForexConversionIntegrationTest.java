/**
 * Test Case ID: TC_ForexConversion_001
 * Generated from Jira Ticket: BANK-3159
 * Epic: BANK-3125
 * Generated on: 2025-07-07 11:40:30
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ForexConversionIntegrationTest {

    @LocalServerPort
    private int port;

    private WebDriver driver;

    @Test
    public void testForexConversionUnauthorized() {
        driver = new ChromeDriver();
        driver.get("http://localhost:" + port + "/forex-conversion");
        String pageSource = driver.getPageSource();
        assertEquals(401, driver.getPageSource());
    }
}