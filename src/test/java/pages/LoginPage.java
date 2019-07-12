package pages;

import base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseUtil{

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "UserName") WebElement txtUserName;
    @FindBy(name = "Password") WebElement txtPassword;
    @FindBy(how = How.NAME, using = "Login") WebElement btnLogin; //This is an alternative @FindBy parameterization

    public void login(String username, String password) {
        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.submit();
    }

}
