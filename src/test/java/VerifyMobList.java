import base.BaseTestScript;
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
        homeScreen.clickOnLoginButton();
        Assert.assertTrue(true, "Click on Login button");


        //Login Page
        LoginPage loginScreen = new LoginPage(driver);
        String actualLoginTitle = loginScreen.getPageTitle();
        String expectedLoginTitle = "AgriWebb";
        Assert.assertTrue(actualLoginTitle.equals(expectedLoginTitle), "Login page has loaded");
        loginScreen.enterUserName(USER_NAME);
        loginScreen.enterPassword(PASSWORD);
        loginScreen.tapLogin();

        //Dashboard page
        dashboardPage = new DashboardPage(driver);
        String actualDashboardTitle = dashboardPage.getPageTitle();
        String expectedDashboardTitle = "AgriWebb";
        Assert.assertTrue(actualDashboardTitle.equals(expectedDashboardTitle), "Dashboard page has loaded");
        dashboardPage.clickOnLivestock();
    }

    @Test(dependsOnMethods = "verifyLoginAndNavigateToHomeScreen")
    public void verifyMobListAndUpdate(){

        // View Mob list
        MobListPage mobListPage = new MobListPage(driver);
        mobListPage.clickOnMobListItem();
        String pageTitle = mobListPage.getPageHeader();
        mobListPage.clickOnLink();

        //Edit mob list
        mobListPage.clearMobNameTextField();
        String randomMobListName  = "White " + RandomStringUtils.randomAlphanumeric(7);
        mobListPage.enterMobName(randomMobListName);
        mobListPage.clickOnSaveButton();
        mobListPage.navigateBackToMobViewPage();

        //Account Screen
        dashboardPage.clickOnAccount();
        dashboardPage.clickOnSignout();
    }
}
