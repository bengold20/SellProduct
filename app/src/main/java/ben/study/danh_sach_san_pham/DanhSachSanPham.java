package ben.study.danh_sach_san_pham;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import ben.study.adapter.AdapterDanhSachSanPham;
import ben.study.codeduan1.Home;
import ben.study.codeduan1.Kho;
import ben.study.codeduan1.R;
import ben.study.database.DatabaseDuAn1;
import ben.study.database.XuatKhoDAO;
import ben.study.model.KhoModel;
import ben.study.theLoai.TheLoaiScreen;
import ben.study.theLoai.ThemSua_TheLoai;

public class DanhSachSanPham extends AppCompatActivity {
    Toolbar toolbarDanhSachSanPham;
    ListView lvDanhSachSanPham ;
    ArrayList<KhoModel> khoModels ;
    AdapterDanhSachSanPham adapterDanhSachSanPham;
    private DatabaseDuAn1 databaseDuAn1 = new DatabaseDuAn1( this );
    private XuatKhoDAO xuatKhoDAO = new XuatKhoDAO(databaseDuAn1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_san_pham);

        addControls();
        addEvents();
    }

    private void addEvents() {
        setSupportActionBar(toolbarDanhSachSanPham);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbarDanhSachSanPham.setNavigationIcon(R.drawable.ic_back);

        toolbarDanhSachSanPham.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(DanhSachSanPham.this, Kho.class);
                startActivity(intent2);
            }
        });

    }

    private void addControls() {
        toolbarDanhSachSanPham = findViewById(R.id.toolbarDanhSachSanPham);
        lvDanhSachSanPham = findViewById(R.id.lvDanhSachSanPham);
        khoModels = (ArrayList<KhoModel>) xuatKhoDAO.getallHangKhoxuat();
        adapterDanhSachSanPham = new AdapterDanhSachSanPham(khoModels , this);
        lvDanhSachSanPham.setAdapter(adapterDanhSachSanPham);
        adapterDanhSachSanPham.notifyDataSetChanged();

        //onclick listview
        lvDanhSachSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object object = khoModels.get(i);
                String hienThi = object.toString();
                Toast.makeText(DanhSachSanPham.this,hienThi,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_danhsach_sanpham,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_search_dsSanPham:
                Toast.makeText(this,"tìm kiếm đi",Toast.LENGTH_LONG).show();
                break;
            case R.id.item_XuatSanPham:
                Intent intent = new Intent(DanhSachSanPham.this, Kho.class);
                startActivity(intent);
                break;
            case R.id.item_SuaXuatSanPham:
                Intent intent1 = new Intent(DanhSachSanPham.this,Kho.class);
                startActivity(intent1);
                break;
            case R.id.item_TrangChuXuatSanPham:
                Intent intent2 = new Intent(DanhSachSanPham.this, Home.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}