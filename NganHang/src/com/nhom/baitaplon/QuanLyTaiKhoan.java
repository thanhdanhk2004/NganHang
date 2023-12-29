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
    public boolean timKiem(String s){
        for(TaiKhoan i: this.quanLyTaiKhoan){
            if(i instanceof TaiKhoanKhongKyHan){
                TaiKhoanKhongKyHan x = (TaiKhoanKhongKyHan)i;
                if(x.getSoCCCD().equalsIgnoreCase(s))
                    return false;
            }
        }
        return true;
    }
    
    public void moTaiKhoan(String s){
        if(this.timKiem(s) == false){
            System.out.print("+ Bạn đã có tài khoản không kỳ hạn của ngân hàng nêu bạn muốn tạo tài khoản có kỳ hạn thì nhấn phím 2.\n");
        }
        else{
            TaiKhoanKhongKyHan tkkkh = new TaiKhoanKhongKyHan();
            TaiKhoan tk = tkkkh.moTaiKhoan();
            this.quanLyTaiKhoan.add(tk);
            System.out.print("+ Mo tai khoan thanh cong.\n");
            this.hienThiThongTinTaiKhoanKhachHang(tkkkh);
        }
    }
    public void hienThiThongTinTaiKhoanKhachHang(TaiKhoanKhongKyHan tkkkh){
        System.out.print("\n\t\t Thông tin của bạn như sau\n");
        tkkkh.hienThi();
        System.out.printf("+ Mật khẩu: %d", tkkkh.getMatKhau());
    }
    public void doiMatKhau(TaiKhoanKhongKyHan tkkkh){
        
    }
}
