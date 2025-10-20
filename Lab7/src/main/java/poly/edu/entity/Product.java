package poly.edu.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;
    String image;
    Double price;

    @Temporal(TemporalType.DATE)
    Date createdate = new Date();

    Boolean available;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    Category category;
}
