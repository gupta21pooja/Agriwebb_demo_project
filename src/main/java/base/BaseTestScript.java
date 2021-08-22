package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;




public class BaseTestScript {

    public static WebDriver driver;
    public WebDriverWait wait;


    private static final String CHROME_KEY = "webdriver.chrome.driver";
    private static final String CHROME_VALUE = "./chromedriver";


    @BeforeTest
    public void before() {
        System.setProperty(CHROME_KEY, CHROME_VALUE);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 500);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
