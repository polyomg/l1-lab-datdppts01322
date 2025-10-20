package poly.edu.service;

import java.util.Collection;
import poly.edu.model.Item;

/**
 * Interface mô tả các hành vi của giỏ hàng
 */
public interface ShoppingCartService {

    /**
     * Thêm mặt hàng vào giỏ hoặc tăng số lượng lên 1 nếu đã tồn tại
     * @param id mã mặt hàng cần thêm
     * @return mặt hàng đã được thêm hoặc cập nhật
     */
    Item add(Integer id);

    /**
     * Xóa mặt hàng khỏi giỏ
     * @param id mã mặt hàng cần xóa
     */
    void remove(Integer id);

    /**
     * Thay đổi số lượng của mặt hàng trong giỏ
     * @param id mã mặt hàng
     * @param qty số lượng mới
     * @return mặt hàng đã được thay đổi số lượng
     */
    Item update(Integer id, int qty);

    /**
     * Xóa sạch các mặt hàng trong giỏ
     */
    void clear();

    /**
     * Lấy tất cả các mặt hàng trong giỏ
     * @return danh sách các mặt hàng
     */
    Collection<Item> getItems();

    /**
     * Lấy tổng số lượng mặt hàng trong giỏ
     * @return tổng số lượng
     */
    int getCount();

    /**
     * Lấy tổng số tiền tất cả các mặt hàng trong giỏ
     * @return tổng thành tiền
     */
    double getAmount();
}
