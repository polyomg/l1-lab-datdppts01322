package poly.edu.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import poly.edu.model.DB;
import poly.edu.model.Item;
import java.util.*;

/**
 * Lớp triển khai các chức năng của giỏ hàng
 */
@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    // Map chứa các mặt hàng trong giỏ, key = id, value = Item
    private Map<Integer, Item> map = new HashMap<>();

    @Override
    public Item add(Integer id) {
        // kiểm tra xem mặt hàng đã có trong giỏ chưa
        Item item = map.get(id);
        if (item == null) {
            // nếu chưa có, lấy từ DB và thêm mới
            Item dbItem = DB.items.get(id);
            if (dbItem != null) {
                item = new Item(dbItem.getId(), dbItem.getName(), dbItem.getPrice(), 1);
                map.put(id, item);
            }
        } else {
            // nếu có rồi thì tăng số lượng lên 1
            item.setQty(item.getQty() + 1);
        }
        return item;
    }

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    @Override
    public Item update(Integer id, int qty) {
        Item item = map.get(id);
        if (item != null) {
            item.setQty(qty);
        }
        return item;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<Item> getItems() {
        return map.values();
    }

    @Override
    public int getCount() {
        int total = 0;
        for (Item item : map.values()) {
            total += item.getQty();
        }
        return total;
    }

    @Override
    public double getAmount() {
        double sum = 0;
        for (Item item : map.values()) {
            sum += item.getPrice() * item.getQty();
        }
        return sum;
    }
}
