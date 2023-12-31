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
public class KyHanSauThang extends KyHan{
    public KyHanSauThang(int ngay, double laiSuat, double soTien) {
        super(ngay, laiSuat, soTien);
    }
    @Override
    public double tinhTienLai(LocalDate d) {
        int soNgayGui = (int) ChronoUnit.DAYS.between(d, LocalDate.now());
        return this.getSoTien()*this.getLaiSuat()*soNgayGui/360;
    }
    @Override
    public LocalDate tinhNgayDaoHan(LocalDate d) {
       return d.plusMonths(this.getNgay());
    }
    @Override
    public void hienThiThongTinKyHan() {
        System.out.print("+ Loại kỳ hạn: Kỳ hạn sáu tháng.\n+ Lãi suất: 5.5%.\n");
    }
}
