package ben.study.danh_sach_san_pham;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import ben.study.codeduan1.Home;
import ben.study.codeduan1.Kho;
import ben.study.codeduan1.R;
import ben.study.hoa_don.HoaDon;
import ben.study.hoa_don.Them_Sua_HoaDon;

public class DanhSachSanPhamTrongKho extends AppCompatActivity {
    Toolbar toolbarDanhSachSanPhamTrongKho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_san_pham_trong_kho);

        addControls();
        addEvents();
    }

    private void addEvents() {
        setSupportActionBar(toolbarDanhSachSanPhamTrongKho);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbarDanhSachSanPhamTrongKho.setNavigationIcon(R.drawable.ic_back);

        toolbarDanhSachSanPhamTrongKho.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DanhSachSanPhamTrongKho.this, Kho.class);
                startActivity(intent);
            }
        });

    }

    private void addControls() {
        toolbarDanhSachSanPhamTrongKho = findViewById(R.id.toolbarDanhSachSanPhamTrongKho);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_dshang_trongkho,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_search_dsSanPhamTrongKho:
                Toast.makeText(this,"tìm kiếm đi",Toast.LENGTH_LONG).show();
                break;
            case R.id.item_NhapSanPham:
                Intent intent = new Intent(DanhSachSanPhamTrongKho.this, Kho.class);
                startActivity(intent);
                break;
            case R.id.item_SuaNhapSanPham:
                Intent intent1 = new Intent(DanhSachSanPhamTrongKho.this,Kho.class);
                startActivity(intent1);
                break;
            case R.id.item_TrangChuNhapSanPham:
                Intent intent2 = new Intent(DanhSachSanPhamTrongKho.this, Home.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}