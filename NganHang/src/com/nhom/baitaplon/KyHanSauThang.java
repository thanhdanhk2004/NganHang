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
public class KyHanSauThang extends KyHan {

    private final String ten = "Kỳ hạn sáu tháng";
    private static final double laiSuat = 0.075;

    public KyHanSauThang() {
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
        return soTien * KyHanSauThang.getLaiSuat() * 180 / 360;
    }

    @Override
    public LocalDate tinhNgayDaoHan(LocalDate d) {
        return d.plusMonths(6);
    }

    @Override
    public void hienThiThongTinKyHan() {
        System.out.printf("+ Loại kỳ hạn: %s.%n+ Lãi suất: %.2f%%/năm.%n", this.ten, KyHanSauThang.laiSuat * 100);
    }

    @Override
    public String getDoiTuong() {
        return "KyHanSauThang";
    }

}
