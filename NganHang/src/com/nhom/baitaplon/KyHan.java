/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom.baitaplon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author add
 */
public abstract class KyHan {

    private static List<KyHan> arrLKH = new ArrayList<>();
    private int ngay;
    private double soTien;

    public KyHan() {
    }

    /**
     * @return the ngay
     */
    public int getNgay() {
        return ngay;
    }

    /**
     * @param ngay the ngay to set
     */
    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    /**
     * @return the laiSuat
     */
    public static double getLaiSuat() {
        return 0;
    }

    /**
     * @return the soTien
     */
    public double getSoTien() {
        return soTien;
    }

    /**
     * @param soTien the soTien to set
     */
    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    /**
     * @return the arrLKH
     */
    public static List<KyHan> getArrLKH() {
        return KyHan.arrLKH;
    }

    public abstract double tinhTienLai();

    public abstract LocalDate tinhNgayDaoHan(LocalDate d);

    public abstract void hienThiThongTinKyHan();

    public abstract String getTen();

    public abstract String toString();

}
