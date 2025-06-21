Feature: Quản lý giỏ hàng

  Background:
    Given Người dùng truy cập vào trang chủ
    When Người dùng nhấn chọn sản phẩm

  Scenario: Thêm một sản phẩm vào giỏ hàng
    And Người dùng thêm sản phẩm vào giỏ hàng
    And Người dùng nhấn xem giỏ hàng
    Then Kiểm tra sản phẩm trong giỏ hàng với số lượng 1
    And Kiểm tra thành tiền của sản phẩm bằng giá sản phẩm nhân với số lượng
    And Kiểm tra tổng tiền của giỏ hàng bằng tổng thành tiền của tất cả sản phẩm

  Scenario: Thêm một sản phẩm nhiều lần vào giỏ hàng
    And Người dùng nhấn thêm vào giỏ hàng hai lần
    And Người dùng nhấn xem giỏ hàng
    Then Kiểm tra sản phẩm trong giỏ hàng với số lượng 2
    And Kiểm tra thành tiền của sản phẩm bằng giá sản phẩm nhân với số lượng
    And Kiểm tra tổng tiền của giỏ hàng bằng tổng thành tiền của tất cả sản phẩm

  Scenario: Cập nhật số lượng sản phẩm trong giỏ hàng về 0
    And Người dùng thêm sản phẩm vào giỏ hàng
    And Người dùng nhấn xem giỏ hàng
    And Người dùng cập nhật số lượng sản phẩm là 0 và nhấn enter
    Then Kiểm tra sản phẩm trong giỏ hàng với số lượng 0
    And Kiểm tra thành tiền của sản phẩm bằng giá sản phẩm nhân với số lượng
    And Kiểm tra tổng tiền của giỏ hàng bằng tổng thành tiền của tất cả sản phẩm

  Scenario: Cập nhật số lượng sản phẩm trong giỏ bằng bằng nút tăng giảm
    And Người dùng thêm sản phẩm vào giỏ hàng
    And Người dùng nhấn xem giỏ hàng
    And Người dùng nhấn dấu cộng để tăng số lượng sản phẩm
    Then Kiểm tra sản phẩm trong giỏ hàng với số lượng 2
    And Kiểm tra thành tiền của sản phẩm bằng giá sản phẩm nhân với số lượng
    And Kiểm tra tổng tiền của giỏ hàng bằng tổng thành tiền của tất cả sản phẩm
    When Người dùng nhấn dấu trừ để giảm số lượng sản phẩm
    Then Kiểm tra sản phẩm trong giỏ hàng với số lượng 1
    And Kiểm tra thành tiền của sản phẩm bằng giá sản phẩm nhân với số lượng
    And Kiểm tra tổng tiền của giỏ hàng bằng tổng thành tiền của tất cả sản phẩm

  Scenario: Xóa sản phẩm trong giỏ hàng
    And Người dùng thêm sản phẩm vào giỏ hàng
    And Người dùng nhấn xem giỏ hàng
    And Người dùng xóa sản phẩm có trong giỏ hàng
    Then Kiểm tra hiển thị "“Hổng” có gì trong giỏ hết"
