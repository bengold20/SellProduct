package ben.study.theLoai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ben.study.adapter.AdapterDanhSachSanPham;
import ben.study.adapter.AdapterTheLoai;
import ben.study.codeduan1.Home;
import ben.study.codeduan1.R;
import ben.study.danh_sach_san_pham.DanhSachSanPham;
import ben.study.database.DatabaseDuAn1;
import ben.study.database.TheLoaiDAO;
import ben.study.database.XuatKhoDAO;
import ben.study.hoa_don.HoaDon;
import ben.study.model.KhoModel;
import ben.study.model.TheLoaiModel;

public class TheLoaiScreen extends AppCompatActivity {
    Toolbar toolbar_theLoai;
    private ListView lvDanhSachTheLoai;
    private ArrayList<TheLoaiModel> theLoaiModels ;
    private DatabaseDuAn1 databaseDuAn1 = new DatabaseDuAn1(this);
    private TheLoaiDAO theLoaiDAO = new TheLoaiDAO(databaseDuAn1);
    EditText edtFindTheLoai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai_screen);
        addControls();
        addEvents();
    }

    private void addEvents() {
        setSupportActionBar(toolbar_theLoai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar_theLoai.setNavigationIcon(R.drawable.ic_back);

        toolbar_theLoai.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(TheLoaiScreen.this, Home.class);
                startActivity(intent2);
            }
        });

    }

    private void addControls() {
        toolbar_theLoai = findViewById(R.id.toolbarTheLoai);
        lvDanhSachTheLoai = findViewById(R.id.lvDanhSachTheLoai);
        theLoaiModels = (ArrayList<TheLoaiModel>) theLoaiDAO.getAllTheLoai();
        AdapterTheLoai adapterTheLoai = new AdapterTheLoai(theLoaiModels,TheLoaiScreen.this);
        lvDanhSachTheLoai.setAdapter(adapterTheLoai);
        adapterTheLoai.notifyDataSetChanged();
        edtFindTheLoai = findViewById(R.id.edtFindTheLoai);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_theloai,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_search_theloai:
                Toast.makeText(this,"tìm kiếm đi",Toast.LENGTH_LONG).show();
            break;
            case R.id.item_ThemTheLoai:
                Intent intent = new Intent(TheLoaiScreen.this,ThemSua_TheLoai.class);
                startActivity(intent);
                break;
            case R.id.item_SuaTheLoai:
                Intent intent1 = new Intent(TheLoaiScreen.this,ThemSua_TheLoai.class);
                startActivity(intent1);
                break;
            case R.id.item_TrangChuTheLoai:
                Intent intent2 = new Intent(TheLoaiScreen.this, Home.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void timKiemTheLoai(View view) {
        String TheLoai = edtFindTheLoai.getText().toString().trim();
        if(TheLoai.isEmpty()){
            edtFindTheLoai.setError("NHẬP DỮ LIỆU TRƯỚC");
            return;
        }

        theLoaiDAO = new TheLoaiDAO(databaseDuAn1);
        List<TheLoaiModel> listTheLoai = theLoaiDAO.FindTheLoai(TheLoai);

        if(listTheLoai.size() == 0){
            edtFindTheLoai.setError("KHÔNG TÌM THẤY DỮ LIỆU NÀO");
        }else {
            AdapterTheLoai adapterNhapKho = new AdapterTheLoai((ArrayList<TheLoaiModel>) listTheLoai, TheLoaiScreen.this);
            lvDanhSachTheLoai.setAdapter(adapterNhapKho);
            adapterNhapKho.notifyDataSetChanged();
        }
    }
}


