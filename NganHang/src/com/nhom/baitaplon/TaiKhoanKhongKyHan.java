/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom.baitaplon;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

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
    private double soTienGui;
    private int matKhau;
    private LocalDate ngayDangKy = LocalDate.now();
    private String soTaiKhoan = "";
    private List<TaiKhoanCoKyHan> quanDanhSachTaiKhoanCoKyHan = new ArrayList();
    private boolean trangThai;
    private static double laiSuatKhongKyHan = 0.002;

    public TaiKhoanKhongKyHan(String hoTen, String queQuan, String gioiTinh, String soCCCD, LocalDate ngaySinh, int matKhau, double soTien) {
        this.hoTen = hoTen;
        this.queQuan = queQuan;
        this.gioiTinh = gioiTinh;
        this.soCCCD = soCCCD;
        this.ngaySinh = ngaySinh;
        this.matKhau = matKhau;
        this.trangThai = true;
        this.soTienGui = soTien;
        this.soTaiKhoan = String.format("%s%04d", this.ngaySinh.format(DateTimeFormatter.ofPattern("ddMMyyyy")), TaiKhoanKhongKyHan.dem++);
        this.trangThai = true;
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
        return this.ngayDangKy;
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

    /**
     * @return the laiSuatKhongKyHan
     */
    public static double getLaiSuatKhongKyHan() {
        return laiSuatKhongKyHan;
    }

    /**
     * @return the trangThai
     */
    public boolean isTrangThai() {
        return trangThai;
    }

    /**
     * @param trangThai the trangThai to set
     */
    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
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
    public TaiKhoanKhongKyHan moTaiKhoan() {
        System.out.print("=== THÔNG TIN CÁ NHÂN ===\n");
        this.hoTen = CauHinh.nhapHoTen();
        this.ngaySinh = CauHinh.nhapNgayThangNamSinh();
        this.queQuan = CauHinh.nhapQueQuan();
        int choice;
        do {
            choice = CauHinh.menu("1) Nam.\n2) Nữ.\n3) Giới tính khác.\n- Nhập lựa chọn của bạn:");

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
        this.soTienGui = CauHinh.nhapSoTien();
        return new TaiKhoanKhongKyHan(this.hoTen, this.queQuan, this.gioiTinh, this.soCCCD, this.ngaySinh, this.matKhau, this.soTienGui);
    }

    @Override
    public void hienThi() {
        System.out.println("\n\n");
        System.out.printf("+ Họ tên: %s\n+ Ngày sinh: %s\n+ Giới tính: %s\n+ Quê quán: %s\n+ Số CCCD: %s\n+ Ngày đăng ký: %s\n+ Số tài khoản: %s\n+ Số tiền: %.3f\n",
                this.hoTen, this.ngaySinh.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)), this.gioiTinh, this.queQuan,
                this.soCCCD, this.ngayDangKy.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)), this.soTaiKhoan, this.soTienGui);
        if (this.isTrangThai() == true) {
            System.out.print("+ Trạng thái: Không bị khóa.\n");
        } else {
            System.out.print("+ Trạng thái: Bị khóa.\n");
        }
    }

    @Override
    public void doiMatKhau() {
        int s1, s2;
        s1 = CauHinh.nhapMatKhau();
        do {
            System.out.println("Xác nhận mật khẩu:");
            s2 = CauHinh.nhapMatKhau();
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
                String matKhauMaHoa = CauHinh.maHoaMatKhau(Integer.toString(this.getMatKhau()));
                xuatFile.printf("%s, %s, %s, %s, %s, Tài khoản không kỳ hạn, %s, %s, %s, %.3f,", this.hoTen, this.soCCCD,
                        this.ngaySinh.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                        this.queQuan, this.gioiTinh, this.ngayDangKy.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                        this.soTaiKhoan, matKhauMaHoa, this.soTienGui);
                if (this.isTrangThai() == true) {
                    xuatFile.printf("true");
                } else {
                    xuatFile.printf("false");
                }
            } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
                Logger.getLogger(TaiKhoanKhongKyHan.class.getName()).log(Level.SEVERE, null, ex);
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
            sua = CauHinh.menu("=== CHỌN THÔNG TIN CẦN CHỈNH SỬA ===\n"
                    + "1) Họ tên.\n2) Ngày sinh.\n3) Quê quán.\n4) Giới tính.\n5) Số cccd.\n6) Thông tin đã chính xác.\n"
                    + ">>Bạn chon: ");
            CauHinh.SC.nextLine();
            switch (sua) {
                case 1 -> {
                    System.out.println("+ SỬA HỌ TÊN:");
                    this.hoTen = CauHinh.nhapHoTen();
                    break;
                }
                case 2 -> {
                    System.out.print("+ SỬA NGÀY THÁNG NĂM SINH:");
                    this.ngaySinh = CauHinh.nhapNgayThangNamSinh();
                    break;
                }
                case 3 -> {
                    System.out.print("+ SỬA QUÊ QUÁN:");
                    this.hoTen = CauHinh.nhapQueQuan();
                    break;
                }
                case 4 -> {
                    System.out.print("+ SỬA GIỚI TÍNH:");
                    this.gioiTinh = CauHinh.nhapGioiTinh();
                    break;
                }
                case 5 -> {
                    System.out.print("+ SỬA SỐ CĂN CƯỚC CÔNG DÂN:");
                    this.soCCCD = CauHinh.nhapSoCCCD();
                    break;
                }
                case 6 -> {
                    System.out.print("+ Thông tin của bạn đã được lưu.\n");
                    break;
                }
                default -> {
                    System.out.println("\nLựa chọn không hợp lệ! Nhấn Enter để nhập lại.\n");
                    CauHinh.SC.nextLine();
                }
            }
        } while (sua != 6);
    }

    @Override
    public void goiTien(double soTien) {
        this.soTienGui += soTien;
        System.out.printf("Bạn đã gửi %f đồng và tài khoản!\n", soTien);
    }

    @Override
    public boolean rutTien(double soTien) {
        if (this.soTienGui >= soTien) {
            this.soTienGui -= soTien;
            return true;
        }
        return false;
    }

    @Override
    public double tinhTienLai() {
        int soNgayGui = (int) ChronoUnit.DAYS.between(this.ngayDangKy, LocalDate.now());
        return (this.soTienGui * TaiKhoanKhongKyHan.laiSuatKhongKyHan * soNgayGui) * 1.0 / 360;
    }

    public void rutTienTaiKhoanCoKyHan() {
        String choice;
        int ch;
        do {
            System.err.println("=== CHỌN TÀI KHOẢN MUỐN RÚT ===");
            for (int i = 0; i < this.quanDanhSachTaiKhoanCoKyHan.size(); i++) {
                System.out.printf("Tài khoản %d\n", i + 1);
                this.quanDanhSachTaiKhoanCoKyHan.get(i).hienThi();
            }
            System.out.print(">>Ban chọn tài khoản số: ");
            choice = CauHinh.SC.nextLine();
            if (choice.matches("[0-9]+")) {
                ch = Integer.parseInt(choice);
            } else {
                ch = 0;
            }
            if (ch >= 1 && ch <= this.quanDanhSachTaiKhoanCoKyHan.size()) {
                if (this.quanDanhSachTaiKhoanCoKyHan.get(ch - 1).xacNhanRutTien()) {
                    TaiKhoanCoKyHan tkckh = this.quanDanhSachTaiKhoanCoKyHan.get(ch - 1);
                    this.soTienGui += ((ChronoUnit.DAYS.between(tkckh.getNgayDangKy(), LocalDate.now()) * tkckh.getSoTienGui() * (TaiKhoanKhongKyHan.laiSuatKhongKyHan)) * 1.0 / 365) + tkckh.getSoTienGui();
                    this.quanDanhSachTaiKhoanCoKyHan.remove(ch - 1);
                }
            } else {
                System.out.println("\nLựa chọn không hợp lệ! Nhấn Enter để nhập lại.\n");
                CauHinh.SC.nextLine();
            }
        } while ((ch < 1 || ch > this.quanDanhSachTaiKhoanCoKyHan.size() + 1));
    }

}
