package pages;

import io.qameta.allure.Step;
import model.MainMenu;
import model.StaticPages;
import model.SubMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class AuthorizedPage extends BasePage  implements GenericStaticPage {

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


    @FindBy(css = "li.m-top-i")
    public List<WebElement> staticPagesItem;

    @FindBy(xpath = "//h1")
    public WebElement heder;


    public LoginPage callLoginPage() {
        click(btnLogin);
        return new LoginPage(driver);
    }

    @Step("Перевіряємо чи не залогінені")
    public void checkNotLogged (){
        Assert.assertEquals("войдите в личный кабинет", btnLogin.getText(), "Ви вже залогінені.");
    }

    @Step("Перевіряємо чи залогінені")
    public void checkLogged() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='popup-css popup-auth']")));
        Assert.assertTrue(btnProf.isDisplayed(), "Ви не залогінені");
    }

    public void openCatalogGoods(){
        moveTo(btnCatalogGoods);
    }

    public void openCategoryGoods(MainMenu menuToOpen){
        checkMenuItemPresent(mainMenuItems);
        for (WebElement item: mainMenuItems){
            if(item.getAttribute("id").equals(menuToOpen.getElementId())){
                moveTo(item);
                return;
            }
        }

    }

    public GoodsPage openSubcategoryGoods(SubMenu subMenuToOpen) {
        checkMenuItemPresent(subMenuItems);
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



    public GenericStaticPage openStaticPageFromTopMenu(StaticPages openStaticPageFromTopMenu) {
        for (WebElement item: staticPagesItem){
            if(item.getText().equals(openStaticPageFromTopMenu.getElementText())){
                click(item);
                return null;
            }
        }
        return null;
    }
    @Step("Перевіряємо чи та сторінка відкрита")
    @Override
    public void isPageOpened(String hederExpected) {
        try {
            Assert.assertEquals((heder.getText()), hederExpected,  "Сторінка не та, що очікувалась");
        }
        catch (NoSuchElementException e){
            return;
        }

    }

}
