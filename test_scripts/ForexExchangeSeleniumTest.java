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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ForexExchangeSeleniumTest {

    @Autowired
    private AccountService accountService;

    @MockBean
    private UserRepository userRepository;

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testForexExchangeConversion() {
        // Mocking behavior
        when(accountService.getExchangeRate()).thenReturn(74.5);
        when(accountService.convertINRToUSD(anyDouble())).thenAnswer(invocation -> {
            double amountInINR = invocation.getArgument(0);
            return amountInINR / 74.5;
        });

        driver.get("http://localhost:8080/forex");

        // Input amount in INR
        WebElement amountInput = driver.findElement(By.id("amountInINR"));
        amountInput.sendKeys("1000");

        // Submit conversion
        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Assert converted value
        WebElement resultElement = driver.findElement(By.id("resultUSD"));
        String resultText = resultElement.getText();
        assertEquals("Converted Amount: 13.39 USD", resultText);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}