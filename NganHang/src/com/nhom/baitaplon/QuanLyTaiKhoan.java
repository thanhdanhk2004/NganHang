/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom.baitaplon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author add
 */
public class QuanLyTaiKhoan implements Cloneable {

    private List<TaiKhoan> quanLyTaiKhoan = new ArrayList();

    /**
     * @return the quanLyTaiKhoan
     */
    public List<TaiKhoan> getQuanLyTaiKhoan() {
        return quanLyTaiKhoan;
    }

    /**
     * @param quanLyTaiKhoan the quanLyTaiKhoan to set
     */
    public void setQuanLyTaiKhoan(List<TaiKhoan> quanLyTaiKhoan) {
        this.quanLyTaiKhoan = quanLyTaiKhoan;
    }

    public TaiKhoan timKiem(String s) {
        for (TaiKhoan i : this.quanLyTaiKhoan) {
            if (i instanceof TaiKhoanKhongKyHan x) {
                if (x.getSoCCCD().equalsIgnoreCase(s)) {
                    return i;
                }
            }
        }
        return null;
    }

    public void moTaiKhoan(String s) {
        TaiKhoanKhongKyHan tkkkh = new TaiKhoanKhongKyHan();
        tkkkh.moTaiKhoan();
        this.quanLyTaiKhoan.add(tkkkh);
        System.out.print("+ Mở tài khoản thành công.\n");
        this.hienThiThongTinTaiKhoanKhachHang(tkkkh);
        //tkkkh.suaThongTin();
        //tkkkh.ghiThongTinVaoFile();
    }

    public void moTaiKhoan(TaiKhoanKhongKyHan tkkkh) {
        TaiKhoanCoKyHan tkckh = new TaiKhoanCoKyHan();
        tkckh.moTaiKhoan();
        tkckh.setHoTen(tkkkh.getHoTen());
        tkckh.setSoCCCD(tkkkh.getSoCCCD());
        tkckh.setGioiTinh(tkkkh.getGioiTinh());
        tkckh.setQueQuan(tkkkh.getQueQuan());
        tkckh.setSoTaiKhoang(tkkkh.getSoTaiKhoan());
        tkckh.setNgayDangKy(LocalDate.now());
        tkckh.setNgaySinh(tkkkh.getNgaySinh());
        tkckh.setSoTienGui(0);
        tkckh.setMatKhau(tkkkh.getMatKhau());
        this.quanLyTaiKhoan.add(tkckh);
        System.out.print("+ Mo tai khoan thanh cong.\n");
        this.hienThiThongTinTaiKhoanKhachHang(tkckh);
        tkckh.ghiThongTinVaoFile();
    }

    public void hienThiThongTinTaiKhoanKhachHang(TaiKhoanKhongKyHan tkkkh) {
        System.out.print("\n\t\t Thông tin của bạn như sau\n");
        tkkkh.hienThi();
        System.out.printf("+ Mật khẩu: %d", tkkkh.getMatKhau());
        this.xacNhanDoiMatKhau(tkkkh);
    }

    public void xacNhanDoiMatKhau(TaiKhoanKhongKyHan tkkkh) {
        CauHinh.SC.nextLine();
        String luaChon;
        do {
            System.out.print("\n+ Bạn có muốn đổi mật khẩu hay không(y/n):");
            luaChon = CauHinh.SC.nextLine();
            if (!luaChon.equalsIgnoreCase("y") && !luaChon.equalsIgnoreCase("n")) {
                System.out.println("Lua chon khong hop le! Vui long chon lai:");
            }
        } while (!luaChon.equalsIgnoreCase("y") && !luaChon.equalsIgnoreCase("n"));

            if (luaChon.equalsIgnoreCase("y")) {

                tkkkh.doiMatKhau();
            }
        }

    public void hienThiThongTin() {
        this.quanLyTaiKhoan.stream().forEach(h -> h.hienThi());
    }
}
