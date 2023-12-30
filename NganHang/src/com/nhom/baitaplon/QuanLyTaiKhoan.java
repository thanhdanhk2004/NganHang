/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom.baitaplon;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author add
 */
public class QuanLyTaiKhoan {
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
        if(this.timKiem(s) != null){
            System.out.print("+ Bạn đã có tài khoản không kỳ hạn của ngân hàng.\n");
            System.out.print("+ Bạn có muốn tạo tài khoản có kỳ hạn không(y/n):");
            String luaChon = CauHinh.input.nextLine();
            if(luaChon.equalsIgnoreCase("y")){
                TaiKhoanKhongKyHan tk = (TaiKhoanKhongKyHan) this.timKiem(s);
                tk = new TaiKhoanCoKyHan();
                tk.moTaiKhoan();
                this.quanLyTaiKhoan.add(tk);
                System.out.print("+ Mo tai khoan thanh cong.\n");
                this.hienThiThongTinTaiKhoanKhachHang(tk);
            }
        }
        else{
            TaiKhoanKhongKyHan tkkkh = new TaiKhoanKhongKyHan();
            TaiKhoan tk = tkkkh.moTaiKhoan();
            this.quanLyTaiKhoan.add(tk);
            System.out.print("+ Mo tai khoan thanh cong.\n");
            this.hienThiThongTinTaiKhoanKhachHang(tkkkh);
            tkkkh.ghiThongTinVaoFile();
        }
        
    }
    public void hienThiThongTinTaiKhoanKhachHang(TaiKhoanKhongKyHan tkkkh){
        System.out.print("\n\t\t Thông tin của bạn như sau\n");
        tkkkh.hienThi();
        System.out.printf("+ Mật khẩu: %d", tkkkh.getMatKhau());
        this.xacNhanDoiMatKhau(tkkkh);
    }
    public void xacNhanDoiMatKhau(TaiKhoanKhongKyHan tkkkh){
        System.out.print("+ Bạn có muốn đổi mật khẩu hay không(y/n):");
        String luaChon = CauHinh.input.nextLine();
        if(luaChon.equalsIgnoreCase("y")){
            tkkkh.doiMatKhau();
            return;
        }   
        return;
    }
    
}
