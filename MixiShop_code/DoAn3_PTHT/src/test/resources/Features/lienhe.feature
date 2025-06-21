Feature: Liên hệ
  Scenario: Gửi thông tin tới website
    Given Người dùng vào trang chủ của website MixiShop
    When Người dùng nhập họ tên "Thơm"
    And Người dùng nhập email "pthom2345gmail.com"
    And Người dùng nhập sdt "0985829610"
    And Người dùng nhập nội dung "thom"
    Then Kiểm tra thông báo gửi liên hệ thành công
