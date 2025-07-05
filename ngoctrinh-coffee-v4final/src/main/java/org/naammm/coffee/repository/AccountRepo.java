package org.naammm.coffee.repository;

import org.naammm.coffee.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
