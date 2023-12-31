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
public class QuanLyTaiKhoan implements Cloneable{
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
    public TaiKhoan timKiem(String s){
        for(TaiKhoan i: this.quanLyTaiKhoan){
            if(i instanceof TaiKhoanKhongKyHan){
                TaiKhoanKhongKyHan x = (TaiKhoanKhongKyHan)i;
                if(x.getSoCCCD().equalsIgnoreCase(s))
                    return i;
            }
        }
        return null;
    }
    public void moTaiKhoan(String s){
        TaiKhoanKhongKyHan tkkkh = new TaiKhoanKhongKyHan();
        TaiKhoan tk = tkkkh.moTaiKhoan();
        this.quanLyTaiKhoan.add(tk);
        System.out.print("+ Mo tai khoan thanh cong.\n");
        tk.hienThi();
        this.hienThiThongTinTaiKhoanKhachHang(tkkkh);
        //tkkkh.ghiThongTinVaoFile();
    }
    public void moTaiKhoan(TaiKhoanKhongKyHan tkkkh){
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
        TaiKhoan tk = tkckh;
        this.quanLyTaiKhoan.add(tk);
        System.out.print("+ Mo tai khoan thanh cong.\n");
        this.hienThiThongTinTaiKhoanKhachHang(tkckh);
        tkkkh.ghiThongTinVaoFile();
    }
    public void hienThiThongTinTaiKhoanKhachHang(TaiKhoanKhongKyHan tkkkh){
        System.out.print("\n\t\t Thông tin của bạn như sau\n");
        System.out.print(tkkkh.getSoTaiKhoan());
        System.out.printf("+ Mật khẩu: %d", tkkkh.getMatKhau());
        this.xacNhanDoiMatKhau(tkkkh);
    }
    public void xacNhanDoiMatKhau(TaiKhoanKhongKyHan tkkkh){
        System.out.print("\n+ Bạn có muốn đổi mật khẩu hay không(y/n):");
        String luaChon = CauHinh.input.nextLine();
        if(luaChon.equalsIgnoreCase("y")){
            tkkkh.doiMatKhau();
            return;
        }   
        return;
    }
    public void hienThiThongTin(){
        this.quanLyTaiKhoan.stream().forEach(h -> h.hienThi());
    }
}
