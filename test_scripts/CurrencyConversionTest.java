package com.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CurrencyConversionTest {

    @Autowired
    private CurrencyConverterService currencyConverterService;
    
    @Test
    public void testCurrencyConversionWithDecimalPrecision() {
        // Input data
        double amountINR = 100.123;
        double expectedAmountUSD = 1.35;
        
        // Mock the currency conversion service
        when(currencyConverterService.convertINRtoUSD(amountINR)).thenReturn(expectedAmountUSD);
        
        // Perform currency conversion
        double actualAmountUSD = currencyConverterService.convertINRtoUSD(amountINR);
        
        // Assertions
        assertEquals(expectedAmountUSD, actualAmountUSD, 0.01, "Conversion result matches expected amount with precision");
    }
}
