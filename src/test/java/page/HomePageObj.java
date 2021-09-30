package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObj extends BaseTest {


    @FindBy(css = "div[title='Giriş Yap']")
    public static WebElement loginIcon;

    @FindBy(css = "[data-cy='header-login-button']")
    public static WebElement loginPageButton;

    @FindBy(id = "L-UserNameField")
    public static WebElement userNameTextBox;

    @FindBy(id = "L-PasswordField")
    public static WebElement passWordTextBox;

    @FindBy(id = "gg-login-enter")
    public static WebElement loginButton;

    @FindBy(css = "div[class='gekhq4-4 egoSnI']")
    public static WebElement myAccountText;





}