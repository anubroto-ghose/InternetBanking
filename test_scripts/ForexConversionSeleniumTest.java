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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ForexConversionSeleniumTest {

    private WebDriver driver;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TokenService tokenService;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");
    }

    @Test
    public void testForexConversion() {
        // Mocking services
        when(tokenService.isValidToken(anyString())).thenReturn(true);
        when(accountService.getBalance(anyInt())).thenReturn(10000.0);

        // Log in
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("testUser");
        passwordField.sendKeys("testPassword");
        loginButton.click();

        // Navigate to Forex conversion
        driver.get("http://localhost:8080/forex");

        // Perform conversion
        WebElement amountField = driver.findElement(By.id("amount"));
        WebElement convertButton = driver.findElement(By.id("convertButton"));
        amountField.sendKeys("1000");
        convertButton.click();

        // Assert conversion result
        WebElement resultElement = driver.findElement(By.id("conversionResult"));
        String resultText = resultElement.getText();
        assertTrue(resultText.contains("JPY"), "Conversion result should include JPY");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}