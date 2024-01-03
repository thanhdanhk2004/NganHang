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
public class KyHanSauThang extends KyHan{
    
    private String ten = "Kỳ hạn sáu tháng";
    public KyHanSauThang(double laiSuat) {
        super(0.055);
    }
    public KyHanSauThang(){
        
    }
    @Override
    public double tinhTienLai() {
        return this.getSoTien()*this.getLaiSuat()*180/360;
    }
    @Override
    public LocalDate tinhNgayDaoHan(LocalDate d) {
       return d.plusMonths(6);
    }

    /**
     *
     */
    @Override
    public void hienThiThongTinKyHan() {
        System.out.print("+ Loại kỳ hạn: Kỳ hạn sáu tháng.\n+ Lãi suất: 7.5%.\n");
    }
    
    public String getTen() {
        return this.ten;
    }

    @Override
    public String toString() {
        return "KyHanSauThang";
    }
    
}
