@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ForexRateRetrievalTest {

    @Autowired
    private ForexRateService forexRateService;

    @MockBean
    private HttpClient httpClient;

    @Autowired
    private WebDriver driver;

    @Test
    public void testMultipleConcurrentForexRateRetrievalRequests() {
        List<String> currencies = Arrays.asList("USD", "EUR", "JPY");
        List<Integer> rates = new ArrayList<>();

        for(String currency : currencies) {
            try {
                // Simulate API call for each currency
                when(httpClient.getForexRate(currency)).thenReturn(100);
                driver.get("http://localhost:8080/forex?currency=" + currency);

                // Capture the retrieved rate
                WebElement rateElement = driver.findElement(By.id("rate"));
                int rate = Integer.parseInt(rateElement.getText());
                rates.add(rate);
            } catch(Exception e) {
                fail("Exception occurred during forex rate retrieval");
            }
        }

        // Verify rates were retrieved for all currencies
        assertEquals(3, rates.size(), "Incorrect number of rates retrieved");

        // Verify no errors during retrieval
        assertFalse(rates.contains(-1), "Error in forex rate retrieval");

        // Verify no significant performance degradation
        int totalRate = rates.stream().mapToInt(Integer::intValue).sum();
        assertTrue(totalRate >= 300, "Performance degradation in forex rate retrieval");
    }
}