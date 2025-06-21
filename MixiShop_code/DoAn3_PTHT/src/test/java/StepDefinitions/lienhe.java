package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.lienhepage;

import static org.junit.Assert.assertTrue;

public class lienhe extends BaseSteps {
    lienhepage LienhePage;
    WebDriverWait wait;
    @Given("Người dùng vào trang chủ của website MixiShop")
    public void ngườiDùngVàoTrangChủCủaWebsiteMixiShop() {
        truycaptrangchu();
        LienhePage = new lienhepage(driver);
        LienhePage.clicklh();
    }

    @When("Người dùng nhập họ tên {string}")
    public void ngườiDùngNhậpHọTên(String hoten) {
        LienhePage.nhapho(hoten);
    }

    @And("Người dùng nhập email {string}")
    public void ngườiDùngNhậpEmail(String email) {
        LienhePage.nhapemaill(email);
    }

    @And("Người dùng nhập sdt {string}")
    public void ngườiDùngNhậpSdt(String sdt) {
        LienhePage.nhapsdtd(sdt);
    }

    @And("Người dùng nhập nội dung {string}")
    public void ngườiDùngNhậpNộiDung(String noidung) {
        LienhePage.nhapnd(noidung);
        LienhePage.clickgui();
    }

    @Then("Kiểm tra thông báo gửi liên hệ thành công")
    public void kiểmTraThôngBáoGửiLiênHệThànhCông() {
        assertTrue("URL KHÔNG giữ nguyên sau khi gửi!", LienhePage.kiemtra());
    }
}
