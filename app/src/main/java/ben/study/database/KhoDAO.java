package ben.study.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import ben.study.model.KhoModel;

public class KhoDAO {
    private DatabaseDuAn1 databaseDuAn1;

    public KhoDAO (DatabaseDuAn1 databaseDuAn1){this.databaseDuAn1 = databaseDuAn1;}

    public long nhapKho(KhoModel khoModel){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHang",khoModel.getMaHang());
        contentValues.put("tenHang",khoModel.getTenHang());
        contentValues.put("maTheLoai",khoModel.getMaTheLoai());
        contentValues.put("soLuong",khoModel.getSoLuong());
        contentValues.put("ngayNhap",khoModel.getNgayNhap());

        return sqLiteDatabase.insert("kho",null,contentValues);
    }

    public long xuatKho(KhoModel khoModel){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHang",khoModel.getMaHang());
        contentValues.put("tenHang",khoModel.getTenHang());
        contentValues.put("maTheLoai",khoModel.getMaTheLoai());
        contentValues.put("soLuong",khoModel.getSoLuong());
        contentValues.put("ngayXuat",khoModel.getNgayXuat());

        return sqLiteDatabase.insert("kho",null,contentValues);
    }

    public long suaNhapKho(KhoModel khoModel){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHang",khoModel.getMaHang());
        contentValues.put("tenHang",khoModel.getTenHang());
        contentValues.put("maTheLoai",khoModel.getMaTheLoai());
        contentValues.put("soLuong",khoModel.getSoLuong());
        contentValues.put("ngayNhap",khoModel.getNgayNhap());

        return sqLiteDatabase.update("kho",contentValues,"maHang=?",new String[]{khoModel.getMaHang()});
    }


}
