/**
 * Test Case ID: TC_Forex_001_TC_Login_003
 * Generated from Jira Ticket: BANK-3094
 * Epic: BANK-3083
 * Generated on: 2025-07-04 14:13:24
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ForexConversionTest {

    @LocalServerPort
    private int port;
    
    private WebDriver driver;
    
    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }
    
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    
    @Test
    public void testForexConversionRedirectsToLoginPage() {
        driver.get("http://localhost:" + port + "/forex-conversion");
        assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}