/**
 * Test Case ID: TC_Conversion_004
 * Generated from Jira Ticket: BANK-2960
 * Epic: BANK-749
 * Generated on: 2025-07-04 15:51:51
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
public class CurrencyConversionTest {

    private WebDriver driver;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/currency-conversion");
    }

    @Test
    public void testEdgeCaseINRAmount() {
        // Mock user login
        User mockUser = new User("testUser", "password");
        when(userRepository.findByUsername("testUser")).thenReturn(mockUser);
        when(tokenService.generateToken(mockUser)).thenReturn("mockToken");

        // Input edge case amount
        WebElement amountInput = driver.findElement(By.id("amountInput"));
        amountInput.sendKeys("0.000001"); // Edge case amount in INR

        // Submit the conversion
        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Verify conversion result
        WebElement resultElement = driver.findElement(By.id("conversionResult"));
        String resultText = resultElement.getText();
        double expectedConversion = 0.000001 * 75; // Assuming 1 INR = 75 currency units
        assertEquals(String.valueOf(expectedConversion), resultText, "The conversion result should match the expected value.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}