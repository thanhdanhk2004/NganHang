/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom.baitaplon;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author add
 */
public class TaiKhoanCoKyHan extends TaiKhoanKhongKyHan {

    private LocalDate ngayDaoHan = LocalDate.now();
    private KyHan thongTinKyHan;
    private int loaiKyHan;

    public TaiKhoanCoKyHan(LocalDate ngayDaoHan, int loaiKyHan) {
        this.ngayDaoHan = ngayDaoHan;
        this.loaiKyHan = loaiKyHan;
    }

    public TaiKhoanCoKyHan() {

    }

    public LocalDate getNgayDaoHan() {
        return ngayDaoHan;
    }

    /**
     * @param ngayDaoHan the ngayDaoHan to set
     */
    public void setNgayDaoHan(LocalDate ngayDaoHan) {
        this.ngayDaoHan = ngayDaoHan;
    }

    /**
     * @return the loaiKyHan
     */
    public int getLoaiKyHan() {
        return loaiKyHan;
    }

    /**
     * @param loaiKyHan the loaiKyHan to set
     */
    public void setLoaiKyHan(int loaiKyHan) {
        this.loaiKyHan = loaiKyHan;
    }

    @Override
    public TaiKhoanCoKyHan moTaiKhoan() {
        int choice;
        System.out.println("=== LOẠI KỲ HẠN ===");
        int i;
        for(i = 0; i < CauHinh.SLKH; i++) {
            System.out.printf("%d) %s\n", i + 1, KyHan.getArrLKH().get(i).getTen());
        }
        String ch = CauHinh.SC.nextLine();
        if (ch.matches("[0-9]+")) {
             choice = Integer.parseInt(ch);
        }
        else
            choice = 0;
        switch (choice) {
            case 1 -> {
                setThongTinKyHan(new KyHanMotTuan(this.getSoTienGui()));
                this.ngayDaoHan = getThongTinKyHan().tinhNgayDaoHan(this.ngayDaoHan);
                break;
            }
            case 2 -> {
                setThongTinKyHan(new KyHanMotThang(this.getSoTienGui()));
                this.ngayDaoHan = getThongTinKyHan().tinhNgayDaoHan(this.ngayDaoHan);
                break;
            }
            case 3 -> {
                setThongTinKyHan(new KyHanSauThang(this.getSoTienGui()));
                this.ngayDaoHan = getThongTinKyHan().tinhNgayDaoHan(this.ngayDaoHan);
                break;
            }
            case 4 -> {
                setThongTinKyHan(new KyHanMotNam(this.getSoTienGui()));
                this.ngayDaoHan = getThongTinKyHan().tinhNgayDaoHan(this.ngayDaoHan);
                break;
            }
            default -> {
                System.out.println("\nLựa chọn không hợp lệ! Nhấn Enter để nhập lại.\n");
                CauHinh.SC.nextLine();
            }
        }
        return new TaiKhoanCoKyHan(this.ngayDaoHan, this.loaiKyHan);
    }

    @Override
    public void hienThi() {
        super.hienThi();
        getThongTinKyHan().hienThiThongTinKyHan();
        System.out.printf("+ Ngày đáo hạn: %s", this.ngayDaoHan.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)));
    }

    @Override
    public void ghiThongTinVaoFile() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(CauHinh.DATA_FILE, true);
            try (PrintWriter xuatFile = new PrintWriter(fileWriter)) {
                xuatFile.printf("%s, %s, %s, %s, %s, Tài khoảng có kỳ hạn, %s, %s, %d, %.3f, %s\n", this.getHoTen(), this.getSoCCCD(),
                        this.getNgaySinh().format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                        this.getQueQuan(), this.getGioiTinh(), this.getNgayDangKy().format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                        this.getSoTaiKhoan(), this.getMatKhau(), this.getSoTienGui(),
                        this.ngayDaoHan.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)));
            }
        } catch (IOException ex) {
            //Logger.getLogger(TaiKhoanCoKyHan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                //Logger.getLogger(TaiKhoanKhongKyHan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @return the thongTinKyHan
     */
    public KyHan getThongTinKyHan() {
        return thongTinKyHan;
    }

    /**
     * @param thongTinKyHan the thongTinKyHan to set
     */
    public void setThongTinKyHan(KyHan thongTinKyHan) {
        this.thongTinKyHan = thongTinKyHan;
    }
    
}
