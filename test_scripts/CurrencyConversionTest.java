/**
 * Test Case ID: TC_Conversion_001
 * Generated from Jira Ticket: BANK-3109
 * Epic: BANK-3083
 * Generated on: 2025-07-04 14:06:13
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CurrencyConversionTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private WebDriver driver;

    @Test
    public void testCurrencyConversion() {
        driver = new ChromeDriver();
        driver.get("http://localhost:" + port + "/currency-conversion");
        WebElement amountField = driver.findElement(By.id("amount"));
        amountField.sendKeys("1000");
        WebElement convertButton = driver.findElement(By.id("convert"));
        convertButton.click();
        WebElement convertedAmount = driver.findElement(By.id("convertedAmount"));
        Assertions.assertEquals("ExpectedJPYAmount", convertedAmount.getText());
        driver.quit();
    }
}