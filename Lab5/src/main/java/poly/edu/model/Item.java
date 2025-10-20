package poly.edu.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    Integer id;
    String name;
    double price;
    int qty;
}