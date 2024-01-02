
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nganhang;

import com.nhom.baitaplon.CauHinh;
import com.nhom.baitaplon.KyHan;
import com.nhom.baitaplon.KyHanMotNam;
import com.nhom.baitaplon.KyHanMotThang;
import com.nhom.baitaplon.KyHanMotTuan;
import com.nhom.baitaplon.KyHanSauThang;
import com.nhom.baitaplon.QuanLyTaiKhoan;
import com.nhom.baitaplon.TaiKhoan;
import com.nhom.baitaplon.TaiKhoanCoKyHan;
import com.nhom.baitaplon.TaiKhoanKhongKyHan;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;

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
        KyHan.getArrLKH().addAll(Arrays.asList(new KyHanMotTuan(2), new KyHanMotThang(5.5),new KyHanSauThang(7.5),new KyHanMotNam(7.9)));
        qltk.docDuLieuKhachHang();
        int choice;
        do {
            choice = CauHinh.menu("============== MENU LỰA CHỌN ================\n"
                    + "1) Đăng nhập.\n"
                    + "2) Mở tài khoản ngân hàng.\n"
                    + "3) Xem danh sách khách hàng có tổng số tiền gửi giảm dần.\n"
                    + "4) Thoát chương trình.\n"
                    + "======== MỜI BẠN LỰA CHỌN =========\n"
                    + ">>Bạn chọn: ");
            switch (choice) {
                case 1 -> {
                    System.out.print("+ Nhập vào số cccd của bạn:");
                    String soCCCD = CauHinh.SC.nextLine();
                    TaiKhoanKhongKyHan tkkkh = (TaiKhoanKhongKyHan) qltk.timKiem(soCCCD);
                    if(tkkkh != null){
                        qltk.moTaiKhoanCoKyHan(tkkkh);
                        tkkkh.getQuanDanhSachTaiKhoanCoKyHan().stream().forEach(h->h.hienThi());
                    }
                    break;
                }
                case 2 -> {
                    System.out.print("+ Nhập vào số cccd của bạn:");
                    String soCCCD = CauHinh.SC.nextLine();
                    TaiKhoanKhongKyHan tkkkh = (TaiKhoanKhongKyHan) qltk.timKiem(soCCCD);
                    if (tkkkh == null) {
                        qltk.moTaiKhoan(soCCCD);
                    } else {
                        System.out.print("+ Tài khoản đã tồn tại!\n");
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
