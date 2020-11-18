package ben.study.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import ben.study.model.TheLoaiModel;

public class TheLoaiDAO {
    private DatabaseDuAn1 databaseDuAn1;

    public TheLoaiDAO (DatabaseDuAn1 databaseDuAn1){
        databaseDuAn1 = this.databaseDuAn1;
    };

    public long themTheloai(TheLoaiModel theLoaiModel){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maTheLoai",theLoaiModel.getMaTheLoai());
        contentValues.put("tenTheLoai",theLoaiModel.getTenTheLoai());
        contentValues.put("viTri",theLoaiModel.getViTri());

        return sqLiteDatabase.insert("theLoai",null,contentValues);
    };

    public long suaTheloai(TheLoaiModel theLoaiModel){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maTheLoai",theLoaiModel.getMaTheLoai());
        contentValues.put("tenTheLoai",theLoaiModel.getTenTheLoai());
        contentValues.put("viTri",theLoaiModel.getViTri());

        return sqLiteDatabase.update("theLoai",contentValues,"maTheLoai=?",new String[]{theLoaiModel.getMaTheLoai()});
    };


}
