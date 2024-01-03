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
public class KyHanMotTuan extends KyHan{
    
    private String ten = "Kỳ hạn một tuần";
    public KyHanMotTuan(double laiSuat) {
        super(0.02);
    }
    public KyHanMotTuan(){
        
    }
    @Override
    public double tinhTienLai() {
        return this.getSoTien()*this.getLaiSuat()*7/360;
    }
    @Override
    public LocalDate tinhNgayDaoHan(LocalDate d) {
       return d.plusDays(7);
    }

    @Override
    public void hienThiThongTinKyHan() {
        System.out.print("+ Loại kỳ hạn: Kỳ hạn một tuần.\n+ Lãi suất: 2%/năm.\n");
    }
    
    public String getTen() {
        return this.ten;
    }
    @Override
    public String toString() {
        return "KyHanMotTuan";
    }
    
}
