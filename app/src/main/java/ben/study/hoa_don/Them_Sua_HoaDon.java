package ben.study.hoa_don;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ben.study.codeduan1.R;
import ben.study.database.DatabaseDuAn1;
import ben.study.database.HoaDonDAO;
import ben.study.database.TheLoaiDAO;
import ben.study.model.HoaDonModel;
import ben.study.model.TheLoaiModel;

public class Them_Sua_HoaDon extends AppCompatActivity {
    EditText edtMaHoaDon,edtTenMatHangHoaDon,edtGiaHangHoaDon,edtSoLuongHangHoaDon,edtTongTienHoaDon,edtNgayMuaHoaDon;
    Button btnNgayMuaHoaDon,btnThemHoaDon,btnSuaHoaDon;
    DatabaseDuAn1 databaseDuAn1;
    HoaDonDAO hoaDonDAO;
    TheLoaiDAO theLoaiDAO;

    Spinner spinnerTheLoai;
    List<TheLoaiModel> listTheLoai = new ArrayList<>();
    ArrayAdapter<TheLoaiModel> adapterSpTheLoai ;

    String theLoaiHang = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them__sua__hoa_don);

        databaseDuAn1 = new DatabaseDuAn1(this);
        hoaDonDAO = new HoaDonDAO(databaseDuAn1);
        theLoaiDAO = new TheLoaiDAO(databaseDuAn1);

        addControls();
        addEvents();

    }

    private void addEvents() {

    }

    private void addControls() {
        edtMaHoaDon = findViewById(R.id.edtMaHoaDon);
        edtTenMatHangHoaDon = findViewById(R.id.edtTenMatHangHoaDon);
        edtGiaHangHoaDon = findViewById(R.id.edtGiaHangHoaDon);
        edtSoLuongHangHoaDon = findViewById(R.id.edtSoLuongHangHoaDon);
        edtTongTienHoaDon = findViewById(R.id.edtTongTienHoaDon);
        edtNgayMuaHoaDon = findViewById(R.id.edtNgayMuaHoaDon);


        btnNgayMuaHoaDon = findViewById(R.id.btnNgayMuaHoaDon);
        btnThemHoaDon = findViewById(R.id.btnThemHoaDon);
        btnSuaHoaDon = findViewById(R.id.btnSuaHoaDon);

        spinnerTheLoai = findViewById(R.id.spinnerTheLoai);
        listTheLoai = theLoaiDAO.getAllTheLoai();
        adapterSpTheLoai = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listTheLoai);
        adapterSpTheLoai.setDropDownViewResource(android.R.layout.activity_list_item);
        spinnerTheLoai.setAdapter(adapterSpTheLoai);
        adapterSpTheLoai.notifyDataSetChanged();

        spinnerTheLoai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                theLoaiHang = listTheLoai.get(spinnerTheLoai.getSelectedItemPosition()).getMaTheLoai();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void NgayMua(View view) {
        Calendar ngayMua = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String date =i2 + "/" + (i1 +1) + "/" +i ;
                edtNgayMuaHoaDon.setText(date);
            }
        },ngayMua.get(ngayMua.YEAR),ngayMua.get(ngayMua.MONTH),ngayMua.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public void xuLyThemHoaDon(View view) {
        String maHoaDon = edtMaHoaDon.getText().toString();
        String tenMatHang = edtTenMatHangHoaDon.getText().toString();
        double giaBan = Double.parseDouble(edtGiaHangHoaDon.getText().toString());
        int soLuongHang = Integer.parseInt(edtSoLuongHangHoaDon.getText().toString());
        double tongTienHoaDon = Double.parseDouble(edtTongTienHoaDon.getText().toString());
        String ngayMuaHoaDon = edtNgayMuaHoaDon.getText().toString();

        HoaDonModel hoaDonModel = new HoaDonModel();

        hoaDonModel.setMaHoaDon(maHoaDon);
        hoaDonModel.setTenMatHang(tenMatHang);
        hoaDonModel.setTheLoaiMatHang(theLoaiHang);
        hoaDonModel.setGiaBan(giaBan);
        hoaDonModel.setSoLuongMatHang(soLuongHang);
        hoaDonModel.setTongThanhToan(tongTienHoaDon);
        hoaDonModel.setNgayMua(ngayMuaHoaDon);

        hoaDonDAO.themhoadon(hoaDonModel);

        checkEmpty(hoaDonModel.getMaHoaDon(),edtMaHoaDon);
        checkEmpty(hoaDonModel.getTenMatHang(),edtTenMatHangHoaDon);
        checkEmpty(String.valueOf(hoaDonModel.getGiaBan()),edtGiaHangHoaDon);
        checkEmpty(String.valueOf(hoaDonModel.getSoLuongMatHang()),edtSoLuongHangHoaDon);
        checkEmpty(String.valueOf(hoaDonModel.getTongThanhToan()),edtTongTienHoaDon);
        checkEmpty(hoaDonModel.getNgayMua(),edtNgayMuaHoaDon);

        if(validation() < 0){
            Toast.makeText(Them_Sua_HoaDon.this,"nhập đầy đủ thông tin",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(Them_Sua_HoaDon.this,"nhập thành công",Toast.LENGTH_LONG).show();
        }




    }

    public int validation(){
        if(edtMaHoaDon.getText().toString().isEmpty() || edtTenMatHangHoaDon.getText().toString().isEmpty() || edtGiaHangHoaDon.getText().toString().isEmpty() ||
                edtSoLuongHangHoaDon.getText().toString().isEmpty() ||edtTongTienHoaDon.getText().toString().isEmpty() ||edtNgayMuaHoaDon.getText().toString().isEmpty()){
            return -1;
        }else {
            return 0;
        }
    }

    public void xuLySuaHoaDon(View view) {
    }

    public void checkEmpty(String data, EditText edt){
        if (data.isEmpty()) {
//            edt.setError(" Vui lòng nhập đủ thông tin ... ");
            return;
        }
    }


}