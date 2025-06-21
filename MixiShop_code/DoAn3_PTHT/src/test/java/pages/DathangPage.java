package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DathangPage {

    WebDriver driver;
    WebDriverWait wait;

    private By email = By.id("customer_email");
    private By password = By.id("customer_password");
    private By dangnhap = By.cssSelector(".btn.btn-block.btn-style.btn-login");

    private By muangay = By.cssSelector(".btn.btn_base.buynow ");
    private By thanhtoan = By.cssSelector(".btn.btn-block.btn-proceed-checkout-mobile");

    private By sdt = By.id("billing_address_phone");
    private By diachi = By.id("billing_address_address1");
    private By tinhthanh = By.id("customer_shipping_province");
    private By quanhuyen = By.id("customer_shipping_district");
    private By phuongxa = By.id("customer_shipping_ward");

    private By ttthanhtoan = By.cssSelector(".step-footer-continue-btn.btn");
    private By thongbaoloi = By.cssSelector("body > div:nth-child(7) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(5) > div:nth-child(3) > p:nth-child(2)");
//    private By thongbaodc = By.cssSelector("div[class='field field-required field-error '] p[class='field-message field-message-error']");

    private By hoantatdh = By.cssSelector("button.step-footer-continue-btn.btn");
    private By layphivanchuyen = By.xpath("//span[@class='order-summary-emphasis'][contains(text(),'30,000₫')]");
    private By laytongcong = By.cssSelector("span.payment-due-price");

    public DathangPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickmuangay() {
        wait.until(ExpectedConditions.elementToBeClickable(muangay)).click();
    }

    public void clickthanhtoan() {
        wait.until(ExpectedConditions.elementToBeClickable(thanhtoan)).click();
    }

    public void enteremail() {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys("phamhongthom249@gmail.com");
    }

    public void enterpasssword() {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys("Thom24924");
    }

    public void clickdangnhap() {
        driver.findElement(dangnhap).click();
    }

    public void entersdt(String Sdt){
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(sdt));
        input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        input.sendKeys(Keys.BACK_SPACE);
        input.sendKeys(String.valueOf(Sdt));
        input.sendKeys(Keys.ENTER);
    }

    public void enterdiachi(String Diachi) {
        WebElement dc = driver.findElement(diachi);
        dc.clear();
        dc.sendKeys(Diachi);
    }

    public void chontinhthanh(String Tinhthanh) {
        if (Tinhthanh.isEmpty()) {
            return;
        }
        WebElement dropdown = driver.findElement(tinhthanh);
        Select select = new Select(dropdown);
        select.selectByVisibleText(Tinhthanh);
    }

    public void chonquanhuyen(String Quanhuyen) {
        if (Quanhuyen.isEmpty()) {
            return;
        }
        wait.until(ExpectedConditions.textToBePresentInElementLocated(quanhuyen, Quanhuyen));
        Select select = new Select(driver.findElement(quanhuyen));
        select.selectByVisibleText(Quanhuyen);
    }

    public void chonphuongxa(String Phuongxa) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(phuongxa, Phuongxa));
        Select select = new Select(driver.findElement(phuongxa));
        select.selectByVisibleText(Phuongxa);
    }

    public void clickttthanhtoan() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(ttthanhtoan));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ block: 'center' });", button);
        button.click();
    }

    public String Thongbaoloi() {
        String thongbao = "";
        WebElement loiSdt = wait.until(ExpectedConditions.visibilityOfElementLocated(thongbaoloi));
        thongbao = loiSdt.getText().trim();
//        try {
//            // Kiểm tra lỗi số điện thoại
//            WebElement loiSdt = wait.until(ExpectedConditions.visibilityOfElementLocated(thongbaoloi));
//            thongbao = loiSdt.getText().trim();
//        } catch (NoSuchElementException e) {
//            // Nếu không tìm thấy lỗi số điện thoại, tiếp tục kiểm tra lỗi địa chỉ
//            try {
//                WebElement loiDc = wait.until(ExpectedConditions.visibilityOfElementLocated(thongbaodc));
//                thongbao = loiDc.getText().trim();
//            } catch (NoSuchElementException ex) {
//                // Nếu không có lỗi nào, trả về chuỗi rỗng hoặc thông báo mặc định
//                thongbao = "Không có lỗi";
//            }
//        }

        return thongbao;
    }

    public boolean kiemtrahoantatdh(String expectedText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hoantatdh));
        WebElement button = driver.findElement(hoantatdh);
        return button.isDisplayed() && button.getText().contains(expectedText);
    }

    public int phivanchuyen() {
        WebElement Phivanchuyen = wait.until(ExpectedConditions.visibilityOfElementLocated(layphivanchuyen));
        String phivanchuyentext = Phivanchuyen.getText().replaceAll("[^0-9]", "");
        if (phivanchuyentext.isEmpty()) return 0;
        return Integer.parseInt(phivanchuyentext);
    }

    public int tongcong() {
        WebElement Tongtien = wait.until(ExpectedConditions.visibilityOfElementLocated(laytongcong));
        String tongtientext = Tongtien.getText().replaceAll("[^0-9]", "");
        if (tongtientext.isEmpty()) return 0;
        return Integer.parseInt(tongtientext);
    }
}
