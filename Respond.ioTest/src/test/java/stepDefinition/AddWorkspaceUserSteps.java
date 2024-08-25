package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page.HomePage;
import page.LoginPage;
import utils.BaseClass;

public class AddWorkspaceUserSteps extends BaseClass {
    final String removeButtonTextToBeMatched = "Remove";
    LoginPage login;
    HomePage home;

    @Given("User is logged In")
    public void user_is_logged_in() {
        login = launchApplication();
        login.enterUserName();
        login.enterPassword();
        home = login.clickLoginButton();
    }

    @When("User clicks on menu button")
    public void user_clicks_on_menu_button() throws InterruptedException {
        home.clickMenuButton();
    }

    @When("Clicks on settings button inside menu")
    public void clicks_on_settings_button_inside_menu() throws InterruptedException {
        home.clickSettingsButton();
    }

    @When("Clicks on user button under workspace section")
    public void clicks_on_user_button_under_workspace_section() throws InterruptedException {
        home.clickWorkspaceUserButton();
    }

    @When("Clicks on add user button")
    public void clicks_on_add_user_button() throws InterruptedException {
        home.clickAddUserButton();
    }

    @When("Enters workspace user email")
    public void enters_workspace_user_email() throws InterruptedException {
        home.enterWorkspaceUserEmail();
    }

    @When("Clicks on add user email button")
    public void clicks_on_add_user_email_button() throws InterruptedException {
        home.clickAddUserEmailButton();
    }

    @Then("Verify the workspace user is added successfully")
    public void verify_the_workspace_user_is_added_successfully() {
        Assert.assertTrue(home.verifyUserAddedSuccessMessage());
    }

    @After
    public void afterScenario() {
        tearDown();
    }
}
