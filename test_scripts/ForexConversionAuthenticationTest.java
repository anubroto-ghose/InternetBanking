/**
 * Test Case ID: TC_Forex_Conversion_002
 * Generated from Jira Ticket: BANK-3106
 * Epic: BANK-3083
 * Generated on: 2025-07-04 14:07:42
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ForexConversionAuthenticationTest {

    @LocalServerPort
    private int port;

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testFailedForexConversionDueToInvalidAuthentication() {
        driver.get("http://localhost:" + port + "/admin/forex/convert");

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("admin");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("invalidpassword");

        WebElement submitButton = driver.findElement(By.id("submit-button"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-message"));

        String errorText = errorMessage.getText();
        Assertions.assertEquals("Authentication error: Invalid credentials provided.", errorText);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}