package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductListPage extends BaseLibrary {

    @Step("Ürün Listesinden İlk Ürüne Tıkla")
    public ProductListPage clickFirstProduct() {
        WebElement element = driver.findElements(By.cssSelector("[class='p-card-wrppr with-campaign-view']")).get(0);
        element.click();
        return this;
    }
}