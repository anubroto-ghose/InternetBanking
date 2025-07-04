package com.webapp.bankingportal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class CurrencyConversionTest {

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private UserRepository userRepository;

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/bankingportal");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCurrencyConversionPrecision() {
        // Mocking the AccountService response
        when(accountService.convertCurrency(any(Double.class), any(String.class), any(String.class))).thenReturn(74.12345);

        // Input amount in INR
        WebElement amountInput = driver.findElement(By.id("amountInINR"));
        amountInput.sendKeys("100.12345");

        // Trigger conversion
        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Verify the converted amount in USD
        WebElement resultElement = driver.findElement(By.id("resultUSD"));
        String resultText = resultElement.getText();

        // Assert the precision of the converted amount
        assertEquals("74.12345", resultText);
    }
}