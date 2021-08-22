package screen;

import base.BaseTestPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BaseTestPage {
    private static WebDriver driver;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver =  driver;
    }

    public void clickOnLivestock(){
        click(By.id("primary-navigation-menu-livestock-desktop"));
    }

    public void clickOnAccount() {
        click(By.id("primary-navigation-menu-account-desktop"));
    }

    public void clickOnSignout() {
        click(By.xpath("//button[text()=' Sign out ']"));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}
