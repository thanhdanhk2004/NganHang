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
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nganhang.NganHang;

/**
 *
 * @author add
 */
public class TaiKhoanKhongKyHan implements TaiKhoan {

    private static int dem = 0;
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

    public TaiKhoanKhongKyHan() {

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
    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public String nhapHoTen() {
        String hoTen;
        do {
            System.out.print("+ Nhập họ tên: ");
            hoTen = CauHinh.SC.nextLine().toUpperCase();
            if (!hoTen.matches("[A-Za-z]")) {
                System.out.println("\nTên chỉ có thể chứa chữ cái! Nhấn Enter để nhập lại.\n");
                CauHinh.SC.nextLine();
            }
        } while (!hoTen.matches("[A-Za-z]"));
        return hoTen;
    }

    public LocalDate nhapNgayThangNamSinh() {
        String ngaySinh;
        do {
            System.out.print("+ Nhập ngày tháng năm sinh (dd/mm/yyyy): ");
            ngaySinh = CauHinh.SC.nextLine();
            if (!ngaySinh.matches("(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/([12]\\d{3})")) {
                System.out.println("\nDữ liệu phải được nhập dưới dạng(dd/mm/yyyy)! Nhấn Enter để nhập lại.\n");
                CauHinh.SC.nextLine();
            }
        } while (!ngaySinh.matches("(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/([12]\\d{3})"));
        return LocalDate.parse(ngaySinh, DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT));
    }

    public String nhapSoCCCD() {
        String soCCCD;
        do {
            System.out.print("+ Nhập số căn cước công dân: ");
            soCCCD = CauHinh.SC.nextLine();
            if (!soCCCD.matches("[0-9]+")) {
                System.out.println("\nCăn cước công dân chỉ bao gồm chữ số! Nhấn Enter để nhập lại.\n");
                CauHinh.SC.nextLine();
            }
        } while (!soCCCD.matches("[0-9]+"));
        return soCCCD;
    }

    public String nhapQueQuan() {
        String queQuan;
        do {
            System.out.print("+ Nhập vào quê quán: ");
            queQuan = CauHinh.SC.nextLine();
            if (!queQuan.matches("[A-Za-z]")) {
                System.out.println("\nQuê quán chỉ bao gồm chữ cái! Nhấn Enter để nhập lại.\n");
                CauHinh.SC.nextLine();
            }
        } while (!queQuan.matches("[A-Za-z]"));
        return queQuan;
    }

    public String nhapGioiTinh() {
        int choice;
        String gioiTinh = "Khác";
        do {
            choice = NganHang.menu("1) Nam.\n2) Nữ.\n3) Giới tính khác.\n");

            switch (choice) {
                case 1:
                    gioiTinh = "Nam";
                    break;
                case 2:
                    gioiTinh = "Nữ";
                    break;
                case 3:
                    gioiTinh = "Khác";
                    break;
                default:
                    System.out.println("\nLựa chọn không hợp lệ! Nhấn Enter để nhập lại.\n");
                    CauHinh.SC.nextLine();
            }
        } while (choice != 1 && choice != 2 && choice != 3);
        return gioiTinh;
    }

    public int nhapMatKhau() {
        String matKhau;
        do {
            System.out.print("Nhập mật khẩu: ");
            matKhau = CauHinh.SC.nextLine();
            if (matKhau.length() != 6 || !matKhau.matches("[0-9]+")) {
                System.out.println("\nMật khẩu chỉ có thể bao gồm 6 chữ số! Nhấn Enter để nhập lại.\n");
                CauHinh.SC.nextLine();
            }
        } while (matKhau.length() != 6 || !matKhau.matches("[0-9]+"));
        return Integer.parseInt(matKhau);
    }

    @Override
    public TaiKhoanKhongKyHan moTaiKhoan() {
        System.out.print("=== THÔNG TIN CÁ NHÂN ===\n");
        System.out.print("+ Nhập họ tên: ");
        this.hoTen = CauHinh.SC.nextLine();
        this.hoTen = this.hoTen.toUpperCase();
        System.out.print("+ Nhập ngày tháng năm sinh (dd/mm/yyyy):");
        String ngaySinh = CauHinh.SC.nextLine();
        this.ngaySinh = LocalDate.parse(ngaySinh, DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT));

