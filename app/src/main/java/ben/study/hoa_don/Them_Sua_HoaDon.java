package ben.study.hoa_don;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ben.study.adapter.AdapterDanhSachSanPham;
import ben.study.codeduan1.Kho;
import ben.study.codeduan1.R;
import ben.study.database.DatabaseDuAn1;
import ben.study.database.HoaDonDAO;
import ben.study.database.TheLoaiDAO;
import ben.study.database.XuatKhoDAO;
import ben.study.model.HoaDonModel;
import ben.study.model.KhoModel;
import ben.study.model.TheLoaiModel;

public class Them_Sua_HoaDon extends AppCompatActivity {
    EditText edtMaHoaDon,edtmaHangHoaDon,edtTenMatHangHoaDon,edtGiaHangHoaDon,edtSoLuongHangHoaDon,edtNgayMuaHoaDon,edtTheLoaisp_hoaDon;
    Button btnNgayMuaHoaDon,btnThemHoaDon,btnSuaHoaDon;
    DatabaseDuAn1 databaseDuAn1;
    HoaDonDAO hoaDonDAO;
    TheLoaiDAO theLoaiDAO;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    //sửa hàng trong xuất kho
    List<KhoModel> listXuatKho;
    Object maHangXuat,tenHangXuat,theLoaiXuat,giaHangXuat,soLuongXuat,ngayXuat,ngayNhap;
    String maHangXuat1,tenHangXuat1,theLoaiXuat1,ngayXuat1,ngayNhap1;
    Integer soLuongXuat1;
    Double giaHangXuat1;
    XuatKhoDAO xuatKhoDAO;
    ListView lvFindDsXuatKho_hoaDon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them__sua__hoa_don);

        databaseDuAn1 = new DatabaseDuAn1(this);
        hoaDonDAO = new HoaDonDAO(databaseDuAn1);
        theLoaiDAO = new TheLoaiDAO(databaseDuAn1);
        xuatKhoDAO = new XuatKhoDAO(databaseDuAn1);

        addControls();
        addEvents();

    }

    private void addEvents() {

    }

    private void addControls() {
        edtMaHoaDon = findViewById(R.id.edtMaHoaDon);
        edtTenMatHangHoaDon = findViewById(R.id.edtTenMatHangHoaDon);
        edtTheLoaisp_hoaDon = findViewById(R.id.edtTheLoaisp_hoaDon);
        edtGiaHangHoaDon = findViewById(R.id.edtGiaHangHoaDon);
        edtSoLuongHangHoaDon = findViewById(R.id.edtSoLuongHangHoaDon);
        edtNgayMuaHoaDon = findViewById(R.id.edtNgayMuaHoaDon);
        edtmaHangHoaDon = findViewById(R.id.edtmaHangHoaDon);


        btnNgayMuaHoaDon = findViewById(R.id.btnNgayMuaHoaDon);
        btnThemHoaDon = findViewById(R.id.btnThemHoaDon);
        btnSuaHoaDon = findViewById(R.id.btnSuaHoaDon);

        //tìm thông tin trong xuất kho
        lvFindDsXuatKho_hoaDon = findViewById(R.id.lvFindDsXuatKho_hoaDon);
        listXuatKho = xuatKhoDAO.getallHangKhoxuat();
        AdapterDanhSachSanPham adapterspTrongKho = new AdapterDanhSachSanPham((ArrayList<KhoModel>) listXuatKho,Them_Sua_HoaDon.this);
        lvFindDsXuatKho_hoaDon.setAdapter(adapterspTrongKho);
        adapterspTrongKho.notifyDataSetChanged();

        lvFindDsXuatKho_hoaDon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                maHangXuat = listXuatKho.get(i).getMaHang();
                tenHangXuat = listXuatKho.get(i).getTenHang();
                theLoaiXuat = listXuatKho.get(i).getTheloaihang();
                giaHangXuat = listXuatKho.get(i).getGia();
                soLuongXuat = listXuatKho.get(i).getSoLuong();
                ngayXuat = listXuatKho.get(i).getNgayXuat();
                ngayNhap = listXuatKho.get(i).getNgayNhap();

                maHangXuat1 = maHangXuat.toString();
                tenHangXuat1 = tenHangXuat.toString();
                theLoaiXuat1 = theLoaiXuat.toString();
                giaHangXuat1 = Double.parseDouble(giaHangXuat.toString());
                soLuongXuat1 = Integer.parseInt(soLuongXuat.toString());
                ngayXuat1 = ngayXuat.toString();
                ngayNhap1 = ngayNhap.toString();

                edtmaHangHoaDon.setText(maHangXuat1);
                edtTenMatHangHoaDon.setText(tenHangXuat1);
                edtTheLoaisp_hoaDon.setText(theLoaiXuat1);
                edtGiaHangHoaDon.setText(String.valueOf(giaHangXuat1));

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
        try {
        String maHoaDon = edtMaHoaDon.getText().toString();
        String maHang = edtmaHangHoaDon.getText().toString();
        String tenMatHang = edtTenMatHangHoaDon.getText().toString();
        String theloaiHang = edtTheLoaisp_hoaDon.getText().toString();
        double giaBan = Double.parseDouble(edtGiaHangHoaDon.getText().toString());
        int soLuongHang = Integer.parseInt(edtSoLuongHangHoaDon.getText().toString());

        Date ngayMuaHoaDon = sdf.parse(edtNgayMuaHoaDon.getText().toString());


        Double tongTienHoaDon = giaBan * soLuongHang;

        HoaDonModel hoaDonModel = new HoaDonModel();

        hoaDonModel.setMaHoaDon(maHoaDon);
        hoaDonModel.setMaHang(maHang);
        hoaDonModel.setTenMatHang(tenMatHang);
        hoaDonModel.setTheLoaiMatHang(theloaiHang);
        hoaDonModel.setGiaBan(giaBan);
        hoaDonModel.setSoLuongMatHang(soLuongHang);
        hoaDonModel.setTongThanhToan(tongTienHoaDon);
        hoaDonModel.setNgayMua(ngayMuaHoaDon);

        hoaDonDAO.themhoadon(hoaDonModel);

        checkEmpty(hoaDonModel.getMaHoaDon(),edtMaHoaDon);
        checkEmpty(hoaDonModel.getTenMatHang(),edtTenMatHangHoaDon);
        checkEmpty(String.valueOf(hoaDonModel.getGiaBan()),edtGiaHangHoaDon);
        checkEmpty(String.valueOf(hoaDonModel.getSoLuongMatHang()),edtSoLuongHangHoaDon);
        checkEmpty(String.valueOf(hoaDonModel.getNgayMua()),edtNgayMuaHoaDon);

//      thay đổi dữ liệu trong kho
        KhoModel khoModel = new KhoModel();

        Integer capNhatSoLuongTrongKhoXuat = soLuongXuat1 - Integer.parseInt(edtSoLuongHangHoaDon.getText().toString());

        khoModel.setMaHang(maHangXuat1);
        khoModel.setTenHang(tenHangXuat1);
        khoModel.setTheloaihang(theLoaiXuat1);
        khoModel.setGia(giaHangXuat1);
        khoModel.setSoLuong(capNhatSoLuongTrongKhoXuat);
        khoModel.setNgayXuat(ngayXuat1);
        khoModel.setNgayNhap(ngayNhap1);

        xuatKhoDAO.suaHangxuat(khoModel);


        if(validation() < 0){
            Toast.makeText(Them_Sua_HoaDon.this,"nhập đầy đủ thông tin",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(Them_Sua_HoaDon.this,"nhập thành công",Toast.LENGTH_LONG).show();
        }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public int validation(){
        if(edtMaHoaDon.getText().toString().isEmpty() || edtTenMatHangHoaDon.getText().toString().isEmpty() || edtGiaHangHoaDon.getText().toString().isEmpty() ||
                edtSoLuongHangHoaDon.getText().toString().isEmpty() ||edtNgayMuaHoaDon.getText().toString().isEmpty()){
            return -1;
        }else {
            return 0;
        }
    }

    public void xuLySuaHoaDon(View view) {
        Toast.makeText(this," đây aoid: " + listXuatKho.toString(),Toast.LENGTH_LONG).show();
    }

    public void checkEmpty(String data, EditText edt){
        if (data.isEmpty()) {
//            edt.setError(" Vui lòng nhập đủ thông tin ... ");
            return;
        }
    }


}