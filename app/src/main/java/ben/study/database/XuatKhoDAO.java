package ben.study.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ben.study.model.KhoModel;

public class XuatKhoDAO {
    private DatabaseDuAn1 databaseDuAn1;
    private Context context;
    public XuatKhoDAO(DatabaseDuAn1 databaseDuAn1){
        this.databaseDuAn1 = databaseDuAn1;
        this.context = context;
    }

    public boolean themhangxuat(KhoModel khoModel){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHangXuat",khoModel.getMaHang());
        contentValues.put("tenHangXuat",khoModel.getTenHang());
        contentValues.put("theLoaiHangXuat",khoModel.getTheloaihang());
        contentValues.put("soLuongXuat",khoModel.getSoLuong());
        contentValues.put("giaHangXuat",khoModel.getGia());
        contentValues.put("ngayXuat",khoModel.getNgayXuat());
        contentValues.put("ngayNhap",khoModel.getNgayNhap());

        long kq =  sqLiteDatabase.insert("kho_xuat",null,contentValues);
        if (kq > 0) return true;
        else return false;
    }
    public boolean xoahangtrongkhoxuat(String maHangXuat){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        long kq =  sqLiteDatabase.delete("kho_xuat","maHangXuat=?",new String[]{maHangXuat});
        if (kq > 0) return true;
        else return false;
    }
    public List<KhoModel> getallHangKhoxuat(){
        List<KhoModel> khoModels  = new ArrayList<>();
        String truyvan = "SELECT * FROM kho_xuat";
        Cursor cursor = databaseDuAn1.getWritableDatabase().rawQuery(truyvan,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                String maHangNhap = cursor.getString(cursor.getColumnIndex("maHangXuat"));
                String tenHangNhap = cursor.getString(cursor.getColumnIndex("tenHangXuat"));
                String theLoaiHangNhap = cursor.getString(cursor.getColumnIndex("theLoaiHangXuat"));
                int soLuongNhap = cursor.getInt(cursor.getColumnIndex("soLuongXuat"));
                Double giaHangXuat = cursor.getDouble(cursor.getColumnIndex("giaHangXuat"));
                String ngayXuat = cursor.getString(cursor.getColumnIndex("ngayXuat"));
                String ngayNhap = cursor.getString(cursor.getColumnIndex("ngayNhap"));

                KhoModel khoModel = new KhoModel();
                khoModel.setMaHang(maHangNhap);
                khoModel.setTenHang(tenHangNhap);
                khoModel.setTheloaihang(theLoaiHangNhap);
                khoModel.setSoLuong(soLuongNhap);
                khoModel.setGia(giaHangXuat);
                khoModel.setNgayXuat(ngayXuat);
                khoModel.setNgayNhap(ngayNhap);

                khoModels.add(khoModel);

                cursor.moveToNext();
            }
            cursor.close();
        }
        return khoModels;
    }

    public int suaHangxuat(KhoModel khoModel){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHangXuat",khoModel.getMaHang());
        contentValues.put("tenHangXuat",khoModel.getTenHang());
        contentValues.put("theLoaiHangXuat",khoModel.getTheloaihang());
        contentValues.put("soLuongXuat",khoModel.getSoLuong());
        contentValues.put("giaHangXuat",khoModel.getGia());
        contentValues.put("ngayXuat",khoModel.getNgayXuat());
        contentValues.put("ngayNhap",khoModel.getNgayNhap());
        return sqLiteDatabase.update("kho_xuat",contentValues,"maHangXuat=?",new String[]{khoModel.getMaHang()});
    }

    public List<KhoModel> FindSanPhamXuatKho(String FindHangXuat){
        List<KhoModel> khoModels  = new ArrayList<>();
        String truyvan = "SELECT * FROM kho_xuat WHERE maHangXuat LIKE '%" + FindHangXuat + "%'";
        Cursor cursor = databaseDuAn1.getWritableDatabase().rawQuery(truyvan,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                String maHangNhap = cursor.getString(cursor.getColumnIndex("maHangXuat"));
                String tenHangNhap = cursor.getString(cursor.getColumnIndex("tenHangXuat"));
                String theLoaiHangNhap = cursor.getString(cursor.getColumnIndex("theLoaiHangXuat"));
                int soLuongNhap = cursor.getInt(cursor.getColumnIndex("soLuongXuat"));
                Double giaHangXuat = cursor.getDouble(cursor.getColumnIndex("giaHangXuat"));
                String ngayXuat = cursor.getString(cursor.getColumnIndex("ngayXuat"));
                String ngayNhap = cursor.getString(cursor.getColumnIndex("ngayNhap"));

                KhoModel khoModel = new KhoModel();
                khoModel.setMaHang(maHangNhap);
                khoModel.setTenHang(tenHangNhap);
                khoModel.setTheloaihang(theLoaiHangNhap);
                khoModel.setSoLuong(soLuongNhap);
                khoModel.setGia(giaHangXuat);
                khoModel.setNgayXuat(ngayXuat);
                khoModel.setNgayNhap(ngayNhap);

                khoModels.add(khoModel);

                cursor.moveToNext();
            }
            cursor.close();
        }
        return khoModels;
    }
}
