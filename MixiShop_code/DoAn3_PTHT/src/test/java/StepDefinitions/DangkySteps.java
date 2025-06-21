package StepDefinitions;

import pages.DangkyPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;

import static org.junit.Assert.assertEquals;

public class DangkySteps extends BaseSteps {
    DangkyPage dangkyPage;
    @Given("Người dùng truy cập trang chủ MixiShop dk")
    public void nguoidungtruycaptrangchumixishopdk() {
        truycaptrangchu();
        dangkyPage = new DangkyPage(driver);
    }

    @When("Người dùng nhấn chọn đăng ký")
    public void ngườiDùngNhấnChọnĐăngKý() {
        dangkyPage.clickmodangky();
    }

    @And("Người dùng nhập họ {string}, tên {string}, số điện thoại {string}, email {string}, mật khẩu {string}")
    public void nguoidungnhaphotensdtemailmk(String lastName, String firstName, String Phone, String email, String password) {
        dangkyPage.enterho(lastName);
        dangkyPage.enterten(firstName);
        dangkyPage.entersdt(Phone);
        dangkyPage.enteremail(email);
        dangkyPage.enterpassword(password);

    }

    @And("Người dùng nhấn nút đăng ký")
    public void nguoidungnhannutdangky() throws InterruptedException {
        dangkyPage.clickdangky();
        Thread.sleep(3000);
    }

    @Then("Kiểm tra kết quả đăng ký {string}")
    public void kiemtraketquadangky(String expected) {
        String actual = "";
        try {
            WebElement loginErrorMessage = driver.findElement(By.cssSelector(".form-signup"));
            if (loginErrorMessage.isDisplayed()) {
                actual = loginErrorMessage.getText().trim();
            }
        } catch (NoSuchElementException ignored) {}

        if (actual.isEmpty()) {
            String[] fieldIds = {"lastName", "firstName", "Phone", "email", "password"};
            for (String id : fieldIds) {
                try {
                    WebElement element = driver.findElement(By.id(id));
                    String message = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", element);

                    if (message != null && !message.isEmpty()) {
                        actual = message;
                        break; // dừng ngay khi có lỗi đầu tiên
                    }
                } catch (NoSuchElementException ignored) {
                }
            }
        }
        assertEquals(expected.trim(), actual.trim());
    }

}
