package poly.edu.service;

import java.util.Optional;
import poly.edu.entity.Account;

public interface AccountService {
    Optional<Account> findById(String username);
}
