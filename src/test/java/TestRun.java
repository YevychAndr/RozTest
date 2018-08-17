import model.MainMenu;
import model.StaticPages;
import model.SubMenu;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class TestRun extends BaseTest{

    @DataProvider(name = "loginData")
    public Object[][] getData(){
        return new String[][]{
                {"yevych.a@ya.ru", "Vvs1983"}

                };
    }

    @Test(dataProvider = "loginData")
    public void test(String login, String password)  {
        AuthorizedPage authorizedPage = new AuthorizedPage(driver);
        authorizedPage.checkNotLogged();
        LoginPage loginPage = authorizedPage.callLoginPage();
        loginPage.login(login, password);
        authorizedPage.checkLogged();

        authorizedPage.openCatalogGoods();
        authorizedPage.openCategoryGoods(MainMenu.SPORT);
        GoodsPage goodsPage = authorizedPage.openSubcategoryGoods(SubMenu.COIL);

        AddedToCartPage addedToCartPage = goodsPage.buyGoods();
        addedToCartPage.continueShopping();
        authorizedPage.openCatalogGoods();
        authorizedPage.openCategoryGoods(MainMenu.COTTAGE);
        authorizedPage.openSubcategoryGoods(SubMenu.WHEELBARROW);
        goodsPage.buyGoods();
        addedToCartPage.continueShopping();
        authorizedPage.openCatalogGoods();
        authorizedPage.openCategoryGoods(MainMenu.BABYGOODS);
        authorizedPage.openSubcategoryGoods(SubMenu.BABYRADIO);
        goodsPage.buyGoods();
        addedToCartPage.continueShopping();

        CartPage cartPage = authorizedPage.goCart();
        cartPage.checkSumCart();
        cartPage.dellAllGoods();

        cartPage.checkCartEmpty();

        GenericStaticPage questionAnswerPage = authorizedPage.openStaticPageFromTopMenu(StaticPages.QUESTIONANSWER);
        authorizedPage.isPageOpened(QuestionAnswerPage.hederExpected);
        GenericStaticPage creditPage = authorizedPage.openStaticPageFromTopMenu(StaticPages.CREDIT);
        GenericStaticPage shippingPaymenPage = authorizedPage.openStaticPageFromTopMenu(StaticPages.SHIPPINGPAYMENT);
        GenericStaticPage warrantyPage = authorizedPage.openStaticPageFromTopMenu(StaticPages.WARRANTY);
        GenericStaticPage contactsPage = authorizedPage.openStaticPageFromTopMenu(StaticPages.CONTACTS);


    }

}
