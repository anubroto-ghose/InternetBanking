/**
 * Test Case ID: TC_Conversion_002
 * Generated from Jira Ticket: BANK-2958
 * Epic: BANK-749
 * Generated on: 2025-07-04 15:52:23
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

    @InjectMocks
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/currency-conversion");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testInvalidAmountInput() {
        // Arrange
        String invalidAmount = "abc";
        String expectedErrorMessage = "Invalid amount entered. Please enter a valid number in INR.";

        // Act
        WebElement amountInput = driver.findElement(By.id("amountInput"));
        amountInput.sendKeys(invalidAmount);
        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Assert
        WebElement errorMessageElement = driver.findElement(By.id("errorMessage"));
        String actualErrorMessage = errorMessageElement.getText();
        assertEquals(expectedErrorMessage, actualErrorMessage);
        assertFalse(driver.findElement(By.id("conversionResult")).isDisplayed(), "Conversion result should not be displayed for invalid input.");
    }
}