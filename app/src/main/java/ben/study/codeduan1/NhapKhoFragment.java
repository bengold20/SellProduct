package ben.study.codeduan1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;

import java.util.Calendar;

import ben.study.danh_sach_san_pham.DanhSachSanPham;
import ben.study.danh_sach_san_pham.DanhSachSanPhamTrongKho;
import ben.study.model.KhoModel;


public class NhapKhoFragment extends Fragment {
    private Button btnngaynhap,btnnhapkho,btnhuy;
    private ImageView imgkho;
    private EditText edtMaHangNhap,edtTheloaihangNhap,edtTenHangNhap,edtSoLuongNhap,edtNgayNhap;
    public NhapKhoFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_nhapkho, container, false);
        btnngaynhap = view.findViewById(R.id.btnNgayNhap);
        btnnhapkho = view.findViewById(R.id.btnNhapKho);
        btnhuy = view.findViewById(R.id.btnHuy);
        imgkho = view.findViewById(R.id.imgkho);
        edtMaHangNhap = view.findViewById(R.id.edtMaHangNhap);
        edtTheloaihangNhap = view.findViewById(R.id.edtTheLoaiHangNhap);
        edtTenHangNhap = view.findViewById(R.id.edtTenHangNhap);
        edtSoLuongNhap = view.findViewById(R.id.edtSoLuongNhap);
        edtNgayNhap = view.findViewById(R.id.edtNgayNhap);
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
        xulylaydulieu();
        return view;


    }

    private void xulylaydulieu() {
        KhoModel kho = new KhoModel();
        String maHang = edtMaHangNhap.getText().toString();
        String theLoaiHang = edtTheloaihangNhap.getText().toString();
        String tenHang = edtTenHangNhap.getText().toString();
//        int soLuong = Integer.parseInt(edtSoLuongNhap.getText().toString());

        kho.setMaHang(maHang);
        kho.setTheloaihang(theLoaiHang);
        kho.setTenHang(tenHang);
//        kho.setSoLuong(soLuong);

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