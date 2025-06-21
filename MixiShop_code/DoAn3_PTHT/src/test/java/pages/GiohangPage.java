package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GiohangPage {

    WebDriver driver;
    WebDriverWait wait;

    private By chonsanpham = By.xpath("(//a[@title='Áo khoác nỉ'][contains(text(),'Áo khoác nỉ')])[1]");
    private By themsp = By.cssSelector("div.button_actions.mb-0");
    private By xemgiohang = By.cssSelector("a.checkout_button.btn-full");
    private By icongiohang = By.cssSelector("div.mini-cart.text-xs-center");

    private By laysoluong = By.cssSelector("input[id^='qtyMobile']");
    private By laygiasp = By.cssSelector("span.special-price");
    private By laythanhtien = By.cssSelector(".cart-price .product-price.price");
    private By laytongtien = By.cssSelector(".text-xs-right.totals_price_mobile");

    private By nhapsoluong = By.id("qtym");
    private By capnhatsl = By.xpath("//input[contains(@class, 'qtyMobile') and @name='updates[]']");
    private By tangsoluong = By.cssSelector("button[class='increase items-count btn-plus btn']");
    private By giamsoluong = By.cssSelector("button[class='reduced items-count btn-minus btn']");

    private By xoaspbtn = By.cssSelector("a.remove-itemx.remove-item-cart");
    private By giohangtrong = By.cssSelector("div[class='title-cart text-center'] h3");

    public GiohangPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickchonsanpham() {
        wait.until(ExpectedConditions.elementToBeClickable(chonsanpham)).click();
    }

    public void clickthemsp() {
        wait.until(ExpectedConditions.elementToBeClickable(themsp)).click();
    }

    public void clickxemgiohang() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(xemgiohang)).click();
            wait.until(ExpectedConditions.elementToBeClickable(xemgiohang)).click();
        } catch (TimeoutException e) {
            wait.until(ExpectedConditions.elementToBeClickable(icongiohang)).click();
        }
    }

    public int soluongsanphamtronggio() {
        WebElement soLuongInput = wait.until(ExpectedConditions.visibilityOfElementLocated(laysoluong));
        String soLuongStr = soLuongInput.getAttribute("value").trim();  // Lấy từ thuộc tính value
        return Integer.parseInt(soLuongStr);
    }

    public int giasanpham() {
        WebElement giaElement = wait.until(ExpectedConditions.visibilityOfElementLocated(laygiasp));
        String giaText = giaElement.getText().replaceAll("[^0-9]", "");
        if (giaText.isEmpty()) return 0;
        return Integer.parseInt(giaText);
    }

    public int thanhtiensanpham() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(laythanhtien));
        String giaText = element.getText().replaceAll("[^0-9]", "");
        if (giaText.isEmpty()) return 0;
        return Integer.parseInt(giaText);
    }

    public int tongtien() {
        WebElement Tongtien = wait.until(ExpectedConditions.visibilityOfElementLocated(laytongtien));
        String tongTienText = Tongtien.getText().replaceAll("[^0-9]", "");
        if (tongTienText.isEmpty()) return 0;
        return Integer.parseInt(tongTienText);
    }

    public void entersoluong(int Soluong) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(nhapsoluong));
        input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        input.sendKeys(Keys.BACK_SPACE);
        input.sendKeys(String.valueOf(Soluong));
        input.sendKeys(Keys.ENTER);
    }

//    //    Cảnh báo lỗi là một Alert box (JavaScript alert) của trình duyệt
//    public String thongbaoloi() {
//        try {
//            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//            String alertText = alert.getText();
//            System.out.println("Thông báo alert: " + alertText);
//            alert.accept();
//            return alertText;
//        } catch (Exception e) {
//            // Không có alert thì trả về chuỗi rỗng hoặc thông báo tùy bạn
//            return "";
//        }
//    }

    public void entercapnhatsoluong(int Soluong) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(capnhatsl));
        input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        input.sendKeys(Keys.BACK_SPACE);
        input.sendKeys(String.valueOf(Soluong));
        input.sendKeys(Keys.ENTER);
    }

    public void clicktangsoluong() {
        wait.until(ExpectedConditions.elementToBeClickable(tangsoluong)).click();
    }

    public void clickgiamsoluong() {
        wait.until(ExpectedConditions.elementToBeClickable(giamsoluong)).click();
    }

    public void clickxoasp() {
        wait.until(ExpectedConditions.elementToBeClickable(xoaspbtn)).click();
    }

    public boolean kiemtragiohangtrong(String expectedText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(giohangtrong));
        WebElement text = driver.findElement(giohangtrong);
        return text.isDisplayed() && text.getText().contains(expectedText);
    }
}
