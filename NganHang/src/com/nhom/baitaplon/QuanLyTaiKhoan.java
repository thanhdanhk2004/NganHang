/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom.baitaplon;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public TaiKhoan timKiem(String s) {
        for (TaiKhoan i : this.quanLyTaiKhoan) {
            if (i instanceof TaiKhoanKhongKyHan) {
                TaiKhoanKhongKyHan x = (TaiKhoanKhongKyHan) i;
                if (x.getSoCCCD().equalsIgnoreCase(s) || x.getSoTaiKhoan().equalsIgnoreCase(s)) {
                    return i;
                }
            }
        }
        return null;
    }

    public void moTaiKhoan(String s) {
        TaiKhoanKhongKyHan tkkkh = new TaiKhoanKhongKyHan();
        tkkkh.moTaiKhoan();
        tkkkh.setSoCCCD(s);
        this.quanLyTaiKhoan.add(tkkkh);
        System.out.print("+ Mở tài khoản thành công.\n");
        this.hienThiThongTinTaiKhoanKhachHang(tkkkh);
        tkkkh.suaThongTin();
        tkkkh.ghiThongTinVaoFile();
    }
    
    public TaiKhoanCoKyHan layDuLieuTuTaiKhoanKhongKyHan(TaiKhoanKhongKyHan tkkkh){
        TaiKhoanCoKyHan tkckh = new TaiKhoanCoKyHan();
        tkckh.setHoTen(tkkkh.getHoTen());
        tkckh.setSoCCCD(tkkkh.getSoCCCD());
        tkckh.setGioiTinh(tkkkh.getGioiTinh());
        tkckh.setQueQuan(tkkkh.getQueQuan());
        tkckh.setSoTaiKhoan(tkkkh.getSoTaiKhoan());
        tkckh.setNgayDangKy(LocalDate.now());
        tkckh.setNgaySinh(tkkkh.getNgaySinh());
        tkckh.setSoTienGui(0);
        tkckh.setMatKhau(tkkkh.getMatKhau());
        return tkckh;
    }
    
    public void moTaiKhoan(TaiKhoanKhongKyHan tkkkh) {
        TaiKhoanCoKyHan tkckh = new TaiKhoanCoKyHan();
        tkckh = this.layDuLieuTuTaiKhoanKhongKyHan(tkkkh);
        tkckh.moTaiKhoan();
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
        System.out.print("\n+ Bạn có muốn đổi mật khẩu hay không(y/n):");
        String luaChon = CauHinh.SC.nextLine();
        if (luaChon.equalsIgnoreCase("y")) {
            tkkkh.doiMatKhau();
        }
    }

    public void hienThiThongTin() {
        int dem = 0;
        for(TaiKhoan i: this.quanLyTaiKhoan){
            TaiKhoanKhongKyHan tkkkh = (TaiKhoanKhongKyHan) i;
            System.out.printf("\n\t\t Thông tin của khách hàng %s\n", tkkkh.getHoTen());
            i.hienThi();
        }
    }

    public List<TaiKhoan> locTaiKhoanTheoTien() {
        List<TaiKhoan> list = new ArrayList();
        for (TaiKhoan i : this.quanLyTaiKhoan) {
            double tong = 0;
            TaiKhoanKhongKyHan tkkkh = (TaiKhoanKhongKyHan) i;
            tong += tkkkh.getSoTienGui();
            for (TaiKhoanCoKyHan j : tkkkh.getQuanDanhSachTaiKhoanCoKyHan()) {
                tong += j.getSoTienGui();
            }
            tkkkh.setSoTienGui(tong);
            list.add(tkkkh);
        }
        return list;
    }

    public void sapXepThongTinTheoTienGiamDan(List<TaiKhoan> list) {
        list.sort((h1, h2) -> {
            TaiKhoanKhongKyHan t1 = (TaiKhoanKhongKyHan) h1;
            TaiKhoanKhongKyHan t2 = (TaiKhoanKhongKyHan) h2;
            double a = t1.getSoTienGui();
            double b = t2.getSoTienGui();
            if (a > b) {
                return -1;
            } else if (a < b) {
                return 1;
            }
            return 0;
        });
    }

    // Ham xuat tien cua khach hang dua tren so tai khoan duoc cung cap
    public double tinhTienLaiCuaKhachHang(String s) {
        double tienLai = 0;
        TaiKhoanKhongKyHan tkkkh = (TaiKhoanKhongKyHan) this.timKiem(s);
        if (tkkkh != null) {
            tienLai += tkkkh.tinhTienLai(0.2);
            for (TaiKhoanCoKyHan i : tkkkh.getQuanDanhSachTaiKhoanCoKyHan()) {
                tienLai += i.getThongTinKyHan().tinhTienLai();
            }
        }
        return tienLai;
    }

    // Ham them tien vao tai khoan
    public void guiTienVaoTaiKhoanChinh(String s, double soTien) {
        TaiKhoanKhongKyHan tkkkh = (TaiKhoanKhongKyHan) this.timKiem(s);
        tkkkh.goiTien(soTien);
    }

    public void rutTienKhoiTaiKhoanChinh(String s, double soTien) {
        TaiKhoanKhongKyHan tkkkh = (TaiKhoanKhongKyHan) this.timKiem(s);
        int rt = tkkkh.rutTien(soTien);
        if (rt == 1) {
            System.out.print("=== RÚT TIỀN THÀNH CÔNG ===\n");
        } else {
            System.out.print("=== RÚT TIỀN THẤT BẠI ===\n");
        }
    }

    public void moTaiKhoanCoKyHan(TaiKhoanKhongKyHan tkkkh) {
        if (tkkkh.getSoTienGui() < 150000) {
            System.out.print("=== BẠN KHÔNG ĐỦ SỐ DƯ ĐỂ MỞ TÀI KHOẢN CÓ KỲ HẠN ===\n");
        } else {
            this.moTaiKhoan(tkkkh);
            tkkkh.setSoTienGui(tkkkh.getSoTienGui() - 100000);
            System.out.print("=== MỞ TÀI KHOẢN THÀNH CÔNG ===\n");
        }

    }

    // Hàm Tra cứu danh sách tài khoản của một khách hàng theo mã số khách hàng
    public void traCuuDanhSachKhachHang(String s) {
        for (TaiKhoan i : this.quanLyTaiKhoan) {
            TaiKhoanKhongKyHan tkkkh = (TaiKhoanKhongKyHan) i;
            if (tkkkh.getSoTaiKhoan().equals(s)) {
                tkkkh.hienThi();
                if (!tkkkh.getQuanDanhSachTaiKhoanCoKyHan().isEmpty()) {
                    System.out.print("* Tài khoản của khách hàng " + tkkkh.getHoTen() + " có thêm " + tkkkh.getQuanDanhSachTaiKhoanCoKyHan().size() + "tài khoản có kỳ hạn.\n");
                    for (TaiKhoanCoKyHan j : tkkkh.getQuanDanhSachTaiKhoanCoKyHan()) {
                        j.getThongTinKyHan().hienThiThongTinKyHan();
                    }
                }
            }
        }
    }

    //  Tra cứu khách hàng theo họ tên và mã số khách hàng.
    public List<TaiKhoan> traCuuTaiKhoan(String s) {
        List<TaiKhoan> danhSachTaiKhoan = new ArrayList();
        for (TaiKhoan i : this.quanLyTaiKhoan) {
            if (i instanceof TaiKhoanKhongKyHan x) {
                if (x.getSoTaiKhoan().equalsIgnoreCase(s) || x.getHoTen().contains(s)) {
                    danhSachTaiKhoan.add(i);
                }
            }
        }
        return danhSachTaiKhoan;
    }

    // Hàm đăng ký
    public void dangKy() {
        String s = CauHinh.nhapSoCCCD();
        if (this.timKiem(s) != null) {
            System.out.print("* Sô căn cước công dân đã được đăng ký!\n");
        } else {
            this.moTaiKhoan(s);
        }
    }
    
    public boolean kiemTraMatKhau(int mk){
        for(TaiKhoan i:this.quanLyTaiKhoan){
            if(i instanceof TaiKhoanKhongKyHan){
                TaiKhoanKhongKyHan tkkkh = (TaiKhoanKhongKyHan) i;
                if(tkkkh.getMatKhau() == mk){
                    return true;
                } 
            }
        }
        return false;
    }
    
    public boolean dangNhap() {
        String stk;
        do{
            System.out.print("+ Nhập vào số tài khoản:");
            stk = CauHinh.SC.nextLine();
            if(this.timKiem(stk) == null)
                 System.out.print("* Sai số tài khoản! Mời kiểm tra lại.\n");
        }while(this.timKiem(stk) == null);
        int dem=0, mk;
        do{
            System.out.print("+ Nhập vào mật khẩu:");
            mk = CauHinh.nhapMatKhau();
            if(this.kiemTraMatKhau(mk) == false){
                System.out.print("* Sai mật khẩu! Mời nhập lại.\n");
                dem++;
            }
        }while(this.kiemTraMatKhau(mk) == false && dem<3);
        if(dem == 3 && this.kiemTraMatKhau(mk) == false){
            TaiKhoanKhongKyHan tkkkh = (TaiKhoanKhongKyHan) this.timKiem(stk);
            tkkkh.setTrangThai(false);
            System.out.print("* Tài khoản của bạn đã bị khóa! Vui lòng liên hệ với ngân hàng gần bạn nhât.\n");
        }
        else
            System.out.print("* === ĐĂNG NHẬP THÀNH CÔNG ===\n");
        return false;
    }
    
    public void docDuLieuKhachHang() throws FileNotFoundException{
        try (Scanner file = new Scanner(CauHinh.DATA_FILE)) {
            String s;
            int dem = 0;
            while(file.hasNext()){
                s = file.nextLine();
                if(s == "")
                    break;
                else{
                    String str[] = s.split(",");
                    if(str[5].trim().equalsIgnoreCase("tai khoan co ky han")){
                        TaiKhoanKhongKyHan tkkkh2 = (TaiKhoanKhongKyHan) this.timKiem(str[1].trim());
                        TaiKhoanCoKyHan tkckh = this.layDuLieuTuTaiKhoanKhongKyHan(tkkkh2);
                        tkkkh2.getQuanDanhSachTaiKhoanCoKyHan().add(tkckh);
                    }
                    else{
                        TaiKhoanKhongKyHan tkkkh = new TaiKhoanKhongKyHan();
                        tkkkh.setHoTen(str[dem++].trim());
                        tkkkh.setSoCCCD(str[dem++].trim());
                        tkkkh.setNgaySinh(LocalDate.parse(str[dem++].trim(), DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)));
                        tkkkh.setQueQuan(str[dem++].trim());
                        tkkkh.setGioiTinh(str[dem++].trim());     
                        tkkkh.setNgayDangKy(LocalDate.parse(str[++dem].trim(), DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)));
                        tkkkh.setSoTaiKhoan(str[++dem].trim());
                        tkkkh.setMatKhau(Integer.parseInt(str[++dem].trim()));
                        tkkkh.setSoTienGui(Double.parseDouble(str[++dem].trim()));
                        if(str[++dem].trim().equalsIgnoreCase("true"))
                            tkkkh.setTrangThai(true);
                        else
                            tkkkh.setTrangThai(false);
                        this.quanLyTaiKhoan.add(tkkkh);
                    }
                }
                dem = 0;
            }
            file.close();
        }
    }
}
