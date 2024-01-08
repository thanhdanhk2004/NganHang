///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.nhom.baitaplon;
//
//import java.time.LocalDate;
//
///**
// *
// * @author add
// */
//public class KyHanMotQuy {
//
//    private final String ten = "Kỳ hạn một quý";
//    private static final double laiSuat = 0.06;
//
//    public KyHanMotQuy() {
//    }
//
//    /**
//     * @return the ten
//     */
//    @Override
//    public String getTen() {
//        return ten;
//    }
//
//    /**
//     * @return the laiSuat
//     */
//    public static double getLaiSuat() {
//        return laiSuat;
//    }
//
//    @Override
//    public double tinhTienLai(Double soTien) {
//        return soTien * KyHanMotQuy.getLaiSuat() * 30 / 360;
//    }
//
//    @Override
//    public LocalDate tinhNgayDaoHan(LocalDate d) {
//        return d.plusMonths(3);
//    }
//
//    @Override
//    public void hienThiThongTinKyHan() {
//        System.out.printf("+ Loại kỳ hạn: %s.%n+ Lãi suất: %.2f%%/năm.%n", this.ten, KyHanMotQuy.laiSuat * 100);
//    }
//
//    @Override
//    public String getDoiTuong() {
//        return "KyHanMotQuy";
//    }
//
//}
