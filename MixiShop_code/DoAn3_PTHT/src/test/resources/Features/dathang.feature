Feature: Đặt hàng trên website MixiShop
  Scenario Outline: Nhập địa chỉ giao hàng và tiếp tục đến phương thức thanh toán
    Given Người dùng truy cập trang chủ MixiShop dh
    When Người dùng nhấn chọn phẩm trên website
    And Người dùng nhấn nút mua ngay
    And Người dùng nhấn nút thanh toán
    And Người dùng đăng nhập vào tài khoản
    And Người dùng nhập số điện thoại "<sdt>"
    And Người dùng nhập địa chỉ giao hàng "<dia chi>"
    And Người dùng chọn tỉnh thành "<tinh thanh>"
    And Người dùng chọn quận huyện "<quan huyen>"
    And Người dùng chọn phường xã "<phuong xa>"
    And Người dùng nhấn nút tiếp tục thanh toán
    Then Kiểm tra thông báo lỗi "<expected>"
    And Kiểm tra "Hoàn tất đơn hàng"
    And Kiểm tra tổng cộng bằng tổng tiền trong giỏ cộng với phí vận chuyển

    Examples:
      | sdt        | dia chi | tinh thanh   | quan huyen   | phuong xa    | expected |
      |            | Lạc Cầu | Hưng Yên     | Huyện Yên Mỹ | Xã Giai Phạm | Số điện thoại không được trống |
      | 09873      | Lạc Cầu | Hưng Yên     | Huyện Yên Mỹ | Xã Giai Phạm | Số điện thoại không hợp lệ (độ dài từ 8 - 15 ký tự, không chứa ký tự đặc biệt và khoảng trắng) |
      | 09wegf     | Lạc Cầu | Hưng Yên     | Huyện Yên Mỹ | Xã Giai Phạm | Số điện thoại không hợp lệ (độ dài từ 8 - 15 ký tự, không chứa ký tự đặc biệt và khoảng trắng) |
      | 0985829610 | Lạc Cầu | Hưng Yên     | Huyện Yên Mỹ | Xã Giai Phạm |                          |