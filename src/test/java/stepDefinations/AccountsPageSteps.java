package stepDefinations;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	@Given("user has already logged into the application")
	public void user_has_already_logged_into_the_application(DataTable credTable) { // datatable returns asMaps and asList
		List<Map<String,String>> credList = credTable.asMaps();
		String userNm = credList.get(0).get("username");
		String passwd = credList.get(0).get("password");
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.doLogin(userNm, passwd);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountsPage.getAccPageTitle();
		System.out.println("Accounts page title is " + title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable expectedAccountSectionTable) {
		
		List<String> expectedCountSectionList = expectedAccountSectionTable.asList();
		System.out.println("Account section expected count " + expectedCountSectionList);
		
		List<String> actualCountSectionList =accountsPage.getAccountsSectionList();
		System.out.println("Account section actual count " + actualCountSectionList);
		
		Assert.assertTrue(expectedCountSectionList.containsAll(actualCountSectionList));

	}
	
	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount );

	}
}
