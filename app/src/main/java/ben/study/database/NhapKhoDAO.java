package ben.study.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ben.study.model.HoaDonModel;
import ben.study.model.KhoModel;


public class NhapKhoDAO {
    private DatabaseDuAn1 databaseDuAn1;
    private Context context;
    public NhapKhoDAO(DatabaseDuAn1 databaseDuAn1){
        this.databaseDuAn1 = databaseDuAn1;
        this.context = context;
    }
    public boolean themhangnhap(KhoModel khoModel){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHangNhap",khoModel.getMaHang());
        contentValues.put("tenHangNhap",khoModel.getTenHang());
        contentValues.put("theLoaiHangNhap",khoModel.getTheloaihang());
        contentValues.put("soLuongNhap",khoModel.getSoLuong());
        contentValues.put("giaHangNhap",khoModel.getGia());
        contentValues.put("ngayNhap",khoModel.getNgayNhap());

        long kq =  sqLiteDatabase.insert("kho_nhap",null,contentValues);
        if (kq > 0) return true;
        else return false;
    }
    public boolean xoahangtrongkhonhap(String maHangNhap){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        long kq =  sqLiteDatabase.delete("kho_nhap","maHangNhap=?",new String[]{maHangNhap});
        if (kq > 0) return true;
        else return false;
    }
    public List<KhoModel> getallHangKhoNhap(){
        List<KhoModel> khoModels  = new ArrayList<>();
        String truyvan = "SELECT * FROM kho_nhap";
        Cursor cursor = databaseDuAn1.getWritableDatabase().rawQuery(truyvan,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                String maHangNhap = cursor.getString(cursor.getColumnIndex("maHangNhap"));
                String tenHangNhap = cursor.getString(cursor.getColumnIndex("tenHangNhap"));
                String theLoaiHangNhap = cursor.getString(cursor.getColumnIndex("theLoaiHangNhap"));
                int soLuongNhap = cursor.getInt(cursor.getColumnIndex("soLuongNhap"));
                Double giaHangNhap = cursor.getDouble(cursor.getColumnIndex("giaHangNhap"));
                String ngayNhap = cursor.getString(cursor.getColumnIndex("ngayNhap"));
                KhoModel khoModel = new KhoModel();
                khoModel.setMaHang(maHangNhap);
                khoModel.setTenHang(tenHangNhap);
                khoModel.setTheloaihang(theLoaiHangNhap);
                khoModel.setSoLuong(soLuongNhap);
                khoModel.setGia(giaHangNhap);
                khoModel.setNgayNhap(ngayNhap);
                khoModels.add(khoModel);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return khoModels;
    }
    public int suaHangNhap(KhoModel khoModel){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHangNhap",khoModel.getMaHang());
        contentValues.put("tenHangNhap",khoModel.getTenHang());
        contentValues.put("theLoaiHangNhap",khoModel.getTheloaihang());
        contentValues.put("soLuongNhap",khoModel.getSoLuong());
        contentValues.put("giaHangNhap",khoModel.getGia());
        contentValues.put("ngayNhap",khoModel.getNgayNhap());
        return sqLiteDatabase.update("kho_nhap",contentValues,"maHangNhap=?",new String[]{khoModel.getMaHang()});
    }

    public List<KhoModel> FindHangKhoNhap(String FindHangNhap){
        List<KhoModel> khoModels  = new ArrayList<>();
        String truyvan = "SELECT * FROM kho_nhap WHERE maHangNhap LIKE '%'" + FindHangNhap + "'%'";
        Cursor cursor = databaseDuAn1.getWritableDatabase().rawQuery(truyvan,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                String maHangNhap = cursor.getString(cursor.getColumnIndex("maHangNhap"));
                String tenHangNhap = cursor.getString(cursor.getColumnIndex("tenHangNhap"));
                String theLoaiHangNhap = cursor.getString(cursor.getColumnIndex("theLoaiHangNhap"));
                int soLuongNhap = cursor.getInt(cursor.getColumnIndex("soLuongNhap"));
                Double giaHangNhap = cursor.getDouble(cursor.getColumnIndex("giaHangNhap"));
                String ngayNhap = cursor.getString(cursor.getColumnIndex("ngayNhap"));

                KhoModel khoModel = new KhoModel();
                khoModel.setMaHang(maHangNhap);
                khoModel.setTenHang(tenHangNhap);
                khoModel.setTheloaihang(theLoaiHangNhap);
                khoModel.setSoLuong(soLuongNhap);
                khoModel.setGia(giaHangNhap);
                khoModel.setNgayNhap(ngayNhap);

                khoModels.add(khoModel);

                cursor.moveToNext();
            }
            cursor.close();
        }
        return khoModels;
    }

}
