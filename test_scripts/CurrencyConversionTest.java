/**
 * Test Case ID: TC_Conversion_002
 * Generated from Jira Ticket: BANK-3071
 * Epic: BANK-749
 * Generated on: 2025-07-04 18:25:23
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CurrencyConversionTest {

    private WebDriver driver;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/currency-conversion");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testInvalidINRAmountConversion() {
        // Input invalid INR amount
        WebElement amountInput = driver.findElement(By.id("amount"));
        amountInput.sendKeys("-500"); // Test with negative amount

        // Click the Convert button
        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Verify error message
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed(), "Error message should be displayed");
        assertEquals("Invalid amount. Please enter a positive number.", errorMessage.getText());

        // Test with non-numeric input
        amountInput.clear();
        amountInput.sendKeys("abc");
        convertButton.click();

        assertTrue(errorMessage.isDisplayed(), "Error message should be displayed");
        assertEquals("Invalid amount. Please enter a positive number.", errorMessage.getText());
    }
}