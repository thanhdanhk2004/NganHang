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
public class KyHanMotThang extends KyHan{
    
    private String ten = "Kỳ hạn một tháng";
    public KyHanMotThang(double soTien) {
        super(30, 0.05, soTien);
    }
    @Override
    public double tinhTienLai(LocalDate d) {
        return this.getSoTien()*this.getLaiSuat()*30/360;
    }
    @Override
    public LocalDate tinhNgayDaoHan(LocalDate d) {
       return d.plusMonths(this.getNgay());
    }
    @Override
    public void hienThiThongTinKyHan() {
        System.out.print("+ Loại kỳ hạn: Kỳ hạn một tháng.\n+ Lãi suất: 5%/năm.\n");
    }
    
    @Override
    public String getTen() {
        return this.ten;
    }
}
