package com.webapp.bankingportal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.RequestBody;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyConversionTest {

    @Mock
    private AccountService accountService;
    
    @InjectMocks
    private UserRepository userRepository;
    
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/bankingportal");
    }

    @Test
    public void testCurrencyConversionDecimalPrecision() {
        // Mocking the service response
        double inputAmount = 1234.56;
        double expectedOutput = 15.67; // Assume this is the expected conversion result
        when(accountService.convertCurrency(inputAmount, "INR", "USD")).thenReturn(expectedOutput);

        // Input amount in INR
        WebElement inputField = driver.findElement(By.id("amountInINR"));
        inputField.sendKeys(String.valueOf(inputAmount));

        // Trigger currency conversion
        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Verify the converted amount in USD
        WebElement resultField = driver.findElement(By.id("resultInUSD"));
        double actualOutput = Double.parseDouble(resultField.getText());

        // Assertion
        assertEquals(expectedOutput, actualOutput, 0.01);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}