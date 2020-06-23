import java.util.List;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUserLogIn {

	static String[][] users = {
			{ "Charles", "Patsanza", "charlesp", "testpassword1", "Admin", "charles@yahoo.com", "08212345678" },
			{ "Peter", "CCC", "peter2", "testpassword2", "Customer", "peter@yahoo.com", "0821237578" }, };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");

		WebElement userTable = driver.findElement(new By.ByClassName("smart-table"));

		if (!userTable.isDisplayed()) {// ensure user table exists
			throw new RuntimeException("Table .smart-table not displayed!");
		}

		for (int i = 0; i < users.length; i++) {

			WebElement addBtn = driver.findElement(new By.ByCssSelector("button[type=add]"));
			addBtn.click();

			WebElement firstName = driver.findElement(new By.ByName("FirstName"));
			firstName.clear();
			firstName.sendKeys(users[i][0]);

			WebElement lastName = driver.findElement(new By.ByName("LastName"));
			lastName.clear();
			lastName.sendKeys(users[i][1]);

			WebElement userName = driver.findElement(new By.ByName("UserName"));
			userName.clear();
			userName.sendKeys(users[i][2] + UUID.randomUUID().toString().substring(0, 4));// unique user names using uuid class

			WebElement password = driver.findElement(new By.ByName("Password"));
			password.clear();
			password.sendKeys(users[i][3]);

			WebElement companyId = driver.findElements(new By.ByName("optionsRadios")).get(i);
			companyId.click();

			Select roleId = new Select(driver.findElement(new By.ByName("RoleId")));
			roleId.selectByVisibleText(users[i][4]);

			WebElement email = driver.findElement(new By.ByName("Email"));
			email.clear();
			email.sendKeys(users[i][5]);

			WebElement mobilephone = driver.findElement(new By.ByName("Mobilephone"));
			mobilephone.clear();
			mobilephone.sendKeys(users[i][6]);

			WebElement submitBtn = driver.findElement(new By.ByCssSelector(".modal-footer > .btn-success"));
			submitBtn.click();
		}
	}

}
