package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddContactTest {

	WebDriver driver;

//Test Data
	ExcelReader exlRead = new ExcelReader("testData\\testDataSheet.xlsx"); // copy test data folder path

	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String DashboardValidationText = "Dashboard";
	String fullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
	String company = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlRead.getCellData("AddContactInfo", "Email", 2);
	String phone = exlRead.getCellData("AddContactInfo", "Phone", 2);
	String address = exlRead.getCellData("AddContactInfo", "Address", 2);
	String city = exlRead.getCellData("AddContactInfo", "City", 2);
	String country = exlRead.getCellData("AddContactInfo", "Country", 2);
	String state = exlRead.getCellData("AddContactInfo", "State", 2);
	String zip = exlRead.getCellData("AddContactInfo", "Zip", 2);

	@Test
	public void userShouldBeAbleToAddCustomer() {

		driver = BrowserFactory.init();

		LoginPage LogInPage = PageFactory.initElements(driver, LoginPage.class);

		LogInPage.insertUserName(userName);
		LogInPage.insertPassword(password);
		LogInPage.clickSigninButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(DashboardValidationText);
		dashboardPage.clickCustomersButton();
		dashboardPage.clickAddCustomerButton();

		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
		addContactPage.insertFullName(fullName);
		addContactPage.selectCompany(company);
		addContactPage.insertEmail(email);
		addContactPage.insertPhoneNum(phone);
		addContactPage.insertAddress(address);
		addContactPage.insertCity(city);
		addContactPage.insertState(state);
		addContactPage.insertZip(zip);
		addContactPage.selectCountry(country);
		addContactPage.clickSaveButton();




	}

}
