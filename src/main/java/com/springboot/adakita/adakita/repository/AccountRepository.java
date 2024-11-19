package com.springboot.adakita.adakita.repository;

import com.springboot.adakita.adakita.entity.Account;
import com.springboot.adakita.adakita.entity.Account_Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Interface
public interface AccountRepository
        extends JpaRepository<Account_Personal, Integer> {
}
