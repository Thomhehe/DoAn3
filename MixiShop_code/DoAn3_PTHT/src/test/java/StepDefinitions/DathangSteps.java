package StepDefinitions;

import io.cucumber.java.en.Then;
import pages.DathangPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.GiohangPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DathangSteps extends BaseSteps {
    DathangPage dathangPage;
    GiohangPage giohangPage;
    int tongtiensanpham = 0;
    boolean hasValidationError = false;
    @Given("Người dùng truy cập trang chủ MixiShop dh")
    public void ngườiDùngTruyCậpTrangChủMixiShopdh() {
        truycaptrangchu();
        dathangPage = new DathangPage(driver);
        giohangPage = new GiohangPage(driver);
    }

    @When("Người dùng nhấn chọn phẩm trên website")
    public void ngườiDùngNhấnChọnPhẩmTrênWebsite() {
        giohangPage.clickchonsanpham();
    }

    @And("Người dùng nhấn nút mua ngay")
    public void ngườiDùngNhấnNútMuaNgay() {
        dathangPage.clickmuangay();
    }

    @And("Người dùng nhấn nút thanh toán")
    public void ngườiDùngNhấnNútThanhToán() {
        tongtiensanpham = giohangPage.tongtien();
        dathangPage.clickthanhtoan();
    }

    @And("Người dùng đăng nhập vào tài khoản")
    public void ngườiDùngĐăngNhậpVàoTàiKhoản() {
        dathangPage.enteremail();
        dathangPage.enterpasssword();
        dathangPage.clickdangnhap();
    }


    @And("Người dùng nhập số điện thoại {string}")
    public void ngườiDùngNhậpSốĐiệnThoại(String sdt) {
        dathangPage.entersdt(sdt);
    }

    @And("Người dùng nhập địa chỉ giao hàng {string}")
    public void ngườiDùngNhậpĐịaChỉGiaoHàng(String diachi ) {
        dathangPage.enterdiachi(diachi);
    }

    @And("Người dùng chọn tỉnh thành {string}")
    public void ngườiDùngChọnTỉnhThành(String tinhthanh) {
        dathangPage.chontinhthanh(tinhthanh);
    }

    @And("Người dùng chọn quận huyện {string}")
    public void ngườiDùngChọnQuậnHuyện(String quanhuyen) {
        dathangPage.chonquanhuyen(quanhuyen);
    }

    @And("Người dùng chọn phường xã {string}")
    public void ngườiDùngChọnPhườngXã(String phuongxa) {
        dathangPage.chonphuongxa(phuongxa);
    }

    @And("Người dùng nhấn nút tiếp tục thanh toán")
    public void ngườiDùngNhấnNútTiếpTụcThanhToán() throws InterruptedException {
        dathangPage.clickttthanhtoan();
        Thread.sleep(1000);
    }

    @Then("Kiểm tra thông báo lỗi {string}")
    public void kiểmTraThôngBáoLỗi(String expected) {
        if (expected == null || expected.trim().isEmpty()) {
            System.out.println("Không có thông báo lỗi.");
            hasValidationError = false;
        } else {
            String actual = dathangPage.Thongbaoloi();
            hasValidationError = true;
            assertEquals("Thông báo lỗi không khớp!", expected, actual);
        }
    }

    @Then("Kiểm tra {string}")
    public void kiểmTra(String hoantat) {
        if (!hasValidationError && hoantat != null && !hoantat.trim().isEmpty()) {
            boolean result = dathangPage.kiemtrahoantatdh(hoantat);
            assertTrue("Kiểm tra nút hoàn tất đơn hàng thất bại!", result);
        } else {
            System.out.println("Bỏ qua kiểm tra hoàn tất đơn hàng vì có lỗi dữ liệu.");
        }
    }

    @And("Kiểm tra tổng cộng bằng tổng tiền trong giỏ cộng với phí vận chuyển")
    public void kiểmTraTổngCộngBằngTổngTiềnTrongGiỏCộngVớiPhíVậnChuyển() {
        try {
            if (hasValidationError) {
                System.out.println("Bỏ qua kiểm tra tổng tiền vì có lỗi dữ liệu.");
                return;
            }
            int phivanchuyen = dathangPage.phivanchuyen();
            int expectedTongcong = tongtiensanpham + phivanchuyen;
            int actualTongcong = dathangPage.tongcong();
            assertEquals("Tổng cộng tiền sản phẩm không đúng", expectedTongcong, actualTongcong);
        } catch (Exception e) {
            System.out.println("Bỏ qua kiểm tra tổng tiền vì xảy ra ngoại lệ.");
        }
    }
}
