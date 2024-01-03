
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nganhang;

import com.nhom.baitaplon.CauHinh;
import com.nhom.baitaplon.QuanLyTaiKhoan;
import com.nhom.baitaplon.TaiKhoanKhongKyHan;
import java.io.FileNotFoundException;

/**
 *
 * @author add
 */
public class NganHang {

    public static void khoangTrang() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
        //qltk.docDuLieuKhachHang();
        int choice;
        do {
            choice = CauHinh.menu("============== MENU LỰA CHỌN ================\n"
                    + "1) Đăng nhập.\n"
                    + "2) Đăng Ký.\n"
                    + "3) Thoát chương trình.\n"
                    + "======== MỜI BẠN LỰA CHỌN =========\n"
                    + ">>Bạn chọn: ");
            switch (choice) {
                case 1 -> {
                    TaiKhoanKhongKyHan tkkkh = qltk.dangNhap();
                    if (tkkkh != null) {
                        int choice1;
                        do {
                            choice1 = CauHinh.menu("============== MENU LỰA CHỌN ================\n"
                                    + "1) Nạp tiền.\n"
                                    + "2) Rút tiền.\n"
                                    + "3) Mở tài khoản ngân hàng có kỳ hạn.\n"
                                    + "4) Tra cứu danh sách tài khoản.\n"
                                    + "5) Tra cứu khách hàng.\n"
                                    + "6) Xem danh sách khách hàng có tổng số tiền gửi giảm dần.\n"
                                    + "7) Đăng xuất.\n"
                                    + "======== MỜI BẠN LỰA CHỌN =========\n"
                                    + ">>Bạn chọn: ");
                            switch (choice1) {
                                case 1 -> {
                                    break;
                                }
                                case 2 -> {
                                    int choice2;
                                    do {
                                        choice2 = CauHinh.menu("=== LỰA CHỌN NƠI RÚT TIỀN ===\n"
                                                + "1) Rút từ tài khoản chính.\n"
                                                + "2) Rút từ tài khoản có kỳ hạn.\n"
                                                + "3) Thoát\n"
                                                + ">>Bạn chọn: ");;
                                        switch (choice2) {
                                            case 1 -> {
                                                tkkkh.rutTien(CauHinh.nhapSoTien());
                                                break;
                                            }
                                            case 2 -> {
                                                tkkkh.rutTienTaiKhoanKhongKyHan();
                                                break;
                                            }
                                            case 3 -> {
                                                break;
                                            }
                                            default -> {
                                                System.out.println("\nLựa chọn không hợp lệ! Nhấn Enter để nhập lại.\n");
                                                CauHinh.SC.nextLine();
                                            }
                                        }
                                    } while (choice2 != 3);
                                    break;
                                }
                                case 3 -> {
                                    break;
                                }
                                case 4 -> {
                                    break;
                                }
                                case 5 -> {
                                    break;
                                }
                                case 6 -> {
                                    break;
                                }
                                case 7 -> {
                                    break;
                                }
                                default -> {
                                    System.out.println("\nLựa chọn không hợp lệ! Nhấn Enter để nhập lại.\n");
                                    CauHinh.SC.nextLine();
                                    khoangTrang();
                                }
                            }
                        } while (choice != 7);
                    }
                    break;
                }
                case 2 -> {
                    qltk.moTaiKhoan();
                    break;
                }
                case 3 -> {
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
        } while (choice != 3);
    }

}
