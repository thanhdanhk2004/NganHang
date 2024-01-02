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
public class KyHanMotNam extends KyHan{

    private String ten = "Kỳ hạn một năm";
    public KyHanMotNam(double laiSuat) {
        super(0.079);
    }
    public KyHanMotNam(){
        
    }
    @Override
    public double tinhTienLai() {
        return this.getSoTien()*this.getLaiSuat();
    }
    @Override
    public LocalDate tinhNgayDaoHan(LocalDate d) {
       return d.plusYears(this.getNgay());
    }
    @Override
    public void hienThiThongTinKyHan() {
        System.out.print("+ Loại kỳ hạn: Kỳ hạn một năm.\n+ Lãi suất: 7.9%/năm.\n");
    }
    
    public String getTen() {
        return this.ten;
    }
    
    @Override
    public String toString() {
        return "KyHanMotNam";
    }
}
