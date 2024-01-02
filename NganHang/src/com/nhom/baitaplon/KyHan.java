/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom.baitaplon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author add
 */
public abstract class KyHan {
    private static List<KyHan> arrLKH = new ArrayList<>();
    private int ngay;
    private double laiSuat;
    private double soTien;
//    {
//       // KyHan.arrLKH.add(Arrays.asList(new KyHanMotTuan(0), new KyHanMotThang(0), new KyHanSauThang(0), new KyHanMotNam(0)));
//    }

    public KyHan(double laiSuat) {
        this.laiSuat = laiSuat;
    }
    public KyHan(){
        
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
    public double getLaiSuat() {
        return laiSuat;
    }

    /**
     * @param laiSuat the laiSuat to set
     */
    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
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

    public abstract double tinhTienLai();

    public abstract LocalDate tinhNgayDaoHan(LocalDate d);

    public abstract void hienThiThongTinKyHan();

    /**
     * @return the arrLKH
     */
    public static List<KyHan> getArrLKH() {
        return KyHan.arrLKH;
    }
    public abstract String getTen();
    public abstract String toString();
}
