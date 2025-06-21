Feature: Đăng nhập vào hệ thống Mixi Shop
  Scenario Outline: Đăng nhập với các tài khoản khác nhau
    Given Người dùng truy cập trang chủ MixiShop
    When Người dùng nhấn chọn đăng nhập
    And Người dùng nhập email "<email>" và password "<password>"
    And Người dùng nhấn nút đăng nhập
    Then Kiểm tra kết quả đăng nhập "<expected>"

    Examples:
      | email                     | password  | expected                                                                                 |
      |                           | Thom24924 | Please fill out this field.                                                              |
      | phamhongthom249           | Thom24924 | Please include an '@' in the email address. 'phamhongthom249' is missing an '@'.         |
      | phamhongthom249@.com      | Thom24924 | '.' is used at a wrong position in '.com'.                                               |
      | phamhongthom249@gmail.    | Thom24924 | '.' is used at a wrong position in 'gmail.'.                                             |
      | phamhongthom249gmail.com  | Thom24924 | Please include an '@' in the email address. 'phamhongthom249gmail.com' is missing an '@'.|
      | phamhongthom249@          | Thom24924 | Please enter a part following '@'. 'phamhongthom249@' is incomplete.                     |
      | phamhongthom@gmail.com    | Thom24924 | Thông tin đăng nhập không hợp lệ.                                                        |
      | phamhongthom249@gmail.com |           | Please fill out this field.                                                              |
      | phamhongthom249@gmail.com | Thom24    | Thông tin đăng nhập không hợp lệ.                                                        |
      | phamhongthom@gmail.com    | Thom24    | Thông tin đăng nhập không hợp lệ.                                                        |
      | phamhongthom249@gmail.com | Thom24924 | TRANG TÀI KHOẢN                                                                          |