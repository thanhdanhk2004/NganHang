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

    public KyHanMotTuan(int ngay, double laiSuat, double soTien) {
        super(ngay, laiSuat, soTien);
    }
    
    @Override
    public double tinhTienLai() {
        return (this.getSoTien()*1.0/100)*this.getLaiSuat();
    }
    @Override
    public LocalDate tinhNgayDaoHan(LocalDate d) {
       return d.plusDays(this.getNgay());
    }

    @Override
    public void hienThiThongTinKyHan() {
        System.out.print("+ Loại kỳ hạn: Kỳ hạn một tuần.\n+ Lãi suất: 2%/năm.\n");
    }
    
}
