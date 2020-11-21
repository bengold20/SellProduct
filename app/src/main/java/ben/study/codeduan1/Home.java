package ben.study.codeduan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ben.study.danh_sach_san_pham.DanhSachSanPham;
import ben.study.hoa_don.HoaDon;
import ben.study.theLoai.TheLoaiScreen;
import ben.study.thong_ke.DanhSachBanChay;
import ben.study.thong_ke.ThongKe;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void kho(View view) {
        Intent intent = new Intent(Home.this,kho.class);
        startActivity(intent);
    }

    public void the_loai(View view) {
        Intent intent = new Intent(Home.this, TheLoaiScreen.class);
        startActivity(intent);
    }


    public void HoaDon(View view) {
        Intent intent = new Intent(Home.this, HoaDon.class);
        startActivity(intent);
    }

    public void DanhSachSanPham(View view) {
        Intent intent = new Intent(Home.this, DanhSachSanPham.class);
        startActivity(intent);
    }

    public void SanPhamBanChay(View view) {
        Intent intent = new Intent(Home.this, DanhSachBanChay.class);
        startActivity(intent);
    }

    public void ThongKe(View view) {
        Intent intent = new Intent(Home.this, ThongKe.class);
        startActivity(intent);
    }
}