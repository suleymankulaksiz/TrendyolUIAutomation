package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductDetailPage extends BaseLibrary {

    @Step("Favorilere Ekle Butonu Tıklanır")
    public ProductDetailPage addFavorites()
    {
        WebElement element = driver.findElement(By.cssSelector("[class='fv']"));
        element.click();
        return this;
    }

    @Step("Ürün Başlığı Getir")
    public String getProductTitle()
    {
        WebElement element = driver.findElements(By.cssSelector("[class='pr-in-cn'] span")).get(0);
        String text = element.getText();
        return text;
    }

}