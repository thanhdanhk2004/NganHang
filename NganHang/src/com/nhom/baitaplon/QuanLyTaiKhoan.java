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
public class QuanLyTaiKhoan{
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
                if(x.getSoCCCD().equalsIgnoreCase(s) || x.getSoTaiKhoan().equalsIgnoreCase(s))
                    return i;
            }
        }
        return null;
    }
    public void moTaiKhoan(String s){
        TaiKhoanKhongKyHan tkkkh = new TaiKhoanKhongKyHan();
        tkkkh.moTaiKhoan();
        this.quanLyTaiKhoan.add(tkkkh);
        System.out.print("+ Mở tài khoản thành công.\n");
        this.hienThiThongTinTaiKhoanKhachHang(tkkkh);
        //tkkkh.suaThongTin();
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
        tkkkh.getQuanDanhSachTaiKhoanCoKyHan().add(tkckh);
        System.out.print("+ Mo tai khoan thanh cong.\n");
        this.hienThiThongTinTaiKhoanKhachHang(tkckh);
        tkckh.ghiThongTinVaoFile();
    }
    public void hienThiThongTinTaiKhoanKhachHang(TaiKhoanKhongKyHan tkkkh){
        System.out.print("\n\t\t Thông tin của bạn như sau\n");
        tkkkh.hienThi();
        System.out.printf("+ Mật khẩu: %d", tkkkh.getMatKhau());
        this.xacNhanDoiMatKhau(tkkkh);
    }
    public void xacNhanDoiMatKhau(TaiKhoanKhongKyHan tkkkh){
        CauHinh.input.nextLine();
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
    
    public List<TaiKhoan> locTaiKhoanTheoTien(){
        List<TaiKhoan> list = new ArrayList();
        int dem = 0;
        for(TaiKhoan i:this.quanLyTaiKhoan){
            double tong = 0;
            TaiKhoanKhongKyHan tkkkh = (TaiKhoanKhongKyHan) i;
            tong += tkkkh.getSoTienGui();
            for(TaiKhoanCoKyHan j:tkkkh.getQuanDanhSachTaiKhoanCoKyHan()){
                tong += j.getSoTienGui();
            }
            tkkkh.setSoTienGui(tong);
            list.add(tkkkh);
        }
        return list;
    }
    public void sapXepThongTinTheoTienGiamDan(List<TaiKhoan> list){
        list.sort((h1,h2)->{
            TaiKhoanKhongKyHan t1 = (TaiKhoanKhongKyHan) h1;
            TaiKhoanKhongKyHan t2 = (TaiKhoanKhongKyHan) h2;
            double a =t1.getSoTienGui();
            double b = t2.getSoTienGui();
            if(a > b)
                return -1;
            else if(a < b)
                return 1;
            return 0;
        });
    }
    public double tinhTienLaiCuaKhachHang(String s){
        double tienLai = 0;
        TaiKhoanKhongKyHan tkkkh = (TaiKhoanKhongKyHan) this.timKiem(s);
        if(tkkkh != null){
            tienLai += tkkkh.tinhTienLai(0.2);
            for(TaiKhoanCoKyHan i: tkkkh.getQuanDanhSachTaiKhoanCoKyHan())
                i.getKyHan().tinhTienLai(tienLai);
        }
        return tienLai;
    }
}
