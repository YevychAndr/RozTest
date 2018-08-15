package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "login")
    public WebElement loginField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@name='auth_submit']")
    public WebElement btnAuthSbmit;

    public AuthorizedPage login(String login, String password){
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        click(btnAuthSbmit);
        return new AuthorizedPage(driver);
    }

}