        System.out.print("+ Nhập vào quê quán: ");
        this.queQuan = CauHinh.SC.nextLine();
        int choice;
        do {
            choice = NganHang.menu("1) Nam.\n2) Nữ.\n3) Giới tính khác.\n");

            switch (choice) {
                case 1:
                    this.gioiTinh = "Nam";
                    break;
                case 2:
                    this.gioiTinh = "Nữ";
                    break;
                case 3:
                    this.gioiTinh = "Khác";
                    break;
                default:
                    System.out.println("\nLựa chọn không hợp lệ! Nhấn Enter để nhập lại.\n");
                    CauHinh.SC.nextLine();
            }
        } while (choice != 1 && choice != 2 && choice != 3);
        this.matKhau = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
        this.soTaiKhoan = String.format("%s%d", this.ngaySinh.format(DateTimeFormatter.ofPattern("ddMMyyyy")), this.dem++);
        return new TaiKhoanKhongKyHan(this.hoTen, this.queQuan, this.gioiTinh, this.soCCCD, this.ngaySinh, this.matKhau);
    }

    @Override
    public void hienThi() {
        System.out.printf("+ Họ tên: %s\n+ Ngày sinh: %s\n+ Giới tính: %s\n+ Quê quán: %s\n+ Số CCCD: %s\n+ Ngày đăng ký: %s\n+ Số tài khoản: %s\n+ Số tiền: %f\n",
                this.hoTen, this.ngaySinh.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)), this.gioiTinh, this.queQuan,
                this.soCCCD, this.ngayDangKy.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)), this.soTaiKhoan, this.soTienGui);
    }

    @Override
    public void doiMatKhau() {
        int s1, s2;
        s1 = nhapMatKhau();
        do {
            System.out.print("* Nhập lại mật khẩu mới(Sáu số):");
            s2 = Integer.parseInt(CauHinh.SC.nextLine());
            if (s1 != s2) {
                System.out.print("+ Không trùng khớp! Mời nhâp lại.\n");
            }
        } while (s1 != s2);
        this.matKhau = s1;
        System.out.print("- ĐỔI MẬT KHẨU THÀNH CÔNG.\n");
    }

    @Override
    public void ghiThongTinVaoFile() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(CauHinh.DATA_FILE, true);
            try (PrintWriter xuatFile = new PrintWriter(fileWriter)) {
                xuatFile.printf("%s, %s, %s, %s, %s, Tài khoảng không kỳ hạn, %s, %s, %d, %.3f\n", this.hoTen, this.soCCCD,
                        this.ngaySinh.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                        this.queQuan, this.gioiTinh, this.ngayDangKy.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                        this.soTaiKhoan, this.matKhau, this.soTienGui);
            }
        } catch (IOException ex) {
            Logger.getLogger(TaiKhoanKhongKyHan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(TaiKhoanKhongKyHan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void suaThongTin() {
        int sua;
        do {
            sua = NganHang.menu("=== CHỌN THÔNG TIN CẦN CHỈNH SỬA ===\n"
                    + "1) Họ tên.\n2) Ngày sinh.\n3) Quê quán.\n4) Giới tính.\n5) Số cccd.\n6) Thông tin đã chính xác.\n"
                    + ">>Bạn chon: ");
            CauHinh.SC.nextLine();
            switch (sua) {
                case 1 -> {
                    System.out.println("+ SỬA HỌ TÊN:");
                    this.hoTen = nhapHoTen();
                }
                case 2 -> {
                    System.out.print("+ SỬA NGÀY THÁNG NĂM SINH:");
                    LocalDate s = nhapNgayThangNamSinh();
                }
                case 3 -> {
                    System.out.print("+ SỬA QUÊ QUÁN:");
                    this.hoTen = nhapQueQuan();
                }
                case 4 -> {
                    System.out.print("+ SỬA GIỚI TÍNH:");
                    this.gioiTinh = nhapGioiTinh();
                }
                case 5 -> {
                    System.out.print("+ SỬA SỐ CĂN CƯỚC CÔNG DÂN:");
                    this.soCCCD = nhapSoCCCD();
                }
                case 6 -> {
                    System.out.print("+ Thông tin của bạn đã được lưu.\n");
                }
                default -> {
                    System.out.println("\nLựa chọn không hợp lệ! Nhấn Enter để nhập lại.\n");
                    CauHinh.SC.nextLine();
                }

            }
        } while (sua > 0 & sua < 6);
    }

    @Override
    public void goiTien(double soTien) {
        this.soTienGui += soTien;
    }

    @Override
    public int rutTien(double soTien) {
        if (this.soTienGui >= soTien) {
            this.soTienGui += soTien;
            return 1;
        }
        return 0;
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
        return this.soTienGui * laiSuat * soNgayGui / 360;
    }

}
