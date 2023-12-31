/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom.baitaplon;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author add
 */
public class TaiKhoanCoKyHan extends TaiKhoanKhongKyHan{

    private LocalDate ngayDaoHan = LocalDate.now();
    private KyHan thongTinKyHan;
    private int loaiKyHan;

    public TaiKhoanCoKyHan(LocalDate ngayDaoHan, int loaiKyHan) {
        this.ngayDaoHan = ngayDaoHan;
        this.loaiKyHan = loaiKyHan;
    }
    public TaiKhoanCoKyHan(){
        
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
        System.out.print("=== BẠN MUỐN CHỌN LOẠI KỲ HẠN NÀO ===\n"
                    + "1) Kỳ hạn một tuần.\n"
                    + "2) Kỳ hạn một tháng.\n"
                    + "3) Kỳ hạn sáu tháng.\n"
                    + "4) Kỳ hạn một năm.\n"
                    + "=== MỜI BẠN CHỌN ===\n");
            System.out.print("+ Chọn một loại kỳ hạn:");
            this.loaiKyHan = CauHinh.SC.nextInt();
            try {
                System.out.print("* Đăng ký thành công.\n");
            } catch (Exception ex) {
                System.out.print("Bạn chọn sai nên loại kỳ hạn của bạn là kỳ hạn một tuần");
                this.loaiKyHan = 1;
            }
        switch (this.loaiKyHan) {
            case 1 -> {
                thongTinKyHan = new KyHanMotTuan(7, 2, this.getSoTienGui());
                this.ngayDaoHan = thongTinKyHan.tinhNgayDaoHan(this.ngayDaoHan);
            }
            case 2 -> {
                thongTinKyHan = new KyHanMotThang(1, 5.5, this.getSoTienGui());
                this.ngayDaoHan = thongTinKyHan.tinhNgayDaoHan(this.ngayDaoHan);
            }
            case 3 -> {
                thongTinKyHan = new KyHanSauThang(6, 5.5, this.getSoTienGui());
                this.ngayDaoHan = thongTinKyHan.tinhNgayDaoHan(this.ngayDaoHan);
            }
            default -> {
                thongTinKyHan = new KyHanMotNam(7, 2, this.getSoTienGui());
                this.ngayDaoHan = thongTinKyHan.tinhNgayDaoHan(this.ngayDaoHan);
            }
        }
            return new TaiKhoanCoKyHan(this.ngayDaoHan, this.loaiKyHan);
    }
    @Override
    public void hienThi() {
        super.hienThi();
        thongTinKyHan.hienThiThongTinKyHan();
        System.out.printf("+ Ngày đáo hạn: %s", this.ngayDaoHan.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)));
    }

    @Override
    public void ghiThongTinVaoFile() {
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(CauHinh.DATA_FILE, true);
            try(PrintWriter xuatFile = new PrintWriter(fileWriter)){
                xuatFile.printf("%s, %s, %s, %s, %s, Tài khoảng có kỳ hạn, %s,Ngày đáo hạn: %s, %s, %d, %.3f\n",this.getHoTen(), this.getSoCCCD(),
                        this.getNgaySinh().format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                        this.getQueQuan(), this.getGioiTinh(), this.getNgayDangKy().format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                        this.ngayDaoHan.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                        this.getSoTaiKhoan(), this.getMatKhau(), this.getSoTienGui());
            }        
        } catch (IOException ex){
            //Logger.getLogger(TaiKhoanCoKyHan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                //Logger.getLogger(TaiKhoanKhongKyHan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
