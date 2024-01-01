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
    public static void menu(){
        System.out.print("============== MENU LỰA CHỌN ================\n"+
                         "1) Mở tài khoản ngân hàng.\n"+
                         "2) Mở tài khoản có kỳ hạn.\n"+
                         "3) Gửi tiền vào tài khoản.\n"+
                         "4) Rút tiền.\n"+
                         "5) Tính tiền lãi nhận được\n"+
                         "6) Tra cứu thông tin.\n"+
                         "7) Tra cứu danh sách tài khoản theo mã số.\n"+
                         "8) Xem danh sách khách hàng có tổng số tiền gửi giảm dần.\n"+
                         "9) Đổi mật khẩu tài khoản.\n"+
                         "10) Sửa thông tin tài khoản.\n"+
                         "11) Thoát chương trình.\n"+
                         "======== MỜI BẠN LỰA CHỌN =========\n");
    }
    public static void khoangTrang(){
        for(int i=0;i<3;i++){
            System.out.println();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
        int choose;
        do{
            menu();
            do{
                System.out.print("- Nhập vào lựa chọn của bạn:");
                choose = CauHinh.SC.nextInt();
                if(choose < 1 || choose > 11)
                    System.out.print("+ Nhập không hợp lệ! Mời nhập lại.\n");
            }while(choose < 1 || choose > 11);
            CauHinh.SC.nextLine();
            if(choose == 1){
                System.out.print("+ Nhập vào số cccd của bạn:");
                String soCCCD = CauHinh.SC.nextLine();
                if(qltk.timKiem(soCCCD) != null){
                    System.out.print("+ Bạn đã có tài khoản không kỳ hạn của ngân hàng.\n");
                }
                else
                    qltk.moTaiKhoan(soCCCD);  
            }
            else if(choose == 2){
                
            }
            else if(choose == 8){
                qltk.hienThiThongTin();
            }
            CauHinh.SC.nextLine();
            System.out.print("\n* Nhấn Enter để tiếp tục.\n");
            CauHinh.SC.nextLine();
            khoangTrang();
        }while(choose > 0 && choose < 11);
    }
    
}
