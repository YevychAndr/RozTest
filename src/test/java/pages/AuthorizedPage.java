package pages;

import model.MainMenu;
import model.SubMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class AuthorizedPage extends BasePage  {

    public AuthorizedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        }

    @FindBy(css = "#fat-menu li.f-menu-l-i")
    public List<WebElement> mainMenuItems;

    @FindBy(css = "li.f-menu-sub-l-i")
    public List<WebElement> subMenuItems;

    @FindBy(id = "header_user_menu_parent")
    public WebElement btnLogin;

    @FindBy(id = "fat_menu_btn")
    public WebElement btnCatalogGoods;

    @FindBy(xpath = "//a[@name='profile']")
    public WebElement btnProf;

    @FindBy(xpath = "//a[@name='cart']")
    public WebElement btnCart;

    @FindBy(xpath = "//div[2]/ul[1]/li[1]/a[1]")
    public WebElement linkQuestionAnswer;

    @FindBy(xpath = "//div[2]/ul[1]/li[2]/a[1]")
    public WebElement linkCredit;

    @FindBy(xpath = "//div[2]/ul[1]/li[3]/a[1]")
    public WebElement linkShippingPayment;

    @FindBy(xpath = "//div[2]/ul[1]/li[4]/a[1]")
    public WebElement linkGuarantee;

    @FindBy(xpath = "//div[2]/ul[1]/li[5]/a[1]")
    public WebElement linkContacts;



    public LoginPage callLoginPage() {
        click(btnLogin);
        return new LoginPage(driver);
    }

    public void checkNotLogged (){
        Assert.assertEquals("войдите в личный кабинет", btnLogin.getText(), "Ви вже залогінені.");
    }

    public void checkLogged() {
        //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='popup-css popup-auth']")));
        Assert.assertTrue(btnProf.isDisplayed(), "Ви не залогінені");
    }

    public void openCatalogGoods(){
        moveTo(btnCatalogGoods);
    }

    public void openCategoryGoods(MainMenu menuToOpen){
        for (WebElement item: mainMenuItems){
            if(item.getAttribute("id").equals(menuToOpen.getElementId())){
                moveTo(item);
                return;
            }
        }
    }

    public GoodsPage openSubcategoryGoods(SubMenu subMenuToOpen) {
        for (WebElement item: subMenuItems){
            if(item.getText().equals(subMenuToOpen.getElementText())){
                click(item);
            return new GoodsPage(driver);
            }
        }
        return null;
    }

    public CartPage goCart() {
        moveTo(btnProf);
        click(btnCart);
        return new CartPage(driver);
    }

    public QuestionAnswerPage callQuestionAnswer() {
        click(linkQuestionAnswer);
        return new QuestionAnswerPage(driver);
    }

    public CreditPage callCreditPage() {
        click(linkCredit);
        return new CreditPage(driver);
    }

    public ShippingPaymenPage callShippingPaymen() {
        click(linkShippingPayment);
        return new ShippingPaymenPage(driver);
    }

    public GuaranteePage callGuaranteePage() {
        click(linkGuarantee);
        return new GuaranteePage(driver);
    }

    public ContactsPage callContactsPage() {
        click(linkContacts);
        return new ContactsPage(driver);
    }
}
