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
public abstract class KyHan {
    private int ngay;
    private double laiSuat;
    private double soTien;
    public KyHan(int ngay, double laiSuat, double soTien) {
        this.ngay = ngay;
        this.laiSuat = laiSuat;
        this.soTien = soTien;
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
    
    public abstract double tinhTienLai(LocalDate d);
    public abstract LocalDate tinhNgayDaoHan(LocalDate d);
    public abstract void hienThiThongTinKyHan();
}
