/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom.baitaplon;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private String soTaiKhoan;
    private List<TaiKhoanCoKyHan> quanDanhSachTaiKhoanCoKyHan = new ArrayList();
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
    
     /**
     * @return the soTaiKhoang
     */
    public String getSoTaiKhoan() {
        return this.soTaiKhoan;
    }
    
    /**
     * @param soTaiKhoan the soTaiKhoang to set
     */
    public void setSoTaiKhoang(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }
    
    @Override
    public TaiKhoanKhongKyHan moTaiKhoan() {
        System.out.print("=== HÃY NHẬP VÀO MỘT SỐ THÔNG TIN CÂN THIẾT ĐỂ MỞ TÀI KHOẢNG ===\n");
        System.out.print("+ Nhập họ tên: ");
        this.hoTen = CauHinh.input.nextLine();
        System.out.print("+ Nhập ngày tháng năm sinh (dd/mm/yyyy):");
        String ngaySinh = CauHinh.input.nextLine();
        this.ngaySinh = LocalDate.parse(ngaySinh, DateTimeFormatter.ofPattern(CauHinh.DATE_fORMAT));
        System.out.print("+ Nhập số căn cước công dân:");
        this.soCCCD = CauHinh.input.nextLine();
        System.out.print("+ Nhập vào quê quán: ");
        this.queQuan = CauHinh.input.nextLine();
        System.out.printf("1) Nam.\n2) Nữ.\n3) Giới tính khác.\n");
        int choose;
        try{
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
        }catch(Exception ex){
            System.out.print("+ Do bạn nhập sai nên chúng tôi sẽ mặc định giới tính của bạn là khác.\n");
            choose = 3;
        }
        this.matKhau = (int)(Math.random()*(999999-100000+1)+100000);
        this.soTaiKhoan = String.format("%s%d", this.ngaySinh.format(DateTimeFormatter.ofPattern("ddMMyyyy")), (int)(Math.random()*(9999-1000+1)+1000));
        return new TaiKhoanKhongKyHan(this.hoTen, this.queQuan, this.gioiTinh, this.soCCCD, this.ngaySinh, this.matKhau);
    }

    @Override
    public void hienThi() {
        System.out.printf("+ Họ tên: %s\n+ Ngày sinh: %s\n+ Giới tính: %s\n+ Quê quán: %s\n+ Số CCCD: %s\n+ Ngày đăng ký: %s\n+ Số tài khoản: %s\n+ Số tiền: %f\n",
                this.hoTen,this.ngaySinh.format(DateTimeFormatter.ofPattern(CauHinh.DATE_fORMAT)), this.gioiTinh, this.queQuan, 
                this.soCCCD, this.ngayDangKy.format(DateTimeFormatter.ofPattern(CauHinh.DATE_fORMAT)), this.soTaiKhoan, this.soTienGui);
    }
    
    public boolean kiemTraMatKhau(String s){
        if(s.length() != 6)
            return false;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) > '9' || s.charAt(i) < '0')
                return false;
        }
        return true;
    }
    @Override
    public void doiMatKhau(){
        String s1,s2;
            do{
                System.out.print("* Nhập vào mật khẩu mới(Sáu số): ");
                s1 = CauHinh.input.nextLine();
                if(kiemTraMatKhau(s1)==false)
                    System.out.print("+ Lưu ý mật khẩu chỉ là số.\n");
            }while(kiemTraMatKhau(s1)==false);
            do{
                System.out.print("* Nhập lại mật khẩu mới(Sáu số):");
                s2 = CauHinh.input.nextLine();
                if(s1.equals(s2) == false)
                    System.out.print("+ Không trùng khớp! Mời nhâp lại.\n");
            }while(s1.equals(s2) == false);
            this.matKhau = Integer.parseInt(s1);  
            System.out.print("- ĐỔI MẬT KHẨU THÀNH CÔNG.\n");
    }

    @Override
    public void ghiThongTinVaoFile() {
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(CauHinh.file, true);
            try(PrintWriter xuatFile = new PrintWriter(fileWriter)){
                xuatFile.printf("%s, %s, %s, %s, %s, Tài khoảng không kỳ hạn, %s, %s, %d, %.3f\n",this.hoTen, this.soCCCD,
                        this.ngaySinh.format(DateTimeFormatter.ofPattern(CauHinh.DATE_fORMAT)),
                        this.queQuan, this.gioiTinh, this.ngayDangKy.format(DateTimeFormatter.ofPattern(CauHinh.DATE_fORMAT)),
                        this.soTaiKhoan, this.matKhau, this.soTienGui);
            }        } catch (IOException ex){
            Logger.getLogger(TaiKhoanKhongKyHan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(TaiKhoanKhongKyHan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void thongTinCanSua(){
        System.out.print("=== HÃY KIỂM TRA BẠN CÓ MUỐN SỬA BẤT KÌ THÔNG TIN NÀO KHÔNG ===\n");
        System.out.printf("1) Họ tên.\n2) Ngày sinh.\n3) Quê quán.\n4) Giới tính.\n5) Số cccd.\n6) Thông tin đã chính xác");
    }
    public void suaThongTin() {
        int sua;
        try{
            do{
                this.thongTinCanSua();
                System.out.print("- Bạn muốn sửa thông tin số mấy:");
                sua = CauHinh.input.nextInt();
                CauHinh.input.nextLine();
                switch (sua) {
                    case 1 -> {
                        System.out.print("+ Hãy sửa lại họ tên:");
                        this.hoTen = CauHinh.input.nextLine();
                    }
                    case 2 -> {
                        System.out.print("+ Hãy sửa lại ngày sinh:");
                        String s = CauHinh.input.nextLine();
                        this.ngaySinh = LocalDate.parse(s, DateTimeFormatter.ofPattern(CauHinh.DATE_fORMAT));
                    }
                    case 3 -> {
                        System.out.print("+ Hãy sửa lại quê quán:");
                        this.hoTen = CauHinh.input.nextLine();
                    }
                    case 4 -> {
                        System.out.printf("1) Nam.\n2) Nữ.\n3) Giới tính khác.\n");
                        int choose;
                        try {
                            System.out.print("- Lựa chọn giới tính của ban:");
                            choose = CauHinh.input.nextInt();
                            if (choose < 1 || choose > 3) {
                                System.out.print("+ khong hop le! Moi chon lai.\n");
                            } else {
                                if (choose == 1) {
                                    this.gioiTinh = "Nam";
                                } else if (choose == 2) {
                                    this.gioiTinh = "Nữ";
                                } else {
                                    this.gioiTinh = "Khác";
                                }
                            }
                        } catch (Exception ex) {
                            System.out.print("+ Do bạn nhập sai nên chúng tôi sẽ mặc định giới tính của bạn là khác.\n");
                            choose = 3;
                        }
                    }
                    case 5 -> {
                        System.out.print("+ Hãy sửa lại số cccd:");
                        this.hoTen = CauHinh.input.nextLine();
                    }
                    default ->
                        System.out.print("+ Thông tin của bạn đã được lưu.\n");
                }
            }while(sua > 0 & sua < 6);
        }catch(Exception ex){
            System.out.print("* Thông tin đã được lưu.\n");
        }
    }

    @Override
    public void goiTien(double soTien) {
        this.soTienGui += soTien;
    }

    @Override
    public void rutTien(double soTien) {
        if(this.soTienGui >= soTien)
            this.soTienGui += soTien;
    }

    /**
     * @return the quanDanhSachTaiKhoanCoKyHan
     */
    public List<TaiKhoanCoKyHan> getQuanDanhSachTaiKhoanCoKyHan() {
        return quanDanhSachTaiKhoanCoKyHan;
    }

    /**
     * @param quanDanhSachTaiKhoanCoKyHan the quanDanhSachTaiKhoanCoKyHan to set
     */
    public void setQuanDanhSachTaiKhoanCoKyHan(List<TaiKhoanCoKyHan> quanDanhSachTaiKhoanCoKyHan) {
        this.quanDanhSachTaiKhoanCoKyHan = quanDanhSachTaiKhoanCoKyHan;
    }

    @Override
    public double tinhTienLai(double laiSuat) {
        int soNgayGui = (int) ChronoUnit.DAYS.between(this.ngayDangKy, LocalDate.now());
        return this.soTienGui*laiSuat*soNgayGui/360;
    }
    
}
