package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddContactPage extends BasePage {

	WebDriver driver;

	public AddContactPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement fullNameElement;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement companyElement;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement emailElement;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement PhoneElement;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement addressElement;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement cityElement;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement stateElement;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement zipElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement countryElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement saveElement;

	String insertedName;

	public void insertFullName(String fullName) {
		String insertedName = fullName + generateRandomNum(999);
		fullNameElement.sendKeys(insertedName);

	}

	public void selectCompany(String company) {

		selectFromDropDown(companyElement, company);

	}

	public void insertEmail(String email) {
		emailElement.sendKeys(generateRandomNum(9999) + email);

	}

	public void insertPhoneNum(String phoneNum) {
		PhoneElement.sendKeys(phoneNum);
	}

	public void insertAddress(String address) {
		addressElement.sendKeys(address);
	}

	public void insertCity(String city) {
		cityElement.sendKeys(city);
	}

	public void insertState(String state) {
		stateElement.sendKeys(state);
	}

	public void insertZip(String zip) {
		zipElement.sendKeys(zip);
	}

	public void selectCountry(String country) {
		selectFromDropDown(countryElement, country);
	}

	public void clickSaveButton() {
		saveElement.click();
	}

//	//tbody/tr[1]/td[3]/a
	// tbody/tr[2]/td[3]/a

	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]/a";

	public void validateInsertName() {
		for (int i = 1; i <= 10; i++) {
			String actualName = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(actualName);
			Assert.assertEquals(actualName, insertedName, "name not found!");
			break;

		}
	}

}
