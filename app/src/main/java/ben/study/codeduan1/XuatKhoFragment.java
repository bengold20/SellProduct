package ben.study.codeduan1;

import android.app.DatePickerDialog;
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
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

import ben.study.danh_sach_san_pham.DanhSachSanPham;
import ben.study.model.KhoModel;


public class XuatKhoFragment extends Fragment{
    private  Button btnNgayXuat,btnXuatKho,btnHuy;
    private ImageView imgkho;
    private EditText edtMaHangXuat,edtTenHangXuat,edtSoLuongXuat,edtNgayXuat;
    private Spinner spTheLoaiHangXuat;



    public XuatKhoFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_xuatkho, container, false);
        btnNgayXuat = view.findViewById(R.id.btnngayxuat);
        btnXuatKho = view.findViewById(R.id.btnxuatkho);
        btnHuy =view.findViewById(R.id.btnHuy);
        imgkho = view.findViewById(R.id.imgkho);
        edtMaHangXuat = view.findViewById(R.id.edtMaHangXuat);
        edtTenHangXuat= view.findViewById(R.id.edtTenHangXuat);
        edtSoLuongXuat = view.findViewById(R.id.edtSoLuongXuat);
        edtNgayXuat = view.findViewById(R.id.edtngayxuat);
        spTheLoaiHangXuat = view.findViewById(R.id.spTheLoaiHangXuat);
        btnNgayXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar ngayxuat = Calendar.getInstance();
                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String date =i2 + "/" + (i1 +1) + "/" +i ;
                        edtNgayXuat.setText(date);
                    }
                },ngayxuat.get(ngayxuat.YEAR),ngayxuat.get(ngayxuat.MONTH),ngayxuat.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
        xulylaydulieu();
        return view;

    }

    private void xulylaydulieu() {
        KhoModel kho = new KhoModel();
        String mahang = edtMaHangXuat.getText().toString();
        String tenhang = edtTenHangXuat.getText().toString();
//        int soluong = Integer.parseInt(edtsoluong.getText().toString());

//        String theloaihang = sptheloaihang.getSelectedItem().toString();

        kho.setMaHang(mahang);
        kho.setTenHang(tenhang);
//        kho.setSoLuong(soluong);
//        kho.setTheloaihang(theloaihang);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.item_xuatkho,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_danhSachHangXuatKho:
                Intent intent = new Intent(getActivity(), DanhSachSanPham.class);
                startActivity(intent);
                break;
            case R.id.item_trangChuXuatKho:
                Intent intent1 = new Intent(getActivity(), Home.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}