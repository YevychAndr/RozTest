import org.testng.annotations.Test;
import pages.*;

public class TestRun extends BaseTest{
    @Test
    public void test() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.checkNotLogged();
        LoginPage loginPage = home.callLoginPage();
        loginPage.checkLoginPageOpen();
        AuthorizedPage authorizedPage = loginPage.login();
        authorizedPage.openCatalogGoods();
        authorizedPage.openCategoryGoods();
        GoodsPage goodsPage = authorizedPage.openSubcategoryGoods();
        AddedToCartPage addedToCartPage =  goodsPage.buyGood();
        addedToCartPage.continueShopping();
        authorizedPage.openCatalogGoods();
        authorizedPage.openCategoryGoods2();
        authorizedPage.openSubcategoryGoods2();
        goodsPage.buyGoods2();
        addedToCartPage.continueShopping();
        authorizedPage.openCatalogGoods();
        authorizedPage.openCategoryGoods3();
        authorizedPage.openSubcategoryGoods3();
        goodsPage.buyGoods3();
        addedToCartPage.continueShopping();
        CartPage cartPage = authorizedPage.goCart();
        cartPage.checkSumCart();
        cartPage.dellAllGoods();
        cartPage.checkCartEmpty();
        QuestionAnswerPage questionAnswerPage = authorizedPage.callQuestionAnswer();
        CreditPage creditPage = authorizedPage.callCreditPage();
        ShippingPaymenPage shippingPaymenPage = authorizedPage.callShippingPaymen();
        GuaranteePage guaranteePage = authorizedPage.callGuaranteePage();
        ContactsPage contactsPage = authorizedPage.callContactsPage();
    }

}
