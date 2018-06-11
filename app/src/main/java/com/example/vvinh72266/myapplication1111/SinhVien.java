package com.example.vvinh72266.myapplication1111;

import java.io.Serializable;

/**
 * Created by v.vinh72266 on 09-Jun-18.
 */

public class SinhVien implements Serializable{
    private int Id;
    private String HoTen;
    private int NamSinh;
    private String DiaChi;

    public void setId(int id) {
        Id = id;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public void setNamSinh(int namSinh) {
        NamSinh = namSinh;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public int getId() {
        return Id;
    }

    public String getHoTen() {
        return HoTen;
    }

    public int getNamSinh() {
        return NamSinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public SinhVien(int id, String hoTen, int namSinh, String diaChi) {
        Id = id;
        HoTen = hoTen;
        NamSinh = namSinh;
        DiaChi = diaChi;
    }
}
