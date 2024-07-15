package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class MainPage extends BaseLibrary {
    @Step("Kabul Et Alanı Kontrolü")
    public MainPage KabulEtTikla() throws InterruptedException {
        sleep(4000);
        WebElement element = driver.findElement(By.id("onetrust-accept-btn-handler"));
        if (element.isDisplayed())
            driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        return this;
    }

    @Step("Arama İşlemi Sağlanır")
    public MainPage aramaDoldur(String text) {
        WebElement element = driver.findElement(By.cssSelector("[data-testid='suggestion']"));
        element.sendKeys(text, Keys.ENTER);
        return this;
    }

    @Step("Favoriler Alanına Tıklanır ")
    public MainPage clickFavorites()
    {
        WebElement element = driver.findElement(By.cssSelector("[class=\"account-nav-item account-favorites\"]"));
        element.click();
        return this;
    }
}