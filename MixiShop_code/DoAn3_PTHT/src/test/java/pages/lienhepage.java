package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class lienhepage {
    WebDriver driver;
    WebDriverWait wait;
    private By lh = By.cssSelector("body > header:nth-child(6) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > nav:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)");
    private By hoten = By.name("contact[Name]");
    private By emaill = By.name("contact[email]");
    private By sdtt = By.name("contact[Phone]");
    private By noidung = By.name("contact[body]");
    private By gui = By.cssSelector("button[class='btn btn-main--primary btn-block btn-lienhe']");

    public lienhepage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clicklh() {
        wait.until(ExpectedConditions.elementToBeClickable(lh)).click();
    }

    public void nhapho(String ho) {
        WebElement keywordBox = wait.until(ExpectedConditions.visibilityOfElementLocated(hoten));
        keywordBox.clear();
        keywordBox.sendKeys(ho);
    }

    public void nhapemaill(String email) {
        WebElement keywordBox = wait.until(ExpectedConditions.visibilityOfElementLocated(emaill));
        keywordBox.clear();
        keywordBox.sendKeys(email);
    }

    public void nhapsdtd(String sdt) {
        WebElement keywordBox = wait.until(ExpectedConditions.visibilityOfElementLocated(sdtt));
        keywordBox.clear();
        keywordBox.sendKeys(sdt);
    }

    public void nhapnd(String nd) {
        WebElement keywordBox = wait.until(ExpectedConditions.visibilityOfElementLocated(noidung));
        keywordBox.clear();
        keywordBox.sendKeys(nd);
    }

    public void clickgui() {
        wait.until(ExpectedConditions.elementToBeClickable(gui)).click();
    }

    public boolean kiemtra() {
        wait.until(ExpectedConditions.urlToBe("https://shop.mixigaming.com/pages/lien-he"));
        return driver.getCurrentUrl().equals("https://shop.mixigaming.com/pages/lien-he");
    }
}
