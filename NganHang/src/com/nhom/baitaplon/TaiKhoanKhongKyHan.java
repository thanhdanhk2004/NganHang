/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom.baitaplon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author add
 */
public class TaiKhoanKhongKyHan implements TaiKhoan{
    private String hoTen;
    private String queQuan;
    private String gioiTinh;
    private String soCCCD;
    private LocalDate ngaySinh;
    private double soTienGui = 0;
    private int matKhau;
    private LocalDate ngayDangKy = LocalDate.now();
    private String soTaiKhoang;
    {
        this.soTaiKhoang = String.format("%d %d", this.ngaySinh, (int)(Math.random()*(9999-1000+1)+1000));
    }
    public TaiKhoanKhongKyHan(String hoTen, String queQuan, String gioiTinh, String soCCCD, LocalDate ngaySinh, int matKhau) {
        this.hoTen = hoTen;
        this.queQuan = queQuan;
        this.gioiTinh = gioiTinh;
        this.soCCCD = soCCCD;
        this.ngaySinh = ngaySinh;
        this.matKhau = matKhau;
    }
    public TaiKhoanKhongKyHan(){
        
    }
    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the queQuan
     */
    public String getQueQuan() {
        return queQuan;
    }

    /**
     * @param queQuan the queQuan to set
     */
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the soCCCD
     */
    public String getSoCCCD() {
        return soCCCD;
    }

    /**
     * @param soCCCD the soCCCD to set
     */
    public void setSoCCCD(String soCCCD) {
        this.soCCCD = soCCCD;
    }

    /**
     * @return the ngaySinh
     */
    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the soTienGui
     */
    public double getSoTienGui() {
        return soTienGui;
    }

    /**
     * @param soTienGui the soTienGui to set
     */
    public void setSoTienGui(double soTienGui) {
        this.soTienGui = soTienGui;
    }

    /**
     * @return the matKhau
     */
    public int getMatKhau() {
        return matKhau;
    }

    /**
     * @param matKhau the matKhau to set
     */
    public void setMatKhau(int matKhau) {
        this.matKhau = matKhau;
    }
    
    /**
     * @return the ngayDangKy
     */
    public LocalDate getNgayDangKy() {
        return LocalDate.now();
    }

    /**
     * @param ngayDangKy the ngayDangKy to set
     */
    public void setNgayDangKy(LocalDate ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }
    
    @Override
    public TaiKhoanKhongKyHan moTaiKhoan() {
        System.out.print("=== HÃY NHẬP VÀO MỘT SỐ THÔNG TIN CÂN THIẾT ĐỂ MỞ TÀI KHOẢNG ===\n");
        System.out.print("+ Nhập họ tên: ");
        this.hoTen = CauHinh.input.nextLine();
        System.out.print("+ Nhập ngày tháng năm sinh (dd/mm/yyyy):");
        String ngaySinh = CauHinh.input.nextLine();
        this.ngaySinh = LocalDate.parse(ngaySinh, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("+ Nhập số căn cước công dân:");
        this.soCCCD = CauHinh.input.nextLine();
        System.out.print("+ Nhập vào quê quán: ");
        this.queQuan = CauHinh.input.nextLine();
        System.out.printf("1) Nam.\n 2) Nữ.\n 3) Giới tính khác.\n");
        int choose;
        do{
           System.out.print("- Lựa chọn giới tính của ban:");
           choose = CauHinh.input.nextInt();
           if(choose < 1 || choose > 3)
               System.out.print("+ khong hop le! Moi chon lai.\n");
           else{
               if(choose == 1)
                   this.gioiTinh = "Nam";
               else if(choose == 2)
                   this.gioiTinh = "Nữ";
               else
                   this.gioiTinh = "Khác";
           }
        }while(choose < 1 || choose > 3);
        this.matKhau = (int)(Math.random()*(999999-100000+1)+100000);
        return new TaiKhoanKhongKyHan(this.hoTen, this.queQuan, this.gioiTinh, this.soCCCD, this.ngaySinh, this.matKhau);
    }

    @Override
    public void hienThi() {
        System.out.printf("+ Họ tên: %s\n + Ngày sinh: %s\n + Giới tính: %s\n+ Quê quán: %s\n+ Số CCCD: %s\n+ Ngày đăng ký: %s\n+ Số tài khoản: %s\n+ Số tiền: %f\n",
                this.hoTen,this.ngaySinh.format(DateTimeFormatter.ofPattern("dd//MM/yyyy")), this.gioiTinh, this.queQuan, 
                this.soCCCD, this.ngayDangKy.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),this.soTaiKhoang, this.soTienGui);
    }

    
}
