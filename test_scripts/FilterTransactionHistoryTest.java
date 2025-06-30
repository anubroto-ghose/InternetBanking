@SpringBootTest
@ExtendWith(SpringExtension.class)
public class FilterTransactionHistoryTest {

	@Autowired
	private WebDriver driver;

	@MockBean
	private UserService userService;

	@Test
	public void testFilterTransactionHistoryByDateRange() {
		driver.get("http://bankingportal.com");

		// Login to the banking portal
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("username", "password");

		// Navigate to transaction history page
		TransactionHistoryPage historyPage = new TransactionHistoryPage(driver);
		historyPage.navigateToHistoryPage();

		// Set date range filter
		historyPage.setFilterDateRange("01/01/2022", "02/01/2022");

		// Verify filtered transactions
		List<Transaction> filteredTransactions = historyPage.getFilteredTransactions();
		assertEquals(2, filteredTransactions.size(), "Filtered transactions size doesn't match");
	}
}