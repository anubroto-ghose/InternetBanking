package com.webapp.bankingportal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
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
        // Mocking the currency conversion response
        double inputAmount = 1234.56;
        double expectedConvertedAmount = 16.67; // Example expected value
        when(accountService.convertCurrency(inputAmount, "INR", "USD"))
            .thenReturn(new ResponseEntity<>(expectedConvertedAmount, HttpStatus.OK));

        // Inputting amount in INR
        driver.findElement(By.id("amountInput"))
              .sendKeys(String.valueOf(inputAmount));

        // Triggering conversion
        driver.findElement(By.id("convertButton")).click();

        // Verifying the converted amount
        String convertedAmountText = driver.findElement(By.id("convertedAmount"))
                                         .getText();
        double convertedAmount = Double.parseDouble(convertedAmountText);

        assertEquals(expectedConvertedAmount, convertedAmount, 0.01, "The converted amount does not match the expected precision.");
    }
}