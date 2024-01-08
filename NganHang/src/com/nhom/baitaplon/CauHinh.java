/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom.baitaplon;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author add
 */
public class CauHinh {

    public static Scanner SC = new Scanner(System.in);
    public static String DATE_FORMAT = "dd/MM/yyyy";
    public static File DATA_FILE = new File("C:\\Users\\Le Quang Minh\\OneDrive\\Documents\\GitHub\\NganHang\\NganHang\\src\\com\\nhom\\data\\ThongTinKhachHang.txt");

    public static void ganKyHan() {
        KyHan.getArrLKH().addAll(Arrays.asList(new KyHanMotTuan(), new KyHanMotThang(), new KyHanSauThang(), new KyHanMotNam()));
    }

    public static int menu(String prom) {
        System.out.print(prom);
        String choice = CauHinh.SC.nextLine();
        if (choice.matches("[0-9]+")) {
            return Integer.parseInt(choice);
        } else {
            return 0;
        }

    }

    public static String nhapHoTen() {
        String ten;
        do {
            System.out.print("+ Nhập họ tên: ");
            ten = CauHinh.SC.nextLine().toUpperCase();
            if (!ten.matches("[A-Za-z\\s]+")) {
                System.out.println("\nTên chỉ có thể chứa chữ cái! Nhấn Enter để nhập lại.\n");
                CauHinh.SC.nextLine();
            }
        } while (!ten.matches("[A-Za-z\\s]+"));
        return ten;
    }

    public static LocalDate nhapNgayThangNamSinh() {
        String ns;
        do {
            System.out.print("+ Nhập ngày tháng năm sinh (dd/mm/yyyy): ");
            ns = CauHinh.SC.nextLine();
            if (!ns.matches("(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/([12]\\d{3})")) {
                System.out.println("\nDữ liệu phải được nhập dưới dạng(dd/mm/yyyy)! Nhấn Enter để nhập lại.\n");
                CauHinh.SC.nextLine();
            }
        } while (!ns.matches("(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/([12]\\d{3})"));
        return LocalDate.parse(ns, DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT));
    }

    public static String nhapSoCCCD() {
        String cccd;
        do {
            System.out.print("+ Nhập số căn cước công dân: ");
            cccd = CauHinh.SC.nextLine();
            if (!cccd.matches("[0-9]+")) {
                System.out.println("\nCăn cước công dân chỉ bao gồm chữ số! Nhấn Enter để nhập lại.\n");
                CauHinh.SC.nextLine();
            }
        } while (!cccd.matches("[0-9]+"));
        return cccd;
    }

    public static String nhapQueQuan() {
        String qq;
        do {
            System.out.print("+ Nhập vào quê quán: ");
            qq = CauHinh.SC.nextLine();
            if (!qq.matches("[A-Za-z\\s]+")) {
                System.out.println("\nQuê quán chỉ bao gồm chữ cái! Nhấn Enter để nhập lại.\n");
                CauHinh.SC.nextLine();
            }
        } while (!qq.matches("[A-Za-z\\s]+"));
        return qq;
    }

    public static String nhapGioiTinh() {
        int choice;
        String gt = "Khác";
        do {
            choice = CauHinh.menu("1) Nam.\n2) Nữ.\n3) Giới tính khác.\n- Nhập vào lựa chọn của bạn:");

            switch (choice) {
                case 1 ->
                    gt = "Nam";
                case 2 ->
                    gt = "Nữ";
                case 3 ->
                    gt = "Khác";
                default -> {
                    System.out.println("\nLựa chọn không hợp lệ! Nhấn Enter để nhập lại.\n");
                    CauHinh.SC.nextLine();
                }
            }
        } while (choice != 1 && choice != 2 && choice != 3);
        return gt;
    }

    public static int nhapMatKhau() {
        String mk;
        do {
            System.out.print("Nhập mật khẩu: ");
            mk = CauHinh.SC.nextLine();
            if (mk.length() != 6 || !mk.matches("[0-9]+")) {
                System.out.println("\nMật khẩu chỉ có thể bao gồm 6 chữ số! Nhấn Enter để nhập lại.\n");
                CauHinh.SC.nextLine();
            }
        } while (mk.length() != 6 || !mk.matches("[0-9]+"));
        return Integer.parseInt(mk);
    }

    public static String nhapSTK() {
        String stk;
        do {
            System.out.print("+ Nhập số tài khoản: ");
            stk = CauHinh.SC.nextLine();
            if (!stk.matches("[0-9]+") || stk.length() != 12) {
                System.out.println("\nSố tài khoản bao gồm 12 chữ số! Nhấn Enter để nhập lại.\n");
                CauHinh.SC.nextLine();
            }
        } while (!stk.matches("[0-9]+") || stk.length() != 12);
        return stk;
    }

    public static double nhapSoTien() {
        String soTien;
        double st = 0;
        do {
            System.out.print("+ Nhập số tiền: ");
            soTien = CauHinh.SC.nextLine();
            if ((!soTien.matches("[0-9]+") && !soTien.matches("[0-9]+(\\.)[0-9]+")) || soTien.length() >= 9) {
                System.out.println("\nSố tiền không hợp lệ! Nhấn Enter để nhập lại.\n");
                CauHinh.SC.nextLine();
            } else {
                st = Double.parseDouble(soTien);
                if (st <= 0 || st > 1000000000) {
                    System.out.println("\nHạn mức chuyển tiền là 1 tỷ! Nhấn Enter để nhập lại.\n");
                    CauHinh.SC.nextLine();
                }
            }
        } while (!soTien.matches("[0-9]+") && !soTien.matches("[0-9]+\\.[0-9]+") || st <= 0 || st > 1000000000);
        return st;
    }

    public static String maHoaMatKhau(String matKhau) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String khoaBiMat = "toitenlathanhdan";
        SecretKeySpec skeySpec = new SecretKeySpec(khoaBiMat.getBytes(), "AES");
        String original = matKhau;// Chuỗi gốc 
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");//Tạo đối tượng cripher các thông tin(thuật toán mã hóa/ Mode/ passding
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] byteEncrypted = cipher.doFinal(original.getBytes());
        return Base64.getEncoder().encodeToString(byteEncrypted);
    }

    public static String giaiMaMatKhau(String chuoiDaMaHoa) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String khoaBiMat = "toitenlathanhdan";// 128, 192, 256 bit
        SecretKeySpec skeySpec = new SecretKeySpec(khoaBiMat.getBytes(), "AES");// Tạo key mã hóa, giải mã
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");//Tạo đối tượng cripher các thông tin(thuật toán mã hóa/ Mode/ passding

        // Giải mã dữ liệu base64 trước khi tiến hành giải mã
        byte[] byteEncrypted = Base64.getDecoder().decode(chuoiDaMaHoa);
        //Giải mã
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] byteDecrypted = cipher.doFinal(byteEncrypted);
        return new String(byteDecrypted);
    }
}
