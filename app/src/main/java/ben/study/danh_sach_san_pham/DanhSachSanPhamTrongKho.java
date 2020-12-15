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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import ben.study.adapter.AdapterDanhSachSanPhamTrongKho;
import ben.study.codeduan1.Home;
import ben.study.codeduan1.Kho;
import ben.study.codeduan1.R;
import ben.study.database.DatabaseDuAn1;
import ben.study.database.NhapKhoDAO;
import ben.study.model.KhoModel;

public class DanhSachSanPhamTrongKho extends AppCompatActivity {
    Toolbar toolbarDanhSachSanPhamTrongKho;
    ListView lvSanPhamTrongKho;
    AdapterDanhSachSanPhamTrongKho adapterDanhSachSanPhamTrongKho;
    List<KhoModel> khoModels;
    private DatabaseDuAn1 databaseDuAn1 = new DatabaseDuAn1(this);
    private NhapKhoDAO nhapKhoDAO = new NhapKhoDAO(databaseDuAn1);
    EditText edtFindSanPhamTrongKho;


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
        lvSanPhamTrongKho =findViewById(R.id.lvSanPhamTrongKho);
        khoModels =  nhapKhoDAO.getallHangKhoNhap();
        adapterDanhSachSanPhamTrongKho = new AdapterDanhSachSanPhamTrongKho(khoModels,this);
        lvSanPhamTrongKho.setAdapter(adapterDanhSachSanPhamTrongKho);
        adapterDanhSachSanPhamTrongKho.notifyDataSetChanged();
        edtFindSanPhamTrongKho = findViewById(R.id.edtFindSanPhamTrongKho);

        lvSanPhamTrongKho.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object object = khoModels.get(i);
                String hienThiDSNhap = object.toString();
                Toast.makeText(DanhSachSanPhamTrongKho.this,hienThiDSNhap,Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_dshang_trongkho,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

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

    public void timKiemSanPhamTrongKho(View view) {
        String maHangNhapKho = edtFindSanPhamTrongKho.getText().toString().trim();
        if(maHangNhapKho.isEmpty()){
            edtFindSanPhamTrongKho.setError("NHẬP DỮ LIỆU TRƯỚC");
            return;
        }

        nhapKhoDAO = new NhapKhoDAO(databaseDuAn1);
        List<KhoModel> listHangTrongKho = nhapKhoDAO.FindHangKhoNhap(maHangNhapKho);

        if(listHangTrongKho.size() == 0){
            edtFindSanPhamTrongKho.setError("KHÔNG TÌM THẤY DỮ LIỆU NÀO");
        }else {
            AdapterDanhSachSanPhamTrongKho  adapterNhapKho = new AdapterDanhSachSanPhamTrongKho(listHangTrongKho,DanhSachSanPhamTrongKho.this);
            lvSanPhamTrongKho.setAdapter(adapterNhapKho);
            adapterNhapKho.notifyDataSetChanged();
        }
    }
}