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
    public KyHanMotTuan(double soTien) {
        super(7, 0.02, soTien);
    }
    
    @Override
    public double tinhTienLai(LocalDate d) {
        return this.getSoTien()*this.getLaiSuat()*7/360;
    }
    @Override
    public LocalDate tinhNgayDaoHan(LocalDate d) {
       return d.plusDays(this.getNgay());
    }

    @Override
    public void hienThiThongTinKyHan() {
        System.out.print("+ Loại kỳ hạn: Kỳ hạn một tuần.\n+ Lãi suất: 2%/năm.\n");
    }
    
    @Override
    public String getTen() {
        return this.ten;
    }
}
