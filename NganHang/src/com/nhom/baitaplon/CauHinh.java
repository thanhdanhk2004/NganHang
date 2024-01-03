/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom.baitaplon;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author add
 */
public class CauHinh {
    public static Scanner SC = new Scanner(System.in);
    public static String DATE_FORMAT = "dd/MM/yyyy";
    public static File DATA_FILE = new File("C:\\Users\\add\\Pictures\\NganHang\\NganHang\\src\\com\\nhom\\data\\ThongTinKhachHang.txt");
    
    public static String nhapHoTen() {
        String ten;
        do {
            System.out.print("+ Nhập họ tên: ");
            ten = CauHinh.SC.nextLine().toUpperCase();
            if (!ten.matches("[A-Za-z]")) {
                System.out.println("\nTên chỉ có thể chứa chữ cái! Nhấn Enter để nhập lại.\n");
                CauHinh.SC.nextLine();
            }
        } while (!ten.matches("[A-Za-z]"));
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
            if (!qq.matches("[A-Za-z]")) {
                System.out.println("\nQuê quán chỉ bao gồm chữ cái! Nhấn Enter để nhập lại.\n");
                CauHinh.SC.nextLine();
            }
        } while (!qq.matches("[A-Za-z]"));
        return qq;
    }

    public static String nhapGioiTinh() {
        int choice;
        String gt = "Khác";
        do {
            choice = CauHinh.menu("1) Nam.\n2) Nữ.\n3) Giới tính khác.\n- Nhập vào lựa chọn của bạn:");
            
            switch (choice) {
                case 1 -> gt = "Nam";
                case 2 -> gt = "Nữ";
                case 3 -> gt = "Khác";
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
    
    public static int menu(String prom) {
        System.out.print(prom);
        String choice = CauHinh.SC.nextLine();
        if (choice.matches("[0-9]+")) {
            return Integer.parseInt(choice);
        }
        else
            return 0;

    }

}
