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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ForexExchangeTest {

    private WebDriver driver;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ForexExchangeController forexExchangeController;

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
    public void testForexExchange() {
        // Mocking the forex rate response
        when(restTemplate.getForEntity(any(String.class), any())).thenReturn(new ResponseEntity<>(new ForexRateResponse(0.013, "2023-10-10T10:00:00Z"), HttpStatus.OK));

        // Input INR amount
        WebElement amountInput = driver.findElement(By.id("amountInput"));
        amountInput.sendKeys("1000");

        // Click Convert button
        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Check converted amount
        WebElement resultElement = driver.findElement(By.id("result"));
        assertEquals("13.0 USD", resultElement.getText());

        // Check timestamp
        WebElement timestampElement = driver.findElement(By.id("timestamp"));
        assertEquals("2023-10-10T10:00:00Z", timestampElement.getText());

        // Verify transaction log
        // This would typically involve checking a database or a service call to retrieve logs
    }
}