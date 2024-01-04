
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nganhang;

import com.nhom.baitaplon.CauHinh;
import com.nhom.baitaplon.KyHan;
import com.nhom.baitaplon.QuanLyTaiKhoan;
import com.nhom.baitaplon.TaiKhoan;
import com.nhom.baitaplon.TaiKhoanKhongKyHan;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

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
    public static QuanLyTaiKhoan khoiDong() throws FileNotFoundException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
        CauHinh.ganKyHan();
        qltk.docDuLieuKhachHang();
        return qltk;
    }
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        QuanLyTaiKhoan qltk = khoiDong();
        
        int choice;
        do {
            choice = CauHinh.menu("============== MENU LỰA CHỌN ================\n"
                    + "1) Đăng nhập.\n"
                    + "2) Đăng ký.\n"
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
                                    Double soTien = CauHinh.nhapSoTien();
                                    tkkkh.goiTien(soTien);
                                    System.out.print("=== GỬI TIỀN THÀNH CÔNG ===\n");
                                    break;
                                }
                                case 2 -> {
                                    int choice2;
                                    do {
                                        choice2 = CauHinh.menu("=== LỰA CHỌN NƠI RÚT TIỀN ===\n"
                                                + "1) Rút từ tài khoản chính.\n"
                                                + "2) Rút từ tài khoản có kỳ hạn.\n"
                                                + "3) Thoát\n"
                                                + ">>Bạn chọn: ");
                                        switch (choice2) {
                                            case 1 -> {
                                                boolean rt = tkkkh.rutTien(CauHinh.nhapSoTien());
                                                if(rt == false)
                                                    System.out.print("=== RÚT TIỀN THẤT BẠI ===\n");
                                                else
                                                    System.out.print("=== RÚT TIỀN THÀNH CÔNG ===\n");
                                                break;
                                            }
                                            case 2 -> {
                                                tkkkh.rutTienTaiKhoanCoKyHan();
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
                                    qltk.moTaiKhoanCoKyHan(tkkkh);
                                    break;
                                }
                                case 4 -> {
                                    qltk.traCuuDanhSachKhachHang(tkkkh.getSoTaiKhoan());
                                    break;
                                }
                                case 5 -> {
                                    System.out.print("+ Nhập vào họ tên hoặc số tài khoản:");
                                    String s = CauHinh.SC.nextLine();
                                    qltk.traCuuTaiKhoan(s).stream().forEach(h->h.hienThi());
                                    break;
                                }
                                case 6 -> {
                                    List<TaiKhoan> list = qltk.locTaiKhoanTheoTien();
                                    list = qltk.sapXepThongTinTheoTienGiamDan(list);
                                    break;
                                }
                                case 7 -> {
                                    System.out.print("=== ĐĂNG XUẤT THÀNH CÔNG ===\n");
                                    qltk.ghiFileSauKhiXuLy();
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
        }while (choice != 3);
        //qltk.ghiFileSauKhiXuLy();
    }
}
