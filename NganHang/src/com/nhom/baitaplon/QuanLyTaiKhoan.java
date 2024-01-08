/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom.baitaplon;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

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

    public void moTaiKhoan() {
        String soCCCD = CauHinh.nhapSoCCCD();
        if (this.timKiem(soCCCD) != null) {
            System.out.print("+ Tài khoản đã tồn tại!\n");
        } else {
            TaiKhoanKhongKyHan tkkkh = new TaiKhoanKhongKyHan();
            tkkkh = tkkkh.moTaiKhoan();
            tkkkh.setSoCCCD(soCCCD);
            this.quanLyTaiKhoan.add(tkkkh);
            System.out.print("+ Mở tài khoản thành công.\n");
            this.hienThiThongTinTaiKhoanKhachHang(tkkkh);
            System.out.printf("\n+ Mật khẩu: %d", tkkkh.getMatKhau());
            this.xacNhanDoiMatKhau(tkkkh);
            tkkkh.suaThongTin();
            tkkkh.ghiThongTinVaoFile();
        }
    }

    public void moTaiKhoan(TaiKhoanKhongKyHan tkkkh) {
        TaiKhoanCoKyHan tkckh = new TaiKhoanCoKyHan();
        tkckh = this.layDuLieuTuTaiKhoanKhongKyHan(tkkkh);
        tkckh.moTaiKhoan();
        this.hienThiThongTinTaiKhoanKhachHang(tkckh);
        tkkkh.getQuanDanhSachTaiKhoanCoKyHan().add(tkckh);
        //tkckh.ghiThongTinVaoFile();
    }

    public TaiKhoanCoKyHan layDuLieuTuTaiKhoanKhongKyHan(TaiKhoanKhongKyHan tkkkh) {
        TaiKhoanCoKyHan tkckh = new TaiKhoanCoKyHan();
        tkckh.setHoTen(tkkkh.getHoTen());
        tkckh.setSoCCCD(tkkkh.getSoCCCD());
        tkckh.setGioiTinh(tkkkh.getGioiTinh());
        tkckh.setQueQuan(tkkkh.getQueQuan());
        tkckh.setSoTaiKhoan(tkkkh.getSoTaiKhoan());
        tkckh.setNgaySinh(tkkkh.getNgaySinh());
        tkckh.setMatKhau(tkkkh.getMatKhau());
        return tkckh;
    }

    public void moTaiKhoanCoKyHan(TaiKhoanKhongKyHan tkkkh) {
        Double soTienGui = CauHinh.nhapSoTien();
        if (tkkkh.getSoTienGui() < 150000 || soTienGui < 100000) {
            System.out.print("=== BẠN KHÔNG ĐỦ SỐ DƯ ĐỂ MỞ ===\n");
        } else {
            tkkkh.setSoTienGui(tkkkh.getSoTienGui() - soTienGui);
            TaiKhoanCoKyHan tkckh = new TaiKhoanCoKyHan();
            tkckh = this.layDuLieuTuTaiKhoanKhongKyHan(tkkkh);
            tkckh.setSoTienGui(soTienGui);
            tkckh.setNgayDangKy(LocalDate.now());
            tkckh.moTaiKhoan();
            this.hienThiThongTinTaiKhoanKhachHang(tkckh);
            tkkkh.getQuanDanhSachTaiKhoanCoKyHan().add(tkckh);
            System.out.print("=== MỞ TÀI KHOẢN THÀNH CÔNG ===\n");
        }
    }

    public void hienThiThongTinTaiKhoanKhachHang(TaiKhoanKhongKyHan tkkkh) {
        System.out.print("\n\t\t Thông tin của bạn như sau\n");
        tkkkh.hienThi();
    }

    public void xacNhanDoiMatKhau(TaiKhoanKhongKyHan tkkkh) {
        CauHinh.SC.nextLine();
        int luaChon = CauHinh.menu("Bạn có muốn đổi mật khẩu không?\n1) Có\n2) Không\n>>Bạn chon: ");
        switch (luaChon) {
            case 1 -> {
                tkkkh.doiMatKhau();
                break;
            }
            case 2 -> {
                break;
            }
            default -> {
                System.out.println("\nLựa chọn không hợp lệ! Nhấn Enter để nhập lại.\n");
                CauHinh.SC.nextLine();
            }
        }
    }

    public void hienThiThongTin() {
        int dem = 0;
        for (TaiKhoan i : this.quanLyTaiKhoan) {
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

    public List<TaiKhoan> sapXepThongTinTheoTienGiamDan(List<TaiKhoan> list) {
        list.sort((var h1, var h2) -> {
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
        return list;
    }

    // Ham xuat tien cua khach hang dua tren so tai khoan duoc cung cap
    public double tinhTienLaiCuaKhachHang(String s) {
        double tienLai = 0;
        TaiKhoanKhongKyHan tkkkh = (TaiKhoanKhongKyHan) this.timKiem(s);
        if (tkkkh != null) {
            tienLai += tkkkh.tinhTienLai();
            for (TaiKhoanCoKyHan i : tkkkh.getQuanDanhSachTaiKhoanCoKyHan()) {
                tienLai += i.getThongTinKyHan().tinhTienLai(i.getSoTienGui());
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
        if (tkkkh.rutTien(soTien)) {
            System.out.print("=== RÚT TIỀN THÀNH CÔNG ===\n");
        } else {
            System.out.print("=== TÀI KHOẢN CỦA QUÝ KHÁCH KHÔNG ĐỦ ĐỂ GIAO DỊCH ===\n");
        }
    }

    // Hàm Tra cứu danh sách tài khoản của một khách hàng theo mã số khách hàng
    public void traCuuDanhSachKhachHang(String s) {
        for (TaiKhoan i : this.quanLyTaiKhoan) {
            TaiKhoanKhongKyHan tkkkh = (TaiKhoanKhongKyHan) i;
            if (tkkkh.getSoTaiKhoan().equals(s)) {
                tkkkh.hienThi();
                if (!tkkkh.getQuanDanhSachTaiKhoanCoKyHan().isEmpty()) {
                    System.out.print("\n\n* Tài khoản của khách hàng " + tkkkh.getHoTen() + " có thêm " + tkkkh.getQuanDanhSachTaiKhoanCoKyHan().size() + " tài khoản có kỳ hạn.\n");
                    for (TaiKhoanCoKyHan j : tkkkh.getQuanDanhSachTaiKhoanCoKyHan()) {
                        j.hienThi();
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
                if (x.getSoTaiKhoan().equalsIgnoreCase(s) || x.getHoTen().contains(s) || x.getHoTen().equalsIgnoreCase(s)) {
                    danhSachTaiKhoan.add(i);
                }
            }
        }
        return danhSachTaiKhoan;
    }

    public boolean kiemTraMatKhau(TaiKhoanKhongKyHan tk, int mk) {
        if (tk.getMatKhau() == mk) {
            return true;
        }
        return false;
    }

    public TaiKhoanKhongKyHan dangNhap() {
        String stk;
        TaiKhoanKhongKyHan tkkkh;
        do {
            stk = CauHinh.nhapSTK();
            tkkkh = (TaiKhoanKhongKyHan) this.timKiem(stk);
            if (tkkkh == null) {
                System.out.print("* Sai số tài khoản! Enter để kiểm tra lại.\n");
                CauHinh.SC.nextLine();
            } else if (tkkkh.isTrangThai() == false) {
                System.out.println("* Tài khoản của bạn đã bị khóa! Vui lòng liên hệ với ngân hàng gần bạn nhất.");
                return null;
            } else {
                System.out.println("Xin chào " + tkkkh.getHoTen());
            }
        } while (this.timKiem(stk) == null);
        int dem = 0, mk;
        do {
            mk = CauHinh.nhapMatKhau();
            if (this.kiemTraMatKhau(tkkkh, mk) == false) {
                dem++;
                System.out.printf("* Sai mật khẩu! Bạn còn %d lần nhập.\n", 3 - dem);
            }
        } while (this.kiemTraMatKhau(tkkkh, mk) == false && dem < 3);
        if (dem == 3 && this.kiemTraMatKhau(tkkkh, mk) == false) {
            tkkkh.setTrangThai(false);
            System.out.print("* Tài khoản của bạn đã bị khóa! Vui lòng liên hệ với ngân hàng gần bạn nhất.\n");
            return null;
        } else {
            System.out.print("* === ĐĂNG NHẬP THÀNH CÔNG ===\n");
            return tkkkh;
        }
    }

    public String layClassPath(String s) {
        for (int i = 0; i < KyHan.getArrLKH().size(); i++) {
            if (KyHan.getArrLKH().get(i).getTen().equalsIgnoreCase(s)) {
                return KyHan.getArrLKH().get(i).getDoiTuong();
            }
        }
        return "";
    }

    public void docDuLieuKhachHang() throws FileNotFoundException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        try (Scanner file = new Scanner(CauHinh.DATA_FILE)) {
            String s;
            int dem = 0;
            while (file.hasNext()) {
                s = file.nextLine();

                if (s.equals("")) {
                    break;
                } else {
                    String str[] = s.split(",");
                    if (str[5].trim().equalsIgnoreCase("tài khoản có kỳ hạn")) {
                        TaiKhoanKhongKyHan tkkkh2 = (TaiKhoanKhongKyHan) this.timKiem(str[1].trim());
                        TaiKhoanCoKyHan tkckh = this.layDuLieuTuTaiKhoanKhongKyHan(tkkkh2);
                        tkckh.setSoTienGui(Double.parseDouble(str[9].trim()));
                        tkckh.setNgayDangKy(LocalDate.parse(str[6].trim(), DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)));
                        String s1 = layClassPath(str[11].trim());
                        String classPath = "com.nhom.baitaplon." + s1;
                        Class c = Class.forName(classPath);
                        KyHan kyHan = (KyHan) c.getConstructor().newInstance();
                        tkckh.setThongTinKyHan(kyHan);
                        tkckh.setNgayDaoHan(tkckh.getThongTinKyHan().tinhNgayDaoHan(tkckh.getNgayDangKy()));
                        tkkkh2.getQuanDanhSachTaiKhoanCoKyHan().add(tkckh);
                    } else {
                        TaiKhoanKhongKyHan tkkkh = new TaiKhoanKhongKyHan();
                        tkkkh.setHoTen(str[dem++].trim());
                        tkkkh.setSoCCCD(str[dem++].trim());
                        tkkkh.setNgaySinh(LocalDate.parse(str[dem++].trim(), DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)));
                        tkkkh.setQueQuan(str[dem++].trim());
                        tkkkh.setGioiTinh(str[dem++].trim());
                        tkkkh.setNgayDangKy(LocalDate.parse(str[++dem].trim(), DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)));
                        tkkkh.setSoTaiKhoan(str[++dem].trim());
                        tkkkh.setMatKhau(Integer.parseInt(CauHinh.giaiMaMatKhau(str[++dem].trim())));
                        tkkkh.setSoTienGui(Double.parseDouble(str[++dem].trim()));
                        if (str[++dem].trim().equalsIgnoreCase("true")) {
                            tkkkh.setTrangThai(true);
                        } else {
                            tkkkh.setTrangThai(false);
                        }
                        this.quanLyTaiKhoan.add(tkkkh);
                    }
                }
                dem = 0;
            }
            file.close();
        }
    }

    public void ghiFileSauKhiXuLy() throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        PrintWriter printWriter = new PrintWriter(CauHinh.DATA_FILE);
        for (TaiKhoan i : this.quanLyTaiKhoan) {
            if (i instanceof TaiKhoanKhongKyHan x) {
                String matKhauMaHoa = CauHinh.maHoaMatKhau(Integer.toString(x.getMatKhau()));
                printWriter.printf("%s, %s, %s, %s, %s, Tài khoản không kỳ hạn, %s, %s, %s, %.3f,", x.getHoTen(), x.getSoCCCD(),
                        x.getNgaySinh().format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                        x.getQueQuan(), x.getGioiTinh(), x.getNgayDangKy().format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                        x.getSoTaiKhoan(), matKhauMaHoa, x.getSoTienGui());
                if (x.isTrangThai() == true) {
                    printWriter.printf("true\n");
                } else {
                    printWriter.printf("false\n");
                }
                for (TaiKhoanCoKyHan j : x.getQuanDanhSachTaiKhoanCoKyHan()) {
                    String matKhauMaHoa2 = CauHinh.maHoaMatKhau(Integer.toString(j.getMatKhau()));
                    printWriter.printf("%s, %s, %s, %s, %s, Tài khoản có kỳ hạn, %s, %s, %s, %.3f,", x.getHoTen(), x.getSoCCCD(),
                            x.getNgaySinh().format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                            x.getQueQuan(), x.getGioiTinh(), j.getNgayDangKy().format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                            x.getSoTaiKhoan(), matKhauMaHoa2, j.getSoTienGui());
                    if (j.isTrangThai() == true) {
                        printWriter.printf("true");
                    } else {
                        printWriter.printf("false");
                    }
                    printWriter.printf(", %s\n", j.getThongTinKyHan().getTen());
                }
            }
        }
        printWriter.close();
    }
}
