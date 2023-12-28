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

    public KyHan(int ngay, double laiSuat) {
        this.ngay = ngay;
        this.laiSuat = laiSuat;
    }
    
    public abstract long tinhTienLai();
    public abstract LocalDate tinhNgayDaoHan();

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
}
