/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom.baitaplon;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author add
 */
public class TaiKhoanCoKyHan extends TaiKhoanKhongKyHan {
    private LocalDate ngayDaoHan = LocalDate.now();
    private KyHan thongTinKyHan;
    private String loaiKyHan;
    
    public TaiKhoanCoKyHan(KyHan thongTinKyHan) {
        this.thongTinKyHan = thongTinKyHan;
    }
    public TaiKhoanCoKyHan(){};
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
    public String getLoaiKyHan() {
        return loaiKyHan;
    }

    /**
     * @param loaiKyHan the loaiKyHan to set
     */
    public void setLoaiKyHan(String loaiKyHan) {
        this.loaiKyHan = loaiKyHan;
    }
   
    @Override
    public TaiKhoanCoKyHan moTaiKhoan(){
        try {
            int choice;
            System.out.println("=== LOẠI KỲ HẠN ===");
            int i;
            for (i = 0; i < KyHan.getArrLKH().size(); i++) {
                System.out.printf("%d) %s\n", i + 1, KyHan.getArrLKH().get(i).getTen());
            }
            System.out.print("- Bạn muốn chọn loại kỳ hạn nào:");
            String ch = CauHinh.SC.nextLine();
            if (ch.matches("[0-9]+")) {
                choice = Integer.parseInt(ch);
            } else {
                choice = 0;
            }
            
            String classPath = "com.nhom.baitaplon." + KyHan.getArrLKH().get(choice - 1).toString();
            Class c = Class.forName(classPath);
            KyHan kyHan = (KyHan) c.getConstructor().newInstance();
            this.thongTinKyHan = kyHan;
            this.ngayDaoHan = this.thongTinKyHan.tinhNgayDaoHan(this.ngayDaoHan);
            return new TaiKhoanCoKyHan(kyHan);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanCoKyHan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
                xuatFile.printf("%s, %s, %s, %s, %s, Tài khoảng có kỳ hạn, %s, %s, %d, %.3f, %s, %s\n", this.getHoTen(), this.getSoCCCD(),
                        this.getNgaySinh().format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                        this.getQueQuan(), this.getGioiTinh(), this.getNgayDangKy().format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                        this.getSoTaiKhoan(), this.getMatKhau(), this.getSoTienGui(),
                        this.ngayDaoHan.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                        this.thongTinKyHan.getTen());
            }
        } catch (IOException ex) {
            //Logger.getLogger(TaiKhoanCoKyHan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(TaiKhoanKhongKyHan.class.getName()).log(Level.SEVERE, null, ex);
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
