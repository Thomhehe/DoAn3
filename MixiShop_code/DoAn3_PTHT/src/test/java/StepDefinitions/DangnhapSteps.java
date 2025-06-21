package StepDefinitions;

import io.cucumber.java.en.And;
import pages.DangnhapPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;

import static org.junit.Assert.*;

public class DangnhapSteps extends BaseSteps {
    DangnhapPage dangnhapPage;
    @Given("Người dùng truy cập trang chủ MixiShop")
    public void ngườiDùngTruyCậpTrangChủMixiShop() {
        truycaptrangchu();
        dangnhapPage = new DangnhapPage(driver);
    }

    @When("Người dùng nhấn chọn đăng nhập")
    public void ngườiDùngNhấnChọnĐăngNhập() {
        dangnhapPage.clickmodangnhap();
    }

    @And("Người dùng nhập email {string} và password {string}")
    public void ngườiDùngNhậpEmailVàPassword(String email, String password) {
        dangnhapPage.enteremail(email);
        dangnhapPage.enterpassword(password);
    }

    @When("Người dùng nhấn nút đăng nhập")
    public void ngườiDùngNhấnNútĐăngNhập() throws InterruptedException {
        dangnhapPage.clickdangnhap();
        Thread.sleep(3000);
    }

    @Then("Kiểm tra kết quả đăng nhập {string}")
    public void kiểmTraKếtQuảĐăngNhập(String expected) {
        String actual = "";
//      Đăng nhập thành công
        if (expected.equalsIgnoreCase("TRANG TÀI KHOẢN")) {
            boolean url = driver.getCurrentUrl().equals("https://shop.mixigaming.com/account");

            WebElement title = driver.findElement(By.cssSelector("h5.title-account"));
            String pageTitle = title.getText().trim();
            assertTrue("Không đúng URL sau đăng nhập", url);
            assertTrue("Không tìm thấy dòng chữ 'TRANG TÀI KHOẢN'", pageTitle.equalsIgnoreCase(expected));
            return;
        }
        try {
            WebElement loginErrorMessage = driver.findElement(By.cssSelector("div.form-signup.margin-bottom-15"));
            if (loginErrorMessage.isDisplayed()) {
                actual = loginErrorMessage.getText().trim();
            }
        } catch (NoSuchElementException ignored) {
        }
        if (actual.isEmpty()) {
            String emailMessage = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", driver.findElement(By.name("email")));
            String passwordMessage = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", driver.findElement(By.name("password")));

            if (!emailMessage.isEmpty()) {
                actual = emailMessage;
            } else if (!passwordMessage.isEmpty()) {
                actual = passwordMessage;
            }
        }
        assertEquals(expected.trim(), actual.trim());
    }

}
