import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class UserTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test(description = "Başarılı Login Kullanıcı Giriş Kontrol")
    @Severity(SeverityLevel.CRITICAL)
    public void loginSuccesful() throws InterruptedException {
        loginPage
                .inputEmail(email)
                .inputPassword(password)
                .clickLogin();

        sleep(5000);
        homePage.controlMyAccount();
    }

    @Test(description = "Hatalı Login Kullanıcı Giriş Kontrol")
    public void notValidLogin() throws InterruptedException {
        loginPage
                .inputEmail(email)
                .inputPassword("aaaaaaaaa")
                .clickLogin();

        sleep(3000);
        loginPage.errorMessageControl(errorMessage);
    }

    @Test(description = "Sistemde Kayıtlı Olmayan Email Kullanıcı Girişi")
    public void notValidWithEmail() throws InterruptedException {
        loginPage
                .inputEmail("aaaaaaaaaaa@mail.com")
                .inputPassword(password)
                .clickLogin();
        sleep(3000);
        loginPage.errorMessageControl(errorMessage);
    }

    @Test(description = "Bos Karakter Kontrolu")
    public void requiredBlankControl() throws InterruptedException {
        loginPage.inputEmail("")
                .inputPassword("")
                .clickLogin();
        sleep(3000);
        loginPage.errorMessageControl(errorMessage2);
        loginPage.inputEmail(email)
                .clickLogin();
        sleep(3000);
        loginPage
                .errorMessageControl("Lütfen şifrenizi giriniz.")
                .inputPassword(password)
                .clickLogin();
        sleep(3000);
        homePage.controlMyAccount();
    }

    @Test(description = "Minumum Karakter Kontrolü")
    public void minCharacterControl() throws InterruptedException {
        loginPage.inputEmail("1")
                .inputPassword("2")
                .clickLogin();
        sleep(3000);
        loginPage.errorMessageControl(errorMessage2);
        loginPage.inputEmail(email)
                .inputPassword("2")
                .clickLogin();
        sleep(3000);
        ;
        loginPage.errorMessageControl(errorMessage);
    }

    @Test(description = "Maximum Karakter Kontrolü")
    public void maxCharacterControl() throws InterruptedException {
        loginPage.inputEmail("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111")
                .inputPassword(password);
        sleep(3000);
        loginPage.clickLogin();
        Thread.sleep(3000);
        loginPage.errorMessageControl(errorMessage2);
        sleep(3000);
        loginPage.emailInputClear()
                .passwordInputClear()
                .inputEmail(email)
                .clickLogin();
        sleep(3000);
        homePage.controlMyAccount();
    }
}