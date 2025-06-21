package StepDefinitions;

import io.cucumber.java.After;
import pages.GiohangPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GiohangSteps extends BaseSteps{
    GiohangPage giohangPage;
    int giasanphamgoc = 0;

    @Given("Người dùng truy cập vào trang chủ")
    public void ngườiDùngTruyCậpVàoTrangChủ() {
        truycaptrangchu();
        giohangPage = new GiohangPage(driver);
    }

    @When("Người dùng nhấn chọn sản phẩm")
    public void ngườiDùngNhấnChọnSảnPhẩm() {
        giohangPage.clickchonsanpham();
        giasanphamgoc = giohangPage.giasanpham();
    }

    @And("Người dùng thêm sản phẩm vào giỏ hàng")
    public void ngườiDùngThêmSảnPhẩmVàoGiỏHàng() {
        giohangPage.clickthemsp();
    }

    @And("Người dùng nhấn xem giỏ hàng")
    public void ngườiDùngNhấnXemGiỏHàng() {
        giohangPage.clickxemgiohang();
    }

    @And("Người dùng nhấn thêm vào giỏ hàng hai lần")
    public void ngườiDùngNhấnThêmVàoGiỏHàngHaiLần() {
        giohangPage.clickthemsp();
        giohangPage.clickthemsp();
    }


    @Then("Kiểm tra sản phẩm trong giỏ hàng với số lượng {int}")
    public void kiểmTraSảnPhẩmTrongGiỏHàngVớiSốLương(int expectedQuantity) {
        assertTrue(driver.getPageSource().contains("Áo khoác nỉ"));
        int actualQuantity = giohangPage.soluongsanphamtronggio();
        assertEquals(expectedQuantity, actualQuantity);
    }

    @And("Kiểm tra thành tiền của sản phẩm bằng giá sản phẩm nhân với số lượng")
    public void kiểmTraThànhTiềnCủaSảnPhẩmBằngGiáSảnPhẩmNhânVớiSốLượng() {
        int soluong = giohangPage.soluongsanphamtronggio();
        int expectedThanhTien = giasanphamgoc * soluong;
        int actualThanhTien = giohangPage.thanhtiensanpham();
        assertEquals("Thành tiền sản phẩm không đúng", expectedThanhTien, actualThanhTien);
    }

    @And("Kiểm tra tổng tiền của giỏ hàng bằng tổng thành tiền của tất cả sản phẩm")
    public void kiểmTraTổngTiềnCủaGiỏHàngBằngTổngThànhTiềnCủaTấtCảSảnPhẩm() {
        int expectedTongTien = giohangPage.thanhtiensanpham();
        int actualTongTien = giohangPage.tongtien();
        assertEquals("Tổng tiền giỏ hàng không đúng", expectedTongTien, actualTongTien);
    }

    @When("Người dùng nhập số lượng sản phẩm là {int}")
    public void ngườiDùngNhậpSốLượngSảnPhẩmLà(int Soluong) {
        giohangPage.entersoluong(Soluong);
    }

//    @Then("Kiểm tra thông báo lỗi số lượng {string}")
//    public void kiểmTraThôngBáoLỗiSốLượng(String expectedMessage) {
//        String actualMessage = giohangPage.thongbaoloi();
//        assertTrue("Không thấy alert hoặc alert sai", actualMessage != null && actualMessage.contains(expectedMessage));
//    }

    @And("Người dùng cập nhật số lượng sản phẩm là {int} và nhấn enter")
    public void ngườiDùngCậpNhậtSốLượngSảnPhẩmLàVàNhấnEnter(int Soluong) throws InterruptedException {
        giohangPage.entercapnhatsoluong(Soluong);
        Thread.sleep(1000);
    }

    @Then("Kiểm tra tổng tiền hàng cập nhật về {int}")
    public void kiểmTraTổngTiềnHàngCậpNhậtVề(int Tongtien) {
        int actualTongTien = giohangPage.tongtien();
        assertEquals(Tongtien, actualTongTien);
    }

    @And("Người dùng nhấn dấu cộng để tăng số lượng sản phẩm")
    public void ngườiDùngNhấnDấuCộngĐểTăngSốLượngSảnPhẩm() throws InterruptedException {
        giohangPage.clicktangsoluong();
        Thread.sleep(2000);
    }

    @When("Người dùng nhấn dấu trừ để giảm số lượng sản phẩm")
    public void ngườiDùngNhấnDấuTrừĐểGiảmSốLượngSảnPhẩm() throws InterruptedException {
        giohangPage.clickgiamsoluong();
        Thread.sleep(2000);
    }

    @And("Người dùng xóa sản phẩm có trong giỏ hàng")
    public void ngườiDùngXóaSảnPhẩmCóTrongGiỏHàng() {
        giohangPage.clickxoasp();
    }

    @Then("Kiểm tra hiển thị {string}")
    public void kiểmTraHiểnThị(String Giohangtrong) {
        boolean result = giohangPage.kiemtragiohangtrong(Giohangtrong);
        assertTrue("Không thấy thông báo “Hổng” có gì trong giỏ hết", result);
    }

}
