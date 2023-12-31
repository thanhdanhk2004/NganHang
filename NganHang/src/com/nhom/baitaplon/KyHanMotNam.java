/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom.baitaplon;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author add
 */
public class KyHanMotNam extends KyHan{
    public KyHanMotNam(int ngay, double laiSuat, double soTien) {
        super(ngay, laiSuat, soTien);
    }
    @Override
    public double tinhTienLai(LocalDate d) {
        int soNgayGui = (int) ChronoUnit.DAYS.between(d, LocalDate.now());
        return this.getSoTien()*this.getLaiSuat()*soNgayGui/360;
    }
    @Override
    public LocalDate tinhNgayDaoHan(LocalDate d) {
       return d.plusYears(this.getNgay());
    }
    @Override
    public void hienThiThongTinKyHan() {
        System.out.print("+ Loại kỳ hạn: Kỳ hạn một tuần.\n+ Lãi suất: 7.9%/năm.\n");
    }
    
}
