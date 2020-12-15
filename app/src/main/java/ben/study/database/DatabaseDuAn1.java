package ben.study.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseDuAn1 extends SQLiteOpenHelper {
    public DatabaseDuAn1(@Nullable Context context) {
        super(context, "quanLyTapHoa1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String khoxuat = "CREATE TABLE kho_xuat(maHangXuat TEXT PRIMARY KEY,tenHangXuat TEXT,theLoaiHangXuat TEXT,giaHangXuat DOUBLE,soLuongXuat INT," +
                "ngayXuat Text,ngayNhap Text)";
        String khonhap = "CREATE TABLE kho_nhap(maHangNhap TEXT PRIMARY KEY,tenHangNhap TEXT,theLoaiHangNhap TEXT,giaHangNhap DOUBLE,soLuongNhap INT,ngayNhap Text)";
        String theLoai = "CREATE TABLE the_loai(maTheLoai nvchar PRIMARY KEY,tenTheLoai TEXT,viTri interger)";
        String hoaDon = "CREATE TABLE hoa_don(maHoaDon TEXT PRIMARY KEY,tenHang TEXT,theLoaiHang TEXT,soLuong INT,giaHang REAL,tongThanhToan REAL)";
        sqLiteDatabase.execSQL(khoxuat);
        sqLiteDatabase.execSQL(khonhap);
        sqLiteDatabase.execSQL(theLoai);
        sqLiteDatabase.execSQL(hoaDon);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
