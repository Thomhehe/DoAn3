package StepDefinitions;

import pages.TimkiemPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class TimkiemSteps extends BaseSteps {
    TimkiemPage timkiemPage;
    private String keyword;
    @Given("Người dùng truy cập trang chủ website MixiShop tk")
    public void ngườiDùngTruyCậpTrangChủWebsiteMixiShopTk() {
        truycaptrangchu();
        timkiemPage = new TimkiemPage(driver);
    }

    @When("Người dùng nhấn vào biểu tượng tìm kiếm")
    public void ngườiDùngNhấnVàoBiểuTượngTìmKiếm() {
        timkiemPage.clicktimkiem();
    }

    @And("Người dùng nhập từ khóa {string}")
    public void ngườiDùngNhậpTừKhóa(String keyword) {
        this.keyword = keyword;
        timkiemPage.enterkeywords(keyword);
    }

    @And("Người dùng nhấn nút xem thêm kết quả tìm kiếm")
    public void ngườiDùngNhấnNútEnterĐểTìmKiếm() throws InterruptedException {
        timkiemPage.clickxemkq();
        Thread.sleep(1000);
    }

    @Then("Kiểm tra kết quả tìm kiếm {string}")
    public void kiểmTraKếtQuảTìmKiếm(String expected) {
        String actual;
        if (this.keyword == null || this.keyword.trim().isEmpty()) {
            actual = timkiemPage.kiemtratrong();
        } else {
            actual = timkiemPage.kiemtrakqtk();
        }
        assertTrue("Kết quả thực tế: " + actual + " không chứa: " + expected, actual.contains(expected));
    }

}
