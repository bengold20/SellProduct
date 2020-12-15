package ben.study.thong_ke;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ben.study.adapter.AdapterDSTop10;
import ben.study.codeduan1.Home;
import ben.study.codeduan1.R;
import ben.study.database.DatabaseDuAn1;
import ben.study.database.HoaDonDAO;
import ben.study.model.HoaDonModel;
import ben.study.model.KhoModel;
import ben.study.theLoai.TheLoaiScreen;

public class ThongKe extends AppCompatActivity {
    Toolbar toolbarThongKe;
    TextView txtDoanhThuNgay,txtDoanhThuThang,txtDoanhThuNam;

    //thống kê 10 sản phẩm bán chạy
    ListView lvDanhsachsanphambanchay;
    List<HoaDonModel> listHoaDon;
    AdapterDSTop10 adapterDSTop10;
    DatabaseDuAn1 databaseDuAn1;
    HoaDonDAO hoaDonDAO;

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    Object object,object1;
    Date ngayMuaHoaDon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);

        databaseDuAn1 = new DatabaseDuAn1(this);
        hoaDonDAO = new HoaDonDAO(databaseDuAn1);

        addControls();
        addEvents();
    }



    private void addEvents() {
        setSupportActionBar(toolbarThongKe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbarThongKe.setNavigationIcon(R.drawable.ic_back);

        toolbarThongKe.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ThongKe.this, Home.class);
                startActivity(intent2);
            }
        });

    }

    private void addControls() {
        toolbarThongKe = findViewById(R.id.toolbarThongKe);
        lvDanhsachsanphambanchay = findViewById(R.id.lvDanhsachsanphambanchay);
        listHoaDon = hoaDonDAO.top10BanChay();
        adapterDSTop10 = new AdapterDSTop10(listHoaDon, ThongKe.this);
        lvDanhsachsanphambanchay.setAdapter(adapterDSTop10);
        adapterDSTop10.notifyDataSetChanged();

        lvDanhsachsanphambanchay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object object = listHoaDon.get(i);
                String a = object.toString();

                Toast.makeText(ThongKe.this, a, Toast.LENGTH_LONG).show();
            }
        });

        //thống kê theo ngày
//        try {
        txtDoanhThuNgay = findViewById(R.id.txtDoanhThuNgay);
        txtDoanhThuThang = findViewById(R.id.txtDoanhThuThang);
        txtDoanhThuNam = findViewById(R.id.txtDoanhThuNam);

        txtDoanhThuNgay.setText(hoaDonDAO.getDoanhThuTheoNgay() + " VND");
        txtDoanhThuThang.setText(hoaDonDAO.getDoanhThuTheoThang() + " VND");
        txtDoanhThuNam.setText(hoaDonDAO.getDoanhThuTheoNam() + " VND");

    }
}