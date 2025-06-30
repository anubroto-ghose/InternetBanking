@SpringBootTest
@ExtendWith(SpringExtension.class)
public class FilterTransactionHistoryTest {

	@Autowired
	private WebDriver driver;

	@MockBean
	private UserService userService;

	@Test
	public void testFilterTransactionHistoryByDateRange() {
		driver.get("https://bankingportal.com");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("username", "password");

		TransactionHistoryPage transactionHistoryPage = new TransactionHistoryPage(driver);
		transactionHistoryPage.navigateTo();

		DateRangeFilter dateRangeFilter = new DateRangeFilter("01/01/2021", "01/31/2021");
		transactionHistoryPage.applyDateRangeFilter(dateRangeFilter);

		List<Transaction> filteredTransactions = transactionHistoryPage.getFilteredTransactions();

		for (Transaction transaction : filteredTransactions) {
			assertTrue(transaction.getDate().after(dateRangeFilter.getStartDate()), "Transaction date should be after start date");
			assertTrue(transaction.getDate().before(dateRangeFilter.getEndDate()), "Transaction date should be before end date");
		}
	}
}