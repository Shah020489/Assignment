package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ConfigUtil;

import java.util.Properties;

public class LoginPage {

    static Properties configProperties;
    protected static String homePageUrlRespond = setConfig().getProperty("homePageUrlRespond");
    protected static String username = setConfig().getProperty("webUserName");
    protected static String password = setConfig().getProperty("webPassword");
    static String baseUrlRespond = setConfig().getProperty("baseUrlRespond");
    By emailAddressTextBox = By.cssSelector("[placeholder=\"Email address\"]");
    By passwordTextBox = By.cssSelector("[placeholder=\"Password\"]");
    By signInButton = By.cssSelector("[type=\"submit\"]");
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static Properties setConfig() {
        return configProperties = ConfigUtil.getConfig("config");
    }

    public void navigateToRespond() {
        driver.get(baseUrlRespond);
    }

    public void verifyUserIsOnLoginPage() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, baseUrlRespond);
    }

    public void enterUserName() {
        driver.findElement(emailAddressTextBox).sendKeys(username);
    }

    public void enterPassword() {
        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public HomePage clickLoginButton() {
        driver.findElement(signInButton).click();
        return new HomePage(driver);
    }

    public void verifyUserIsOnHomePage() {
        String homePageRespond = driver.getCurrentUrl();
        Assert.assertEquals(homePageRespond, homePageUrlRespond);
    }
}
