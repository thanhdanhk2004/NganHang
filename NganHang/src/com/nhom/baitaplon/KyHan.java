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
    private static ArrayList<KyHan> arrLKH = new ArrayList<>();
    private int ngay;
    private double laiSuat;
    private double soTien;
    
    {
        KyHan.getArrLKH().addAll(Arrays.asList(new KyHanMotTuan(0), new KyHanMotThang(0), new KyHanSauThang(0), new KyHanMotNam(0)));
        
    }

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
<<<<<<< HEAD

    /**
     * @return the arrLKH
     */
    public static ArrayList<KyHan> getArrLKH() {
        return arrLKH;
    }
    
    public abstract String getTen();
=======
>>>>>>> e5488d033de64f9176d9fb3c3975927ad418ec5d
    
}
