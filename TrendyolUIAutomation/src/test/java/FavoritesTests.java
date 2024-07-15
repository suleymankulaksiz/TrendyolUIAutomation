import Base.BaseTest;
import Pages.*;
import org.testng.annotations.Test;

public class FavoritesTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    ProductListPage productListPage = new ProductListPage();
    FavoritesPages favoritesPages = new FavoritesPages();

    @Test(description = "Favorilere Ürün Ekleme")
    public void AddFavoritesProduct() throws InterruptedException {
        loginPage
                .inputEmail(email)
                .inputPassword(password)
                .clickLogin();
        sleep(3000);
        mainPage.aramaDoldur("Laptop");
        productListPage.clickFirstProduct();
        switchTab();
        productDetailPage.addFavorites();
        String title = productDetailPage.getProductTitle();
        mainPage.clickFavorites();
        favoritesPages.productControl(title);
    }
}