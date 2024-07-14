import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserTests {
    @Test
    public void  loginSuccess() throws InterruptedException {
        WebDriver driver    = new ChromeDriver();
        driver.get("https://www.trendyol.com/giris");
        driver.findElement(By.id("login-email")).sendKeys("sevdekulhan@gmail.com");
        driver.findElement(By.id("login-password-input")).sendKeys("12345678S.k");
        driver.findElement(By.xpath("//*[@id=\"login-register\"]/div[3]/div[1]/form/button")).click();
        Thread.sleep(5000);
        String value =driver.findElement(By.cssSelector("[class='link account-user'] p")).getText();
        System.out.println(value);
    }


    @Test
    public void  notValidLogin() throws InterruptedException {
        WebDriver driver    = new ChromeDriver();
        driver.get("https://www.trendyol.com/giris");
        driver.findElement(By.id("login-email")).sendKeys("sevdekulhan@gmail.com");
        driver.findElement(By.id("login-password-input")).sendKeys("11111111111111");
        driver.findElement(By.xpath("//*[@id=\"login-register\"]/div[3]/div[1]/form/button")).click();
        Thread.sleep(2000);
        String value = driver.findElement(By.cssSelector("[class='message']")).getText();
        Assert.assertEquals("E-posta adresiniz ve/veya şifreniz hatalı.",value);
    }

    @Test
    public void  notValidEmaillogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.trendyol.com/giris");
        driver.findElement(By.id("login-email")).sendKeys("sevdek@gmail.com");
        driver.findElement(By.id("login-password-input")).sendKeys("12345678S.k");
        driver.findElement(By.xpath("//*[@id=\"login-register\"]/div[3]/div[1]/form/button")).click();
        Thread.sleep(2000);
        String value = driver.findElement(By.cssSelector("[class='message']")).getText();
        Assert.assertEquals("E-posta adresiniz ve/veya şifreniz hatalı.", value);
    }

    @Test
    public void  requiredBlankControl() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.trendyol.com/giris");
        WebElement txtEmail=driver.findElement(By.id("login-email"));
        WebElement txtPassword =driver.findElement(By.id("login-password-input"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-register\"]/div[3]/div[1]/form/button"));

        txtEmail.sendKeys("");
        txtPassword.sendKeys("");
        loginButton.click();
        Thread.sleep(2000);
        String value = driver.findElement(By.cssSelector("[class='message']")).getText();
        Assert.assertEquals("Lütfen geçerli bir e-posta adresi giriniz.", value);
        txtEmail.sendKeys("sevdekulhan@gmail.com");
        loginButton.click();
        String value2 = driver.findElement(By.cssSelector("[class='message']")).getText();
        Assert.assertEquals("Lütfen şifrenizi giriniz.", value2);
        txtPassword.sendKeys("12345678S.k");
        loginButton.click();
        Thread.sleep(2000);
        String value3 =driver.findElement(By.cssSelector("[class='link account-user'] p")).getText();
        System.out.println(value3);
    }

    @Test
    public void  minControl() throws InterruptedException {
        WebDriver driver    = new ChromeDriver();
        driver.get("https://www.trendyol.com/giris");
        driver.findElement(By.id("login-email")).sendKeys("1");
        driver.findElement(By.id("login-password-input")).sendKeys("12");
        driver.findElement(By.xpath("//*[@id=\"login-register\"]/div[3]/div[1]/form/button")).click();
        Thread.sleep(2000);
        String value = driver.findElement(By.cssSelector("[class='message']")).getText();
        Assert.assertEquals("Lütfen geçerli bir e-posta adresi giriniz.", value);
        driver.findElement(By.id("login-email")).sendKeys("sevdekulhan@gmail.com");
        driver.findElement(By.id("login-password-input")).sendKeys("12");
        driver.findElement(By.xpath("//*[@id=\"login-register\"]/div[3]/div[1]/form/button")).click();
        Thread.sleep(2000);
        String value2 = driver.findElement(By.cssSelector("[class='message']")).getText();
        Assert.assertEquals("E-posta adresiniz ve/veya şifreniz hatalı.", value2);
    }

    @Test
    public void  maxControl() throws InterruptedException {
        WebDriver driver    = new ChromeDriver();
        driver.get("https://www.trendyol.com/giris");
        driver.findElement(By.id("login-email")).sendKeys("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        driver.findElement(By.id("login-password-input")).sendKeys("12111111111111111111111111111111111111111111");
        driver.findElement(By.xpath("//*[@id=\"login-register\"]/div[3]/div[1]/form/button")).click();
        Thread.sleep(2000);
        String value = driver.findElement(By.cssSelector("[class='message']")).getText();
        Assert.assertEquals("Lütfen geçerli bir e-posta adresi giriniz.", value);

        driver.findElement(By.id("login-email")).clear();
        driver.findElement(By.id("login-email")).sendKeys("sevdekulhan@gmail.com");
        driver.findElement(By.id("login-password-input")).clear();
        driver.findElement(By.id("login-password-input")).sendKeys("12345678S.k");
        driver.findElement(By.xpath("//*[@id=\"login-register\"]/div[3]/div[1]/form/button")).click();
        Thread.sleep(2000);
        String value3 =driver.findElement(By.cssSelector("[class='link account-user'] p")).getText();
        System.out.println(value3);
    }
}
