/**
 * Test Case ID: TC_Conversion_003
 * Generated from Jira Ticket: BANK-3072
 * Epic: BANK-749
 * Generated on: 2025-07-04 18:25:07
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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

    @Test
    public void testZeroAmountConversion() {
        // Input '0' into the conversion field.
        WebElement conversionField = driver.findElement(By.id("conversionField"));
        conversionField.sendKeys("0");

        // Click the 'Convert' button.
        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Expected Results: USD value should be '0'.
        WebElement resultField = driver.findElement(By.id("resultField"));
        String result = resultField.getText();
        assertEquals("0", result);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}