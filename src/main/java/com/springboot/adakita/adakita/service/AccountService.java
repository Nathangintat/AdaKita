package com.springboot.adakita.adakita.service;

import com.springboot.adakita.adakita.entity.Account;
import com.springboot.adakita.adakita.entity.AccountType;
import com.springboot.adakita.adakita.entity.Account_Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.adakita.adakita.repository.AccountRepository;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Account_Personal> getAllUsers() {
        return accountRepository.findAll();
    }

    public Account_Personal getUserById(int user_id) {
        return accountRepository.findById(user_id).orElse(null);
    }

    public Account_Personal addUser(Account_Personal account) {
        return accountRepository.save(account);
    }

    public Account updateUser(AccountType accountType, Account_Personal account) {
        account.setAccount_type(accountType);
        return accountRepository.save(account);
    }

    public void deleteUser(int user_id) {
        accountRepository.deleteById(user_id);
    }
}

