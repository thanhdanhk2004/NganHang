/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom.baitaplon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author add
 */
public class TaiKhoanCoKyHan extends TaiKhoanKhongKyHan{
    private LocalDate ngayDaoHan;
    private KyHan thongTinKyHan;
    private int loaiKyHan;
    public TaiKhoanCoKyHan(LocalDate ngayDaoHan, int loaiKyHan) {
        this.ngayDaoHan = ngayDaoHan;
        this.loaiKyHan = loaiKyHan;
    }

    public LocalDate getNgayDaoHan() {
        return ngayDaoHan;
    }

    /**
     * @param ngayDaoHan the ngayDaoHan to set
     */
    public void setNgayDaoHan(LocalDate ngayDaoHan) {
        this.ngayDaoHan = ngayDaoHan;
    }

    /**
     * @return the loaiKyHan
     */
    public int getLoaiKyHan() {
        return loaiKyHan;
    }

    /**
     * @param loaiKyHan the loaiKyHan to set
     */
    public void setLoaiKyHan(int loaiKyHan) {
        this.loaiKyHan = loaiKyHan;
    }
    @Override 
    public TaiKhoanCoKyHan moTaiKhoan(){
        System.out.print("=== BẠN MUỐN CHỌN LOẠI KỲ HẠN NÀO ===\n"+
                         "1) Kỳ hạn một tuần.\n"+
                         "2) Kỳ hạn một tháng.\n"+
                         "3) Kỳ hạn sáu tháng.\n"+
                         "4) Kỳ hạn một năm.\n"+
                         "=== MỜI BẠN CHỌN ===\n");
        this.loaiKyHan = CauHinh.input.nextInt();
        try{
            System.out.print("* Đăng ký thành công.\n");
        }catch(Exception ex){
            System.out.print("Bạn chọn sai nên loại kỳ hạn của bạn là kỳ hạn một tuần");
            this.loaiKyHan = 1;
        }
        if(this.loaiKyHan == 1){
           // thongTinKyHan = (KyHanMotTuan)(thongTinKyHan);
            thongTinKyHan = new KyHanMotTuan(7, 2, this.getSoTienGui());
            this.ngayDaoHan = thongTinKyHan.tinhNgayDaoHan(this.ngayDaoHan);
        }
        else if(this.loaiKyHan == 2){
            //thongTinKyHan = (KyHanMotThang)(thongTinKyHan);
            thongTinKyHan = new KyHanMotThang(1, 5.5, this.getSoTienGui());
            this.ngayDaoHan = thongTinKyHan.tinhNgayDaoHan(this.ngayDaoHan);
        }
        else if(this.loaiKyHan == 3){
           // thongTinKyHan = (KyHanSauThang)(thongTinKyHan);
            thongTinKyHan = new KyHanSauThang(6, 7.5, this.getSoTienGui());
            this.ngayDaoHan = thongTinKyHan.tinhNgayDaoHan(this.ngayDaoHan);
        }
        else{
            //thongTinKyHan = (KyHanMotNam)(thongTinKyHan);
            thongTinKyHan = new KyHanMotNam(7, 2, this.getSoTienGui());
            this.ngayDaoHan = thongTinKyHan.tinhNgayDaoHan(this.ngayDaoHan);
        }  
        this.ngayDaoHan = thongTinKyHan.tinhNgayDaoHan(this.ngayDaoHan);
        return new TaiKhoanCoKyHan(this.ngayDaoHan, this.loaiKyHan);
    }

    @Override
    public void hienThi() {
        super.hienThi(); 
        thongTinKyHan.hienThiThongTinKyHan();
        System.out.printf("+ Ngày đáo hạn: %s", this.ngayDaoHan.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
