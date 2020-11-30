package ben.study.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import ben.study.model.KhoModel;

public class KhoDAO {
    private DatabaseDuAn1 databaseDuAn1;

    public KhoDAO (DatabaseDuAn1 databaseDuAn1){this.databaseDuAn1 = databaseDuAn1;}

    public long nhapKho(KhoModel khoModel){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHangNhap",khoModel.getMaHang());
        contentValues.put("tenHangNhap",khoModel.getTenHang());
        contentValues.put("theLoaiHangNhap",khoModel.getTheloaihang());
        contentValues.put("soLuongNhap",khoModel.getSoLuong());
        contentValues.put("ngayNhap",khoModel.getNgayNhap());

        return sqLiteDatabase.insert("kho_nhap",null,contentValues);
    }

    public long xuatKho(KhoModel khoModel){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHangXuat",khoModel.getMaHang());
        contentValues.put("tenHangXuat",khoModel.getTenHang());
        contentValues.put("theLoaiHangXuat",khoModel.getTheloaihang());
        contentValues.put("soLuongXuat",khoModel.getSoLuong());
        contentValues.put("ngayXuat",khoModel.getNgayXuat());

        return sqLiteDatabase.insert("kho_xuat",null,contentValues);
    }

    public long suaNhapKho(KhoModel khoModel){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHangNhap",khoModel.getMaHang());
        contentValues.put("tenHangNhap",khoModel.getTenHang());
        contentValues.put("theLoaiHangNhap",khoModel.getTheloaihang());
        contentValues.put("soLuongNhap",khoModel.getSoLuong());
        contentValues.put("ngayNhap",khoModel.getNgayNhap());

        return sqLiteDatabase.update("kho_nhap",contentValues,"maHangNhap=?",new String[]{khoModel.getMaHang()});
    }

    public long suaXuatKho(KhoModel khoModel){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHangXuat",khoModel.getMaHang());
        contentValues.put("tenHangXuat",khoModel.getTenHang());
        contentValues.put("theLoaiHangXuat",khoModel.getTheloaihang());
        contentValues.put("soLuongXuat",khoModel.getSoLuong());
        contentValues.put("ngayXuat",khoModel.getNgayNhap());

        return sqLiteDatabase.update("xuat_nhap",contentValues,"maHangXuat=?",new String[]{khoModel.getMaHang()});
    }

    public void xoaHangNhap(String id){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        sqLiteDatabase.delete("kho_nhap","maHangNhap=?",new String[]{id});
    }

    public void xoaHangXuat(String id){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        sqLiteDatabase.delete("kho_xuat","maHangXuat=?",new String[]{id});
    }

//    public List<KhoModel> getAllKhoNhap(){
//
//    }
}
