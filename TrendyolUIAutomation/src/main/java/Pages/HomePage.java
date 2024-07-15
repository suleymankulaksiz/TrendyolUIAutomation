package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage extends BaseLibrary {
    @Step("Hesabım Alanı Görüntüleme Kontrolü")
    public HomePage controlMyAccount()
    {
        String value4 = driver.findElement(By.cssSelector("[class='link account-user'] p")).getText();
        screenshot();
        Assert.assertEquals("Hesabım", value4);
        return this;
    }
}