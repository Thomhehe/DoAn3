package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DangnhapPage {

    WebDriver driver;

    private By icondangnhap = By.cssSelector("div[class='header-wrap container'] div[id='icon-account'] svg");
    private By dangnhap = By.cssSelector("div[class='header-wrap container'] a[title='Đăng nhập']");
    private By email = By.id("customer_email");
    private By password = By.id("customer_password");
    private By dangnhapbutton = By.cssSelector(".btn.btn-block.btn-style.btn-login");

    public DangnhapPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickmodangnhap() {
        Actions actions = new Actions(driver);
        WebElement icon = driver.findElement(icondangnhap);
        actions.moveToElement(icon).perform();

        WebElement Dangnhap = driver.findElement(dangnhap);
        Dangnhap.click();
    }

    public void enteremail(String Email) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(Email);
    }

    public void enterpassword(String Password) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(Password);
    }

    public void clickdangnhap() {
        driver.findElement(dangnhapbutton).click();
    }
}
