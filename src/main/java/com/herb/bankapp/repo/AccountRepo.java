package com.herb.bankapp.repo;

import com.herb.bankapp.entity.Account;
import com.herb.bankapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
    Account findAccountByUser(User user);
}
