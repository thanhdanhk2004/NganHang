/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom.baitaplon;

import java.time.LocalDate;

/**
 *
 * @author add
 */
public class KyHanMotTuan extends KyHan {

    private final String ten = "Kỳ hạn một tuần";
    private static final double laiSuat = 0.02;

    public KyHanMotTuan() {
    }

    /**
     * @return the ten
     */
    public String getTen() {
        return ten;
    }

    /**
     * @return the laiSuat
     */
    public static double getLaiSuat() {
        return laiSuat;
    }

    @Override
    public double tinhTienLai(Double soTien) {
        return soTien * KyHanMotTuan.getLaiSuat() * 7 / 360;
    }

    @Override
    public LocalDate tinhNgayDaoHan(LocalDate d) {
        return d.plusDays(7);
    }

    @Override
    public void hienThiThongTinKyHan() {
        System.out.printf("+ Loại kỳ hạn: %s.%n+ Lãi suất: %.2f%%/năm.%n", this.ten, KyHanMotTuan.laiSuat * 100);
    }

    @Override
    public String toString() {
        return "KyHanMotTuan";
    }

}
