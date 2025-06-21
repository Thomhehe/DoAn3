Feature: Tìm kiếm sản phẩm trên website MixiShop
  Scenario Outline: Tìm kiếm với các từ khóa khác nhau
    Given Người dùng truy cập trang chủ website MixiShop tk
    When Người dùng nhấn vào biểu tượng tìm kiếm
    And Người dùng nhập từ khóa "<keyword>"
    And Người dùng nhấn nút xem thêm kết quả tìm kiếm
    Then Kiểm tra kết quả tìm kiếm "<expected>"

    Examples:
      | keyword | expected                                            |
      |          | Please fill out this field.                         |
      | ÁO       | CÓ 27 KẾT QUẢ TÌM KIẾM PHÙ HỢP                      |
      | áo 3 lỗ  | CÓ 7 KẾT QUẢ TÌM KIẾM PHÙ HỢP                       |
      | ao khoac | CÓ 2 KẾT QUẢ TÌM KIẾM PHÙ HỢP                       |
      | !$#      | CÓ 49 KẾT QUẢ TÌM KIẾM PHÙ HỢP                      |
      |     quần | CÓ 4 KẾT QUẢ TÌM KIẾM PHÙ HỢP                       |
      | a        | CÓ 27 KẾT QUẢ TÌM KIẾM PHÙ HỢP                      |
      | Áo phông | CÓ 8 KẾT QUẢ TÌM KIẾM PHÙ HỢP                       |