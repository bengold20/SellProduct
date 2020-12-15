package ben.study.hoa_don;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ben.study.adapter.AdapterHoaDon;
import ben.study.adapter.AdapterTheLoai;
import ben.study.codeduan1.Home;
import ben.study.codeduan1.R;
import ben.study.database.DatabaseDuAn1;
import ben.study.database.HoaDonDAO;
import ben.study.database.TheLoaiDAO;
import ben.study.model.HoaDonModel;
import ben.study.model.TheLoaiModel;
import ben.study.theLoai.TheLoaiScreen;
import ben.study.theLoai.ThemSua_TheLoai;

public class HoaDon extends AppCompatActivity {
    EditText edtFindHoaDon;
    Toolbar toolbarHoaDon;
    private ListView lvDanhSachHoaDon;
    private ArrayList<HoaDonModel> listHoaDon ;
    private DatabaseDuAn1 databaseDuAn1 = new DatabaseDuAn1(this);
    private HoaDonDAO hoaDonDAO = new HoaDonDAO(databaseDuAn1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);

        addControls();
        addEvents();
    }

    private void addEvents() {
        setSupportActionBar(toolbarHoaDon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbarHoaDon.setNavigationIcon(R.drawable.ic_back);

        toolbarHoaDon.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(HoaDon.this, Home.class);
                startActivity(intent2);
            }
        });

    }

    private void addControls() {
        edtFindHoaDon = findViewById(R.id.edtFindHoaDon);
        toolbarHoaDon = findViewById(R.id.toolbarHoaDon);
        lvDanhSachHoaDon = findViewById(R.id.lvDanhSachHoaDon);
        listHoaDon = (ArrayList<HoaDonModel>) hoaDonDAO.getallhoadon();
        AdapterHoaDon adapterHoaDon = new AdapterHoaDon(listHoaDon,this);
        lvDanhSachHoaDon.setAdapter(adapterHoaDon);
        adapterHoaDon.notifyDataSetChanged();

        lvDanhSachHoaDon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object object = listHoaDon.get(i);
                String showHoaDon = object.toString();
                Toast.makeText(HoaDon.this,showHoaDon,Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_hoadon,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_ThemHoaDon:
                Intent intent = new Intent(HoaDon.this, Them_Sua_HoaDon.class);
                startActivity(intent);
                break;
            case R.id.item_SuaHoaDon:
                Intent intent1 = new Intent(HoaDon.this,Them_Sua_HoaDon.class);
                startActivity(intent1);
                break;
            case R.id.item_TrangChuHoaDon:
                Intent intent2 = new Intent(HoaDon.this, Home.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void timKiemHoaDon(View view) {
        String hoaDon = edtFindHoaDon.getText().toString().trim();
        if(hoaDon.isEmpty()){
            edtFindHoaDon.setError("NHẬP DỮ LIỆU TRƯỚC");
            return;
        }

        hoaDonDAO = new HoaDonDAO(databaseDuAn1);
        List<HoaDonModel> listHoaDon = hoaDonDAO.findhoadon(hoaDon);

        if(listHoaDon.size() == 0){
            edtFindHoaDon.setError("KHÔNG TÌM THẤY DỮ LIỆU NÀO");
        }else {
            AdapterHoaDon adapterHoaDon = new AdapterHoaDon((ArrayList<HoaDonModel>) listHoaDon, HoaDon.this);
            lvDanhSachHoaDon.setAdapter(adapterHoaDon);
            adapterHoaDon.notifyDataSetChanged();
        }
    }
}