/**
 * Test Case ID: TC_Conversion_003
 * Generated from Jira Ticket: BANK-2959
 * Epic: BANK-749
 * Generated on: 2025-07-04 15:52:08
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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ExchangeRateConversionTest {

    private WebDriver driver;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private ExchangeRateConversionTest exchangeRateConversionTest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/bankingportal");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testExchangeRateConversion() {
        // Arrange
        when(accountService.getExchangeRate("INR", "USD")).thenReturn(0.013);

        // Act
        WebElement amountInput = driver.findElement(By.id("amountInput"));
        amountInput.sendKeys("1000");
        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Assert
        WebElement resultElement = driver.findElement(By.id("conversionResult"));
        String resultText = resultElement.getText();
        double expectedValue = 1000 * 0.013;
        assertEquals(String.format("%.2f", expectedValue), resultText);
    }
}