package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DangkyPage {

    WebDriver driver;

    private By icondangky = By.cssSelector("div[class='header-wrap container'] div[id='icon-account'] svg");
    private By dangky = By.cssSelector("div[class='header-wrap container'] a[title='Đăng ký']");
    private By ho = By.id("lastName");
    private By ten = By.id("firstName");
    private By sdt = By.id("Phone");
    private By email = By.id("email");
    private By matkhau = By.id("password");
    private By dangkybutton = By.cssSelector(".btn.btn-style.btn_register.btn-block");

    public DangkyPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickmodangky() {
        Actions actions = new Actions(driver);
        WebElement icon = driver.findElement(icondangky);
        actions.moveToElement(icon).perform();

        WebElement Dangky = driver.findElement(dangky);
        Dangky.click();
    }
    public void enterho(String Lname) {
        driver.findElement(ho).clear();
        driver.findElement(ho).sendKeys(Lname);
    }

    public void enterten(String Fname) {
        driver.findElement(ten).clear();
        driver.findElement(ten).sendKeys(Fname);
    }

    public void entersdt(String Sdt) {
        driver.findElement(sdt).clear();
        driver.findElement(sdt).sendKeys(Sdt);
    }

    public void enteremail(String Email) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(Email);
    }

    public void enterpassword(String Password) {
        driver.findElement(matkhau).clear();
        driver.findElement(matkhau).sendKeys(Password);
    }

    public void clickdangky() {
        driver.findElement(dangkybutton).click();
    }
}
