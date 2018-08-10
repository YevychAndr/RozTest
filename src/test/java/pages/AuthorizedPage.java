package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizedPage extends BasePage  {

    public AuthorizedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "fat_menu_btn")
    public WebElement btnCatalogGoods;

    @FindBy(id = "9017")
    public WebElement categoryGoods;

    @FindBy(id = "8261")
    public WebElement categoryGoods2;

    @FindBy(id = "13224")
    public WebElement categoryGoods3;

    @FindBy(xpath = "//a[contains(text(),'Катушки')]")
    //@FindBy(xpath = "//li[8]//ul[2]/li[1]/ul[1]/li[3]/a[1]")
    public WebElement linkToCoil;

    @FindBy(xpath = "//a[@class='f-menu-sub-l-i-link novisited'][contains(text(),'Тачки')]")
    //@FindBy(xpath = "//li[7]//ul[2]/li[1]/ul[1]/li[4]/a[1]")
    public WebElement linkWheelbarrow;

    @FindBy(xpath = "//a[@class='f-menu-sub-l-i-link novisited'][contains(text(),'Радионяни')]")
    public WebElement linkBabymonitors;

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



    public void openCatalogGoods(){
        moveTo(btnCatalogGoods);
    }

    public void openCategoryGoods(){
        moveTo(categoryGoods);
    }

    public GoodsPage openSubcategoryGoods() {
        click(linkToCoil);
        return new GoodsPage(driver);
    }

    public void openCategoryGoods2() {
        moveTo(categoryGoods2);
    }

    public GoodsPage openSubcategoryGoods2(){
        click(linkWheelbarrow);
        return new GoodsPage(driver);
    }

    public void openCategoryGoods3(){
        moveTo(categoryGoods3);
    }

    public GoodsPage openSubcategoryGoods3(){
        click(linkBabymonitors);
        return new GoodsPage(driver);
    }

    public CartPage goCart() {
        moveTo(btnProf);
        click(btnCart);

        return new CartPage(driver);
    }

    public QuestionAnswerPage callQuestionAnswer() {
        click(linkQuestionAnswer);
        return new QuestionAnswerPage();
    }

    public CreditPage callCreditPage() {
        click(linkCredit);
        return new CreditPage();
    }

    public ShippingPaymenPage callShippingPaymen() {
        click(linkShippingPayment);
        return new ShippingPaymenPage();
    }

    public GuaranteePage callGuaranteePage() {
        click(linkGuarantee);
        return new GuaranteePage();
    }

    public ContactsPage callContactsPage() {
        click(linkContacts);
        return new ContactsPage();
    }
}
