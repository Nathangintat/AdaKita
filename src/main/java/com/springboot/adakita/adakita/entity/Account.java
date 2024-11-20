package com.springboot.adakita.adakita.entity;

import jakarta.persistence.*;

import java.lang.reflect.Type;
import java.util.Date;
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int account_id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "telp_number")
    private int telp_number;

    @Column(name = "poin")
    private int poin;

    @Enumerated(EnumType.STRING)
    @Column(name="account_type", nullable = false, updatable = false)
    private AccountType account_type;

    public Account(int account_id, String username, String password, String name, int telp_number, int poin, AccountType account_type) {
        this.account_id = account_id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.telp_number = telp_number;
        this.poin = poin;
        this.account_type = account_type;
    }

    public Account() {}

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelp_number(int telp_number) {
        this.telp_number = telp_number;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }

    public void setAccount_type(AccountType account_type) {
        this.account_type = account_type;
    }

    public int getAccount_id() {
        return account_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getTelp_number() {
        return telp_number;
    }

    public int getPoin() {
        return poin;
    }

    public AccountType getAccount_type() {
        return account_type;
    }
}



