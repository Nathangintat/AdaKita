package com.springboot.adakita.adakita.controller;

import com.springboot.adakita.adakita.entity.Account_Personal;
import com.springboot.adakita.adakita.entity.AccountType;
import com.springboot.adakita.adakita.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Get All Users
    @GetMapping
    public ResponseEntity<List<Account_Personal>> getAllUsers() {
        List<Account_Personal> users = accountService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<Account_Personal> getUserById(@PathVariable("id") int userId) {
        Account_Personal user = accountService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    // Add New User
    @PostMapping
    public ResponseEntity<Account_Personal> addUser(@RequestBody Account_Personal account) {
        Account_Personal newAccount = accountService.addUser(account);
        return ResponseEntity.ok(newAccount);
    }

    // Update User
    @PutMapping("/{id}")
    public ResponseEntity<Account_Personal> updateUser(
            @PathVariable("id") int userId,
            @RequestBody Account_Personal updatedAccount) {

        Account_Personal existingAccount = accountService.getUserById(userId);
        if (existingAccount == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the account's type or other fields here if needed
        existingAccount.setName(updatedAccount.getName());
        existingAccount.setTelp_number(updatedAccount.getTelp_number());
        existingAccount.setPoin(updatedAccount.getPoin());
        existingAccount.setAccount_type(updatedAccount.getAccount_type());

        Account_Personal updated = accountService.addUser(existingAccount);
        return ResponseEntity.ok(updated);
    }

    // Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int userId) {
        Account_Personal existingAccount = accountService.getUserById(userId);
        if (existingAccount == null) {
            return ResponseEntity.notFound().build();
        }
        accountService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
