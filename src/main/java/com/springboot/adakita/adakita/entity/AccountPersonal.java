package com.springboot.adakita.adakita.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "account_personal")
public class AccountPersonal extends Account{

    @Column(name = "tujuan_peminjaman")
    private String tujuanPeminjaman;

    @Column(name = "date_of_birth")
    private Date date;

    @Column(name = "pendidikan")
    private String pendidikan;

    @Column(name = "pekerjaan")
    private String pekerjaan;

    @Column(name = "ktp")
    private String ktp;

    public AccountPersonal() {}

    public AccountPersonal(int account_id, String username, String password, String name, int telp_number, int poin, AccountType account_type, String tujuanPeminjaman, Date date, String pendidikan, String pekerjaan, String ktp) {
        super(account_id, username, password, name, telp_number, poin, account_type);
        this.tujuanPeminjaman = tujuanPeminjaman;
        this.date = date;
        this.pendidikan = pendidikan;
        this.pekerjaan = pekerjaan;
        this.ktp = ktp;
    }

    public void setTujuanPeminjaman(String tujuanPeminjaman) {
        this.tujuanPeminjaman = tujuanPeminjaman;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getTujuanPeminjaman() {
        return tujuanPeminjaman;
    }

    public Date getDate() {
        return date;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public String getKtp() {
        return ktp;
    }
}
