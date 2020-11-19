package ben.study.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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

    public void xoaTheLoai(String id){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        sqLiteDatabase.delete("theLoai","maTheLoai=?",new String[]{id});
    }

    public List<TheLoaiModel> getAllTheLoai(){
        List<TheLoaiModel> listTheLoai = new ArrayList<>();

        String truyVan = "SELECT * FROM the_loai";
        Cursor cursor = databaseDuAn1.getWritableDatabase().rawQuery(truyVan,null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                String maTheLoai = cursor.getString(cursor.getColumnIndex("maTheLoai"));
                String tenTheLoai = cursor.getString(cursor.getColumnIndex("tenTheLoai"));
                int viTri = cursor.getInt(cursor.getColumnIndex("viTri"));

                TheLoaiModel theLoaiModel = new TheLoaiModel();
                theLoaiModel.setMaTheLoai(maTheLoai);
                theLoaiModel.setTenTheLoai(tenTheLoai);
                theLoaiModel.setViTri(viTri);

                listTheLoai.add(theLoaiModel);

                cursor.moveToNext();
            }
            cursor.close();
        }
        return listTheLoai;
    }

    public List<TheLoaiModel> find_Data(String SearchTheLoai){
        List<TheLoaiModel> list_theLoai = new ArrayList<>();
        String truy_van = "SELECT * FROM the_loai WHERE maTheLoai LIKE %" + SearchTheLoai + "%";
        Cursor cursor = databaseDuAn1.getWritableDatabase().rawQuery(truy_van,null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                String maTheLoai = cursor.getString(cursor.getColumnIndex("maTheLoai"));
                String tenTheLoai = cursor.getString(cursor.getColumnIndex("tenTheLoai"));
                int viTri = cursor.getInt(cursor.getColumnIndex("viTri"));

                TheLoaiModel theLoaiModel = new TheLoaiModel();
                theLoaiModel.setMaTheLoai(maTheLoai);
                theLoaiModel.setTenTheLoai(tenTheLoai);
                theLoaiModel.setViTri(viTri);

                list_theLoai.add(theLoaiModel);

                cursor.moveToNext();
            }
            cursor.close();
        }
        return list_theLoai;
    }


}
