/**
 * Test Case ID: TC_Conversion_003
 * Generated from Jira Ticket: BANK-2959
 * Epic: BANK-749
 * Generated on: 2025-07-04 15:37:27
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class ExchangeRateConversionTest {

    private WebDriver driver;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        Mockito.when(accountService.getExchangeRate("INR", "USD")).thenReturn(0.013); // Mock exchange rate
    }

    @Test
    public void testExchangeRateConversion() {
        driver.get("http://localhost:8080/bankingportal");

        WebElement amountField = driver.findElement(By.id("amountField"));
        amountField.sendKeys("1000");

        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        WebElement resultField = driver.findElement(By.id("resultField"));
        String result = resultField.getText();

        double expectedResult = 1000 * 0.013;
        assertEquals(String.format("%.2f", expectedResult), result);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}