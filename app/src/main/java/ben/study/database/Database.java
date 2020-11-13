package ben.study.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context) {
        super(context, "quanLyTapHoa.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String kho = "CREATE TABLE kho(maHang TEXT PRIMARY KEY,tenHang TEXT,maTheLoai TEXT,soLuong INT)";
        String theLoai = "CREATE TABLE the_loai(maTheLoai TEXT PRIMARY KEY,tenTheLoai TEXT,viTri INT)";
        String hoaDon = "CREATE TABLE hoa_don(maHoaDon TEXT PRIMARY KEY,tenHang TEXT,theLoaiHang TEXT,soLuong INT,giaHang REAL,tongThanhToan REAL)";

        sqLiteDatabase.execSQL(kho);
        sqLiteDatabase.execSQL(theLoai);
        sqLiteDatabase.execSQL(hoaDon);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
