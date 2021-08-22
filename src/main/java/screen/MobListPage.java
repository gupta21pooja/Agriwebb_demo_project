package screen;

import base.BaseTestPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MobListPage extends BaseTestPage {

    private static WebDriver driver;

    public MobListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickOnMobListItem() {
        click(By.partialLinkText("White"));
    }

    public String getPageHeader() {
        return readText(By.xpath("//*[@id='mob-dialog']/div/div/div[1]/h4"));
    }

    public void clickOnLink() {
        click(By.xpath("//*[@id='mob-details-toolbar']/div/button"));
    }

    public void clearMobNameTextField() {
        clearText(By.id("title-txt"));
    }

    public void enterMobName(String randomMobListName) {
        writeText(By.id("title-txt"),randomMobListName);
    }

    public void clickOnSaveButton() {
        click(By.id("form-dialog-save-btn"));
    }

    public void navigateBackToMobViewPage() {
        click(By.xpath("//*[@id='mob-dialog']/div/div/button"));
    }


    public String getMobName() {
        return readText(By.partialLinkText("White"));
    }

}
