
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nganhang;

import com.nhom.baitaplon.CauHinh;
import com.nhom.baitaplon.QuanLyTaiKhoan;
import com.nhom.baitaplon.TaiKhoanKhongKyHan;

/**
 *
 * @author add
 */
public class NganHang {
     public static int menu(String prom) {
        System.out.print(prom);
        String choice = CauHinh.SC.nextLine();
        if (choice.matches("[0-9]+")) {
            return Integer.parseInt(choice);
        }
        else
            return 0;

    }
     
    public static void khoangTrang(){
        for(int i=0;i<3;i++){
            System.out.println();
        }
    }
    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
        int choice;
        do {
            choice = menu("============== MENU LỰA CHỌN ================\n"
                    + "1) Đăng nhập.\n"
                    + "2) Mở tài khoản ngân hàng.\n"
                    + "3) Xem danh sách khách hàng có tổng số tiền gửi giảm dần.\n"
                    + "4) Thoát chương trình.\n"
                    + "======== MỜI BẠN LỰA CHỌN =========\n"
                    + ">>Bạn chọn: ");
            switch (choice) {
                case 1 -> {
                    break;
                }
                case 2 -> {
                    System.out.print("+ Nhập vào số cccd của bạn:");
                    String soCCCD = CauHinh.SC.nextLine();
                    if (qltk.timKiem(soCCCD) != null) {
                        TaiKhoanKhongKyHan tkkkh = (TaiKhoanKhongKyHan) qltk.timKiem(soCCCD);
                        System.out.print("+ Tài khoản đã tồn tại!\n");
                    } else {
                        qltk.moTaiKhoan(soCCCD);
                    }
                    break;
                }
                
                case 3 -> {
                    qltk.hienThiThongTin();
                    CauHinh.SC.nextLine();
                    System.out.print("\n* Nhấn Enter để tiếp tục.\n");
                    CauHinh.SC.nextLine();
                    khoangTrang();
                    break;
                }
                case 4 -> {
                    System.out.println("\nCảm ơn quý khách đã sử dụng dịch vụ của chúng tôi!");
                    khoangTrang();
                    break;
                }
                default -> {
                    System.out.println("\nLựa chọn không hợp lệ! Nhấn Enter để nhập lại.\n");
                    CauHinh.SC.nextLine();
                    khoangTrang();
                }

            }
        } while (choice != 4);
    }
    
}