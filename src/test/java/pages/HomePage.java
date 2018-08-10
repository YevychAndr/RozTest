package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "signin")
    public WebElement btnLogin;

    @FindBy(name = "signin")
    public WebElement goOffice;

    public LoginPage callLoginPage() {
        click(btnLogin);
        return new LoginPage(driver);
    }

    public void checkNotLogged (){
        check(goOffice);
        }
}
