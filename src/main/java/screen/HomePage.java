package screen;

import base.BaseTestPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BaseTestPage {

    private static WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver =  driver;
    }

    public void clickOnLoginButton() {
        click(By.linkText("Login"));
    }
    public String getPageTitle() { return driver.getTitle(); }
}
