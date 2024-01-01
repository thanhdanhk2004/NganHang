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
        if (choice.matches("[A-Za-z0-9]{2,}") || choice.matches("[A-Za-z]+")) {
            return 0;
        }
        else
            return Integer.parseInt(choice);

    }
//    public static void menuChuaDangNhap(){
//        System.out.print("============== MENU LỰA CHỌN ================\n"+
//                         "1) Đăng nhập.\n"+
//                         "2) Mở tài khoản ngân hàng.\n"+
//                         "3) Xem danh sách khách hàng có tổng số tiền gửi giảm dần.\n"+
//                         "4) Thoát chương trình.\n"+
//                         "======== MỜI BẠN LỰA CHỌN =========\n");
//    }
//    public static void menuDaDangNhap(){
//        System.out.print("============== MENU LỰA CHỌN ================\n"+
//                         "1) Mở tài khoản có kỳ hạn.\n"+
//                         "2) Gửi tiền vào tài khoản.\n"+
//                         "3) Rút tiền.\n"+
//                         "4) Tính tiền lãi nhận được\n"+
//                         "5) Tra cứu thông tin.\n"+
//                         "6) Tra cứu danh sách tài khoản theo mã số.\n"+
//                         "7) Xem danh sách khách hàng có tổng số tiền gửi giảm dần.\n"+
//                         "8) Đổi mật khẩu tài khoản.\n"+
//                         "9) Sửa thông tin tài khoản.\n"+
//                         "10) Thoát chương trình.\n"+
//                         "======== MỜI BẠN LỰA CHỌN =========\n");
//    }

    public static void khoangTrang() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.lang.CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
        int choose;
        do {
            choose = menu("============== MENU LỰA CHỌN ================\n"
                    + "1) Đăng nhập.\n"
                    + "2) Mở tài khoản ngân hàng.\n"
                    + "3) Xem danh sách khách hàng có tổng số tiền gửi giảm dần.\n"
                    + "4) Thoát chương trình.\n"
                    + "======== MỜI BẠN LỰA CHỌN =========\n");
            switch (choose) {
                case 1:
                    System.out.print("+ Nhập vào số cccd của bạn:");
                    String soCCCD = CauHinh.SC.nextLine();
                    if (qltk.timKiem(soCCCD) != null) {
                        TaiKhoanKhongKyHan tkkkh = (TaiKhoanKhongKyHan) qltk.timKiem(soCCCD);
                        System.out.print("+ Bạn đã có tài khoản không kỳ hạn của ngân hàng.\n");
                        System.out.print("+ Bạn có muốn tạo tài khoản có kỳ hạn không(y/n):");
                        String luaChon = CauHinh.SC.nextLine();
                        if (luaChon.equalsIgnoreCase("y")) {
                            qltk.moTaiKhoan(tkkkh);
                        }
                    } else {
                        qltk.moTaiKhoan(soCCCD);
                    }
                    break;
                case 8:
                    qltk.hienThiThongTin();
                    CauHinh.SC.nextLine();
                    System.out.print("\n* Nhấn Enter để tiếp tục.\n");
                    CauHinh.SC.nextLine();
                    khoangTrang();
                    break;
                default:

            }
        } while (choose > 0 && choose < 11);
    }

}
