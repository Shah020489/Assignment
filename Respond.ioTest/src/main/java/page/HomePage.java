package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigUtil;

import java.util.Properties;

public class HomePage {
    static Properties configProperties;
    protected static String workspaceUserEmail = setConfig().getProperty("workspaceUserEmail");
    private final WebDriver driver;
    private final String logoutButtonText = "Logout";
    By menuButton = By.cssSelector("[class=\"v-list-item__content\"]>[aria-haspopup=\"menu\"]");
    By settingButton = By.cssSelector(
            "[class=\"v-btn__content\"] [class=\"dls-line-height-0 isax-setting-2 dls-h-icon-lg dls-w-icon-lg dls-text-icon-lg\"]");
    By workspaceUserButton = By.xpath("(//span[text()=\"Users\"])[1]");
    By addUserButton = By.xpath("(//button[@data-pw=\"btn-add-usr\"])[2]");
    By inputEmailTextBox = By.xpath("//input[@placeholder=\"Email Address\"]");
    By addUserEmailButton =
            By.cssSelector("[class=\"dls-flex dls-space-x-8 rtl:dls-space-x-reverse dls-ms-auto\"]>button+button");
    By addUserSuccessMessage = By.cssSelector("[class=\"dls-text-text-primary dls-txt-body\"]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public static Properties setConfig() {
        return configProperties = ConfigUtil.getConfig("config");
    }

    public void clickMenuButton() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(menuButton).click();
    }

    public void clickSettingsButton() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(settingButton).click();
    }

    public void clickWorkspaceUserButton() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(workspaceUserButton).click();
    }

    public void clickAddUserButton() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(addUserButton).click();
    }

    public void enterWorkspaceUserEmail() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(inputEmailTextBox).sendKeys(workspaceUserEmail);
    }

    public void clickAddUserEmailButton() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(addUserEmailButton).click();
    }

    public Boolean verifyUserAddedSuccessMessage() {
        return driver.findElement(addUserSuccessMessage).isDisplayed();
    }
}
