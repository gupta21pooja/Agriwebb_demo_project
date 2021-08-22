package screen;

import base.BaseTestPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BaseTestPage {

    private static WebDriver driver;


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver =  driver;
    }

    public void enterUserName(String username) {
        writeText(By.id("username-txt"),username);
    }

    public void tapLogin() {
        click(By.id("login-btn"));
    }

    public void enterPassword(String password) {
        writeText(By.id("password-txt"),password);
    }

    public String getPageTitle() { return driver.getTitle(); }
}
