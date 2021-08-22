package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BaseTestPage {

    private static WebDriver driver;
    public WebDriverWait wait;

    public BaseTestPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5000);
    }

    //Click Method
    public void click(By by) { waitVisibility(by).click(); }

    //Write Text
    public void writeText(By by, String text) {
        waitVisibility(by).sendKeys(text);
    }

    //Clear Text
    public void clearText(By by) {
        waitVisibility(by).clear();
    }

    //Read Text
    public String readText(By by) {
        return waitVisibility(by).getText();
    }

    //Is element Available
    public Boolean isElementDisplayed(By by) {
         return waitVisibility(by).isDisplayed() ? true : false;
    }

    //Wait
    public WebElement waitVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
