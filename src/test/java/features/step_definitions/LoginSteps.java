package features.step_definitions;

import base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

import java.util.List;

public class LoginSteps {

    private WebDriver driver;

    public LoginSteps() {
        BaseUtil base = new BaseUtil();
        driver = base.getDriver();
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() {
        driver.navigate().to("http://executeautomation.com/demosite/Login.html");
    }

    @When("^I enter the following details for Login$")
    public void iEnterTheFollowingDetailsForLogin(DataTable table) {
        List<User> users = table.asList(User.class);

        LoginPage page = new LoginPage(driver);
        for (User user: users) {
            page.login(user.username, user.password);
        }
    }

    @And("^I click login button$")
    public void iClickLoginButton() {
        LoginPage page = new LoginPage(driver);
        page.clickLogin();
    }

    @Then("^I should see the user form page$")
    public void iShouldSeeTheUserFormPage() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.id("Initial")).isDisplayed(), "Element not displayed.");
    }

    public class User {
        private String username;
        private String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

    }
}
