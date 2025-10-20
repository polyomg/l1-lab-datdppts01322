package poly.edu.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    String username;
    String password;
    String fullname;
    String email;
    Boolean admin = false;
}
