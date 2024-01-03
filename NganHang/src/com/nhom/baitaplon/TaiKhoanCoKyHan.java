/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom.baitaplon;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author add
 */
public class TaiKhoanCoKyHan extends TaiKhoanKhongKyHan {

    private KyHan thongTinKyHan;
    private double soTienTietKiem;
    private LocalDate ngayTao = LocalDate.now();

    public TaiKhoanCoKyHan(KyHan thongTinKyHan, double soTienTietKiem) {
        this.thongTinKyHan = thongTinKyHan;
        this.soTienTietKiem = soTienTietKiem;
    }

    public TaiKhoanCoKyHan() {
    }

    /**
     * @return the soTienTietKiem
     */
    public double getSoTienTietKiem() {
        return soTienTietKiem;
    }

    /**
     * @param soTienTietKiem the soTienTietKiem to set
     */
    public void setSoTienTietKiem(double soTienTietKiem) {
        this.soTienTietKiem = soTienTietKiem;
    }

    /**
     * @return the thongTinKyHan
     */
    public KyHan getThongTinKyHan() {
        return thongTinKyHan;
    }

    /**
     * @param thongTinKyHan the thongTinKyHan to set
     */
    public void setThongTinKyHan(KyHan thongTinKyHan) {
        this.thongTinKyHan = thongTinKyHan;
    }

    @Override
    public TaiKhoanCoKyHan moTaiKhoan() {

        try {
            int choice;
            do {
                System.out.println("=== LOẠI KỲ HẠN ===");
                int i;
                for (i = 0; i < KyHan.getArrLKH().size(); i++) {
                    System.out.printf("%d) %s\n", i + 1, KyHan.getArrLKH().get(i).getTen());
                }
                System.out.print("- Bạn muốn chọn loại kỳ hạn nào:");
                String ch = CauHinh.SC.nextLine();
                if (ch.matches("[0-9]+")) {
                    choice = Integer.parseInt(ch);
                } else {
                    choice = 0;
                }
                if (choice >= 1 && choice <= KyHan.getArrLKH().size()) {
                    String classPath = "com.nhom.baitaplon." + KyHan.getArrLKH().get(choice - 1).toString();
                    Class c = Class.forName(classPath);
                    KyHan kyHan = (KyHan) c.getConstructor().newInstance();
                    return new TaiKhoanCoKyHan(kyHan, CauHinh.nhapSoTien());
                } else {
                    System.out.println("\nLựa chọn không hợp lệ! Nhấn Enter để nhập lại.\n");
                    CauHinh.SC.nextLine();
                }
            } while (!(choice >= 1 && choice <= KyHan.getArrLKH().size()));
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanCoKyHan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void hienThi() {
        System.out.printf("+Số tiền gửi: %f\n+Tiền lãi khi đáo hạn: %f\n+ Ngày đáo hạn: %s\n", this.getSoTienGui(), this.tinhTienLai(), this.getThongTinKyHan().tinhNgayDaoHan(this.getNgayDangKy()).format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)));
        getThongTinKyHan().hienThiThongTinKyHan();
        System.out.println("");
    }

    @Override
    public void ghiThongTinVaoFile() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(CauHinh.DATA_FILE, true);
            try (PrintWriter xuatFile = new PrintWriter(fileWriter)) {
                xuatFile.printf("%s, %s, %s, %s, %s, Tài khoảng có kỳ hạn, %s, %s, %d, %.3f, %s, %s\n", this.getHoTen(), this.getSoCCCD(),
                        this.getNgaySinh().format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                        this.getQueQuan(), this.getGioiTinh(), this.getNgayDangKy().format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                        this.getSoTaiKhoan(), this.getMatKhau(), this.getSoTienGui(),
                        this.getThongTinKyHan().tinhNgayDaoHan(this.getNgayDangKy()).format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                        this.thongTinKyHan.getTen());
            }
        } catch (IOException ex) {
            //Logger.getLogger(TaiKhoanCoKyHan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(TaiKhoanKhongKyHan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean xacNhanRutTien() {
        int choice;
        do {
            choice = CauHinh.menu("TOÀN BỘ TIỀN TIẾT KIỆM SẼ ĐƯỢC TÍNH THEO LÃI SUẤT KHÔNG KỲ HẠN.\n"
                    + "Bạn có chắc muốn rút tiền không?"
                    + "1) Tôi chắc chắn.\n"
                    + "2) Hủy bỏ giao dịch.\n"
                    + ">>Bạn chọn: ");
            switch (choice) {
                case 1 -> {
                    return true;
                }
                case 2 -> {
                    System.out.println("Giao dịch đã được hủy!");
                    return false;
                }
                default -> {
                    System.out.println("\nLựa chọn không hợp lệ! Nhấn Enter để nhập lại.\n");
                    CauHinh.SC.nextLine();
                }
            }
        } while (choice != 1 && choice != 2);
        return false;
    }

    /**
     * @return the ngayTao
     */
    public LocalDate getNgayTao() {
        return ngayTao;
    }

}
