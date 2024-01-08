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
public class KyHanMotNam extends KyHan {

    private final String ten = "Kỳ hạn một năm";
    private static final double laiSuat = 0.079;

    /**
     * @return the laiSuat
     */
    public static double getLaiSuat() {
        return laiSuat;
    }

    /**
     * @return the ten
     */
    @Override
    public String getTen() {
        return ten;
    }

    public KyHanMotNam() {
    }

    ;
    
    @Override
    public double tinhTienLai(Double soTien) {
        return soTien * KyHanMotNam.getLaiSuat();
    }

    @Override
    public LocalDate tinhNgayDaoHan(LocalDate d) {
        return d.plusYears(1);
    }

    @Override
    public void hienThiThongTinKyHan() {
        System.out.printf("+ Loại kỳ hạn: %s.%n+ Lãi suất: %.2f%%/năm.%n", this.getTen(), KyHanMotNam.getLaiSuat() * 100);
    }

    @Override
    public String getDoiTuong() {
        return "KyHanMotNam";
    }

}
