package ben.study.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ben.study.model.HoaDon;

public class HoaDonDAO {
   private DatabaseDuAn1 databaseDuAn1;
   private  Context context;
   public HoaDonDAO(DatabaseDuAn1 databaseDuAn1){
       this.databaseDuAn1 = databaseDuAn1;
       this.context = context;
   }

    public boolean themhoadon( HoaDon hoaDon){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHoaDon",hoaDon.getMaHoaDon());
        contentValues.put("tenHang",hoaDon.getTenMatHang());
        contentValues.put("theLoaiHang",hoaDon.getTheLoaiMatHang());
        contentValues.put("soLuong",hoaDon.getSoLuongMatHang());
        contentValues.put("giaHang",hoaDon.getGiaBan());
        contentValues.put("tongThanhToan",hoaDon.getTongThanhToan());

        long kq =  sqLiteDatabase.insert("hoa_don",null,contentValues);
        if (kq > 0) return true;
        else return false;
    }
    public boolean xoahoadon(String maHoaDon){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        long kq =  sqLiteDatabase.delete("hoa_don","maHoaDon=?",new String[]{maHoaDon});
        if (kq > 0) return true;
        else return false;
    }
    public List<HoaDon> getallhoadon(){
        List<HoaDon> hoadonList  = new ArrayList<>();
        String truyvan = "SELECT * FROM hoa_don";
        Cursor cursor = databaseDuAn1.getWritableDatabase().rawQuery(truyvan,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                String maHoaDon = cursor.getString(cursor.getColumnIndex("maHoaDon"));
                String tenHang = cursor.getString(cursor.getColumnIndex("tenHang"));
                String theLoaiHang = cursor.getString(cursor.getColumnIndex("theLoaiHang"));
                int soLuong = cursor.getInt(cursor.getColumnIndex("soLuong"));
                double giaHang = cursor.getDouble(cursor.getColumnIndex("giaHang"));
                double tongThanhToan = cursor.getDouble(cursor.getColumnIndex("tongThanhToan"));

                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(maHoaDon);
                hoaDon.setTenMatHang(tenHang);
                hoaDon.setTheLoaiMatHang(theLoaiHang);
                hoaDon.setSoLuongMatHang(soLuong);
                hoaDon.setGiaBan(giaHang);
                hoaDon.setTongThanhToan(tongThanhToan);

                hoadonList.add(hoaDon);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return hoadonList;
    }

    public int suahoadon(HoaDon hoaDon){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHoaDon",hoaDon.getMaHoaDon());
        contentValues.put("tenHang",hoaDon.getTenMatHang());
        contentValues.put("theLoaiHang",hoaDon.getTheLoaiMatHang());
        contentValues.put("soLuong",hoaDon.getSoLuongMatHang());
        contentValues.put("giaHang",hoaDon.getGiaBan());
        contentValues.put("tongThanhToan",hoaDon.getTongThanhToan());
        return sqLiteDatabase.update("hoa_don",contentValues,"maHoaDon=?",new String[]{hoaDon.getMaHoaDon()});
    }

}
