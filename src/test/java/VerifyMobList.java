import base.BaseTestScript;
import base.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import screen.DashboardPage;
import screen.HomePage;
import screen.LoginPage;
import screen.MobListPage;

public class VerifyMobList extends BaseTestScript {
    public static String BASE_URL = "https://www.agriwebb.com/au/";
    public static String USER_NAME = "gupta21pooja@gmail.com";
    public static String PASSWORD = "Change@1213";
    private DashboardPage dashboardPage;

    @Test
    public void verifyLoginAndNavigateToHomeScreen() {
        driver.get(BASE_URL);

        //Home page
        HomePage homeScreen = new HomePage(driver);
        String actualHomeTitle = homeScreen.getPageTitle();
        String expectedHomeTitle = "AgriWebb | Livestock Farm Management Software";
        Assert.assertTrue(actualHomeTitle.equals(expectedHomeTitle), "Home page has loaded");
        ExtentTestManager.getTest().log(Status.INFO, "Home page has loaded");
        homeScreen.clickOnLoginButton();
        ExtentTestManager.getTest().log(Status.INFO, "Clicked on Login button on home page");


        //Login Page
        LoginPage loginScreen = new LoginPage(driver);
        String actualLoginTitle = loginScreen.getPageTitle();
        String expectedLoginTitle = "AgriWebb";
        Assert.assertTrue(actualLoginTitle.equals(expectedLoginTitle), "Login page has loaded");
        ExtentTestManager.getTest().log(Status.INFO, "Login page has loaded");

        loginScreen.enterUserName(USER_NAME);
        ExtentTestManager.getTest().log(Status.INFO, "Enter username: " +USER_NAME);

        loginScreen.enterPassword(PASSWORD);
        ExtentTestManager.getTest().log(Status.INFO, "Enter password");

        loginScreen.tapLogin();
        ExtentTestManager.getTest().log(Status.INFO, "Click on Login button on login page");

        //Dashboard page
        dashboardPage = new DashboardPage(driver);
        String actualDashboardTitle = dashboardPage.getPageTitle();
        String expectedDashboardTitle = "AgriWebb";
        Assert.assertTrue(actualDashboardTitle.equals(expectedDashboardTitle), "Dashboard page has loaded");
        ExtentTestManager.getTest().log(Status.INFO, "Dashboard page has loaded");
        dashboardPage.clickOnLivestock();
    }

    @Test(dependsOnMethods = "verifyLoginAndNavigateToHomeScreen")
    public void verifyMobListAndUpdate(){

        // View Mob
        MobListPage mobListPage = new MobListPage(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Mob list view is loaded successfully");
        mobListPage.clickOnMobListItem();
        ExtentTestManager.getTest().log(Status.INFO, "Click on first mob from the list");
        mobListPage.clickOnLink();

        //edit mob
        ExtentTestManager.getTest().log(Status.INFO, "Mob edit page has loaded");
        mobListPage.clearMobNameTextField();
        String randomMobListName  = "White " + RandomStringUtils.randomAlphanumeric(7);
        mobListPage.enterMobName(randomMobListName);
        ExtentTestManager.getTest().log(Status.INFO, "Enter new mob name: "+ randomMobListName);

        mobListPage.clickOnSaveButton();
        ExtentTestManager.getTest().log(Status.INFO, "click on Save button");
        mobListPage.navigateBackToMobViewPage();
        ExtentTestManager.getTest().log(Status.INFO, "Mob list view is loaded successfully");

        String newMobName = mobListPage.getMobName();
        Assert.assertTrue(newMobName.equals(randomMobListName), "The mob list has been updated with the new name");
        ExtentTestManager.getTest().log(Status.INFO, "The mob list has been updated with the new name: "+ randomMobListName);

        //Account Screen
        dashboardPage.clickOnAccount();
        ExtentTestManager.getTest().log(Status.INFO, "Account page has loaded");
        dashboardPage.clickOnSignout();
        ExtentTestManager.getTest().log(Status.INFO, "Sign-out from app");
    }
}
