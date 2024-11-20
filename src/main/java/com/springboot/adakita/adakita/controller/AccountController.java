package com.springboot.adakita.adakita.controller;

import com.springboot.adakita.adakita.entity.AccountPersonal;
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
    public ResponseEntity<List<AccountPersonal>> getAllUsers() {
        List<AccountPersonal> users = accountService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<AccountPersonal> getUserById(@PathVariable("id") int userId) {
        AccountPersonal user = accountService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    // Add New User
    @PostMapping
    public ResponseEntity<AccountPersonal> addUser(@RequestBody AccountPersonal account) {
        AccountPersonal newAccount = accountService.addUser(account);
        return ResponseEntity.ok(newAccount);
    }

    // Update User
    @PutMapping("/{id}")
    public ResponseEntity<AccountPersonal> updateUser(
            @PathVariable("id") int userId,
            @RequestBody AccountPersonal updatedAccount) {

        AccountPersonal existingAccount = accountService.getUserById(userId);
        if (existingAccount == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the account's type or other fields here if needed
        existingAccount.setName(updatedAccount.getName());
        existingAccount.setTelp_number(updatedAccount.getTelp_number());
        existingAccount.setPoin(updatedAccount.getPoin());
        existingAccount.setAccount_type(updatedAccount.getAccount_type());

        AccountPersonal updated = accountService.addUser(existingAccount);
        return ResponseEntity.ok(updated);
    }

    // Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int userId) {
        AccountPersonal existingAccount = accountService.getUserById(userId);
        if (existingAccount == null) {
            return ResponseEntity.notFound().build();
        }
        accountService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
