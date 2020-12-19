package ben.study.codeduan1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import ben.study.adapter.AdapterDanhSachSanPhamTrongKho;
import ben.study.danh_sach_san_pham.DanhSachSanPhamTrongKho;
import ben.study.database.DatabaseDuAn1;
import ben.study.database.NhapKhoDAO;
import ben.study.database.TheLoaiDAO;
import ben.study.model.KhoModel;
import ben.study.model.TheLoaiModel;


public class NhapKhoFragment extends Fragment {
    private Button btnngaynhap,btnnhapkho,btnhuy,btnSuaKhoNhap;
    private EditText edtMaHangNhap,edtTenHangNhap,edtSoLuongNhap,edtNgayNhap,edtGiaHangNhap;
    DatabaseDuAn1 databaseDuAn1;
    NhapKhoDAO nhapKhoDAO;
    TheLoaiDAO theLoaiDAO;
    //spinner
    Spinner spnTheLoaiNhapKho;
    List<TheLoaiModel> listTheLoaiNhapKho;
    String theloai;

    public NhapKhoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_nhapkho, container, false);

        databaseDuAn1 = new DatabaseDuAn1(getActivity());
        nhapKhoDAO = new NhapKhoDAO(databaseDuAn1);
        theLoaiDAO = new TheLoaiDAO(databaseDuAn1);

        btnngaynhap = view.findViewById(R.id.btnNgayNhap);
        btnnhapkho = view.findViewById(R.id.btnNhapKho);
        btnhuy = view.findViewById(R.id.btnHuy);
        btnSuaKhoNhap = view.findViewById(R.id.btnSuaHangNhapKho);

        //Edit Text
        edtMaHangNhap = view.findViewById(R.id.edtMaHangNhap);
        edtTenHangNhap = view.findViewById(R.id.edtTenHangNhap);
        edtSoLuongNhap = view.findViewById(R.id.edtSoLuongNhap);
        edtGiaHangNhap = view.findViewById(R.id.edtGiaHangNhap);
        edtNgayNhap = view.findViewById(R.id.edtNgayNhap);

        //spinner
        spnTheLoaiNhapKho = view.findViewById(R.id.spnTheLoaiNhapKho);
        listTheLoaiNhapKho = theLoaiDAO.getAllTheLoai();
        ArrayAdapter<TheLoaiModel> adapterTheLoaiTrongKho = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,listTheLoaiNhapKho);
        spnTheLoaiNhapKho.setAdapter(adapterTheLoaiTrongKho);
        adapterTheLoaiTrongKho.notifyDataSetChanged();
        //click spinner
        spnTheLoaiNhapKho.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                theloai = listTheLoaiNhapKho.get(spnTheLoaiNhapKho.getSelectedItemPosition()).getTenTheLoai();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnngaynhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar ngaynhap = Calendar.getInstance();
                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String date =i2 + "/" + (i1 +1) + "/" +i ;
                        edtNgayNhap.setText(date);
                    }
                },ngaynhap.get(ngaynhap.YEAR),ngaynhap.get(ngaynhap.MONTH),ngaynhap.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        btnnhapkho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyThemHang();
            }
        });

        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtMaHangNhap.setText("");
                edtTenHangNhap.setText("");
                edtSoLuongNhap.setText("");
                edtGiaHangNhap.setText("");
                edtNgayNhap.setText("");
            }
        });
        btnSuaKhoNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLySuaNhapKho();
            }
        });

        return view;



    }

    private void xuLySuaNhapKho() {

        String maHang = edtMaHangNhap.getText().toString();
        String tenHang = edtTenHangNhap.getText().toString();
        Integer soLuong = Integer.parseInt(edtSoLuongNhap.getText().toString());
        Double giaNhap = Double.valueOf(edtGiaHangNhap.getText().toString());
        String ngayNhap = edtNgayNhap.getText().toString();

        KhoModel khoNhap = new KhoModel();

        khoNhap.setMaHang(maHang);
        khoNhap.setTheloaihang(theloai);
        khoNhap.setTenHang(tenHang);
        khoNhap.setSoLuong(soLuong);
        khoNhap.setGia(giaNhap);
        khoNhap.setNgayNhap(ngayNhap);

        int result = nhapKhoDAO.suaHangNhap(khoNhap);



        if(result > 0 ){
            Toast.makeText(getActivity(),"sửa hàng thành công" ,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getActivity(),DanhSachSanPhamTrongKho.class);
            startActivity(intent);
        }else {
            Toast.makeText(getActivity(),"sửa hàng không thành công",Toast.LENGTH_LONG).show();
        }
    }


    private void xuLyThemHang() {
            String maHang = edtMaHangNhap.getText().toString();
            String tenHang = edtTenHangNhap.getText().toString();
            Integer soLuong = Integer.parseInt(edtSoLuongNhap.getText().toString());
            Double giaNhap = Double.valueOf(edtGiaHangNhap.getText().toString());
            String ngayNhap = edtNgayNhap.getText().toString();

            KhoModel khoNhap = new KhoModel();

            khoNhap.setMaHang(maHang);
            khoNhap.setTheloaihang(theloai);
            khoNhap.setTenHang(tenHang);
            khoNhap.setSoLuong(soLuong);
            khoNhap.setGia(giaNhap);
            khoNhap.setNgayNhap(ngayNhap);

            Boolean result = nhapKhoDAO.themhangnhap(khoNhap);


            if(result ){
                Toast.makeText(getActivity(),"nhập hàng thành công" + theloai + maHang,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(),DanhSachSanPhamTrongKho.class);
                startActivity(intent);
            }else {
                Toast.makeText(getActivity(),"nhập hàng không thành công"+ theloai + maHang,Toast.LENGTH_LONG).show();
            }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.item_nhapkho,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_danhSachHangNhapKho:
                Intent intent = new Intent(getActivity(), DanhSachSanPhamTrongKho.class);
                startActivity(intent);
                break;
            case R.id.item_trangChuNhapKho:
                Intent intent1 = new Intent(getActivity(), Home.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}