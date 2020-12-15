package ben.study.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ben.study.model.HoaDonModel;

public class HoaDonDAO {
   private DatabaseDuAn1 databaseDuAn1;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

   public HoaDonDAO(DatabaseDuAn1 databaseDuAn1){
       this.databaseDuAn1 = databaseDuAn1;

   }

    public boolean themhoadon( HoaDonModel hoaDon){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHoaDon",hoaDon.getMaHoaDon());
        contentValues.put("maHang",hoaDon.getMaHang());
        contentValues.put("tenHang",hoaDon.getTenMatHang());
        contentValues.put("theLoaiHang",hoaDon.getTheLoaiMatHang());
        contentValues.put("soLuong",hoaDon.getSoLuongMatHang());
        contentValues.put("giaHang",hoaDon.getGiaBan());
        contentValues.put("tongThanhToan",hoaDon.getTongThanhToan());
        contentValues.put("ngayMua",sdf.format(hoaDon.getNgayMua()));

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
    public List<HoaDonModel> getallhoadon(){
        List<HoaDonModel> hoadonList  = new ArrayList<>();
        String truyvan = "SELECT * FROM hoa_don";
        Cursor cursor = databaseDuAn1.getWritableDatabase().rawQuery(truyvan,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                try {
                String maHoaDon = cursor.getString(cursor.getColumnIndex("maHoaDon"));
                String maHang = cursor.getString(cursor.getColumnIndex("maHang"));
                String tenHang = cursor.getString(cursor.getColumnIndex("tenHang"));
                String theLoaiHang = cursor.getString(cursor.getColumnIndex("theLoaiHang"));
                int soLuong = cursor.getInt(cursor.getColumnIndex("soLuong"));
                double giaHang = cursor.getDouble(cursor.getColumnIndex("giaHang"));
                double tongThanhToan = cursor.getDouble(cursor.getColumnIndex("tongThanhToan"));
                String ngayMua = cursor.getString(cursor.getColumnIndex("ngayMua"));

                HoaDonModel hoaDon = new HoaDonModel();

                hoaDon.setMaHoaDon(maHoaDon);
                hoaDon.setMaHang(maHang);
                hoaDon.setTenMatHang(tenHang);
                hoaDon.setTheLoaiMatHang(theLoaiHang);
                hoaDon.setSoLuongMatHang(soLuong);
                hoaDon.setGiaBan(giaHang);
                hoaDon.setTongThanhToan(tongThanhToan);

                hoaDon.setNgayMua(sdf.parse(ngayMua));

                hoadonList.add(hoaDon);

                cursor.moveToNext();

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            cursor.close();
        }
        return hoadonList;
    }public List<HoaDonModel> findhoadon(String FindHoaDon){
        List<HoaDonModel> hoadonList  = new ArrayList<>();
        String truyvan = "SELECT * FROM hoa_don WHERE maHoaDon LIKE '%" + FindHoaDon + "%'";
        Cursor cursor = databaseDuAn1.getWritableDatabase().rawQuery(truyvan,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                try {
                String maHoaDon = cursor.getString(cursor.getColumnIndex("maHoaDon"));
                String maHang = cursor.getString(cursor.getColumnIndex("maHang"));
                String tenHang = cursor.getString(cursor.getColumnIndex("tenHang"));
                String theLoaiHang = cursor.getString(cursor.getColumnIndex("theLoaiHang"));
                int soLuong = cursor.getInt(cursor.getColumnIndex("soLuong"));
                double giaHang = cursor.getDouble(cursor.getColumnIndex("giaHang"));
                double tongThanhToan = cursor.getDouble(cursor.getColumnIndex("tongThanhToan"));
                String ngayMua = cursor.getString(cursor.getColumnIndex("ngayMua"));

                HoaDonModel hoaDon = new HoaDonModel();

                hoaDon.setMaHoaDon(maHoaDon);
                hoaDon.setMaHang(maHang);
                hoaDon.setTenMatHang(tenHang);
                hoaDon.setTheLoaiMatHang(theLoaiHang);
                hoaDon.setSoLuongMatHang(soLuong);
                hoaDon.setGiaBan(giaHang);
                hoaDon.setTongThanhToan(tongThanhToan);

                hoaDon.setNgayMua(sdf.parse(ngayMua));

                hoadonList.add(hoaDon);

                cursor.moveToNext();

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            cursor.close();
        }
        return hoadonList;
    }

    public int suahoadon(HoaDonModel hoaDon){
        SQLiteDatabase sqLiteDatabase = databaseDuAn1.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHoaDon",hoaDon.getMaHoaDon());
        contentValues.put("maHang",hoaDon.getMaHang());
        contentValues.put("tenHang",hoaDon.getTenMatHang());
        contentValues.put("theLoaiHang",hoaDon.getTheLoaiMatHang());
        contentValues.put("soLuong",hoaDon.getSoLuongMatHang());
        contentValues.put("giaHang",hoaDon.getGiaBan());
        contentValues.put("tongThanhToan",hoaDon.getTongThanhToan());
        contentValues.put("ngayMua",sdf.format(hoaDon.getNgayMua()));
        return sqLiteDatabase.update("hoa_don",contentValues,"maHoaDon=?",new String[]{hoaDon.getMaHoaDon()});
    }

    public List<HoaDonModel> top10BanChay(){
        List<HoaDonModel> hoadonList  = new ArrayList<>();
        String truyvan = "SELECT * FROM hoa_don WHERE soLuong > 0 ORDER BY soLuong DESC LIMIT 10";
        Cursor cursor = databaseDuAn1.getWritableDatabase().rawQuery(truyvan,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                try {
                String maHoaDon = cursor.getString(cursor.getColumnIndex("maHoaDon"));
                String maHang = cursor.getString(cursor.getColumnIndex("maHang"));
                String tenHang = cursor.getString(cursor.getColumnIndex("tenHang"));
                String theLoaiHang = cursor.getString(cursor.getColumnIndex("theLoaiHang"));
                int soLuong = cursor.getInt(cursor.getColumnIndex("soLuong"));
                double giaHang = cursor.getDouble(cursor.getColumnIndex("giaHang"));
                double tongThanhToan = cursor.getDouble(cursor.getColumnIndex("tongThanhToan"));
                String ngayMuaHoaDon = cursor.getString(cursor.getColumnIndex("ngayMua"));

                HoaDonModel hoaDon = new HoaDonModel();
                hoaDon.setMaHoaDon(maHoaDon);
                hoaDon.setMaHang(maHang);
                hoaDon.setTenMatHang(tenHang);
                hoaDon.setTheLoaiMatHang(theLoaiHang);
                hoaDon.setSoLuongMatHang(soLuong);
                hoaDon.setGiaBan(giaHang);
                hoaDon.setTongThanhToan(tongThanhToan);

                hoaDon.setNgayMua(sdf.parse(ngayMuaHoaDon));


                hoadonList.add(hoaDon);
                cursor.moveToNext();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            cursor.close();
        }
        return hoadonList;
    }


    public double getDoanhThuTheoNgay(){
       double doanhThu = 0;

       String truyVan = "SELECT SUM(tongThanhToan) FROM hoa_don WHERE hoa_don.ngayMua = date('now')";
       Cursor cursor = databaseDuAn1.getWritableDatabase().rawQuery(truyVan,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            doanhThu = cursor.getDouble(0);
            cursor.moveToNext();
        }
        cursor.close();
        return doanhThu;
    }

    public double getDoanhThuTheoThang(){
        double doanhThu = 0;

        String truyVan = "SELECT SUM(tongThanhToan) FROM hoa_don WHERE strftime('%m',hoa_don.ngayMua) = strftime('%m','now')";
        Cursor cursor = databaseDuAn1.getWritableDatabase().rawQuery(truyVan,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            doanhThu = cursor.getDouble(0);
            cursor.moveToNext();
        }
        cursor.close();
        return doanhThu;
    }

    public double getDoanhThuTheoNam(){
        double doanhThu = 0;

        String truyVan = "SELECT SUM(tongThanhToan) FROM hoa_don WHERE strftime('%Y',hoa_don.ngayMua) = strftime('%Y','now')";
        Cursor cursor = databaseDuAn1.getWritableDatabase().rawQuery(truyVan,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            doanhThu = cursor.getDouble(0);
            cursor.moveToNext();
        }
        cursor.close();
        return doanhThu;
    }
}
