Feature: Đăng ký tài khoản mới trên Mixi Shop
  Scenario Outline: Đăng ký với các thông tin khác nhau
    Given Người dùng truy cập trang chủ MixiShop dk
    When Người dùng nhấn chọn đăng ký
    And Người dùng nhập họ "<lastname>", tên "<firstname>", số điện thoại "<phone>", email "<email>", mật khẩu "<password>"
    And Người dùng nhấn nút đăng ký
    Then Kiểm tra kết quả đăng ký "<expected>"

    Examples:
      | lastname | firstname | phone      | email               | password  | expected                    |
      | Phạm     | Thơm      | 0985829610 | phamhongthom249@gmail.com | thom12345 | Yêu cầu không hợp lệ, hoặc quá hạn, phiền bạn thử lại|
      | Phạm     | Thơm      | 0985829610 | pthom2345@gmail.com | thom      | Yêu cầu không hợp lệ, hoặc quá hạn, phiền bạn thử lại |
      | Phạm     | Thơm      | 0985829610 | pthom2345@gmail.com | thom12    | Yêu cầu không hợp lệ, hoặc quá hạn, phiền bạn thử lại |
      |          | Thơm      | 0985829610 | pthom2345@gmail.com | thom12345 | Please fill out this field. |
      | Phạm     |           | 0985829610 | pthom2345@gmail.com | thom12345 | Please fill out this field. |
      | Phạm     | Thơm      |            | pthom2345@gmail.com | thom12345 | Please fill out this field. |
      | Phạm     | Thơm      | 0985829610 |                     | thom12345 | Please fill out this field. |
      | Phạm     | Thơm      | 0985829610 | pthom2345           | thom12345 | Please include an '@' in the email address. 'pthom2345' is missing an '@'. |
      | Phạm     | Thơm      | 0985829610 | pthom2345@          | thom12345 | Please enter a part following '@'. 'pthom2345@' is incomplete. |
      | Phạm     | Thơm      | 0985829610 | pthom2345gmail.com  | thom12345 | Please include an '@' in the email address. 'pthom2345gmail.com' is missing an '@'. |
      | Phạm     | Thơm      | 0985829610 | pthom2345@gmail.    | thom12345 | '.' is used at a wrong position in 'gmail.'. |
      | Phạm     | Thơm      | 0985829610 | pthom2345@gmail.com |           | Please fill out this field. |
