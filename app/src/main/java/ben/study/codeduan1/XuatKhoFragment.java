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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ben.study.adapter.AdapterDanhSachSanPhamTrongKho;
import ben.study.danh_sach_san_pham.DanhSachSanPham;
import ben.study.database.DatabaseDuAn1;
import ben.study.database.NhapKhoDAO;
import ben.study.database.TheLoaiDAO;
import ben.study.database.XuatKhoDAO;
import ben.study.model.KhoModel;
import ben.study.model.TheLoaiModel;


public class XuatKhoFragment extends Fragment{
    private  Button btnNgayXuat,btnXuatKho,btnHuy;
    private ImageView imgkho;
    private EditText edtMaHangXuat,edtTenHangXuat,edtSoLuongXuat,edtNgayXuat,edtTheLoaiXuatKho;
    private Spinner spTheLoaiHangXuat;
    List<TheLoaiModel> listTheLoaiXuat = new ArrayList<>();
    DatabaseDuAn1 databaseDuAn1;
    KhoModel khoModel;
    XuatKhoDAO xuatKhoDAO;
    TheLoaiDAO theLoaiDAO;
    String theLoaiHangXuat;

//    List<KhoModel> soLuongXuatRa ;

    //tìm kiếm dữ liệu trong kho
    Button btnFindDSNhapKho;
    EditText edtFinDSNhapKho;
    ListView lvFindDSNhapKho;
    NhapKhoDAO nhapKhoDAO;
    List<KhoModel> listNhapKho;
    AdapterDanhSachSanPhamTrongKho adapterNhapKho;

    public XuatKhoFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        databaseDuAn1 = new DatabaseDuAn1(getActivity());
        nhapKhoDAO = new NhapKhoDAO(databaseDuAn1);
        xuatKhoDAO = new XuatKhoDAO(databaseDuAn1);
        theLoaiDAO = new TheLoaiDAO(databaseDuAn1);

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_xuatkho, container, false);
        btnNgayXuat = view.findViewById(R.id.btnngayxuat);
        btnXuatKho = view.findViewById(R.id.btnxuatkho);
        btnHuy =view.findViewById(R.id.btnHuy);
        btnFindDSNhapKho = view.findViewById(R.id.btnFindDSNhapKho);
        imgkho = view.findViewById(R.id.imgkho);
        edtMaHangXuat = view.findViewById(R.id.edtMaHangXuat);
        edtTenHangXuat= view.findViewById(R.id.edtTenHangXuat);
        edtSoLuongXuat = view.findViewById(R.id.edtSoLuongXuat);
        edtNgayXuat = view.findViewById(R.id.edtngayxuat);
        edtFinDSNhapKho = view.findViewById(R.id.edtFinDSNhapKho);
        edtTheLoaiXuatKho = view.findViewById(R.id.edtTheLoaiXuatKho);

        //spinner
//        spTheLoaiHangXuat = view.findViewById(R.id.spTheLoaiHangXuat);
//        listTheLoaiXuat = theLoaiDAO.getAllTheLoai();
//        ArrayAdapter<TheLoaiModel> adapterTheLoaiXuat = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,listTheLoaiXuat);
//        spTheLoaiHangXuat.setAdapter(adapterTheLoaiXuat);
//        adapterTheLoaiXuat.notifyDataSetChanged();

        //LISTVIEW nhập kho
        lvFindDSNhapKho = view.findViewById(R.id.lvFindDSNhapKho);
        listNhapKho = nhapKhoDAO.getallHangKhoNhap();
        adapterNhapKho = new AdapterDanhSachSanPhamTrongKho(listNhapKho,getActivity());
        lvFindDSNhapKho.setAdapter(adapterNhapKho);
        adapterNhapKho.notifyDataSetChanged();
        //chọn sản phẩm và đẩy dữ liệu vào form
        lvFindDSNhapKho.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });







//        //click
//        spTheLoaiHangXuat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                theLoaiHangXuat = listTheLoaiXuat.get(spTheLoaiHangXuat.getSelectedItemPosition()).getMaTheLoai();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });


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



        btnXuatKho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String maHangXuat = edtMaHangXuat.getText().toString();
                String tenHangXuat = edtTenHangXuat.getText().toString();
                int soLuongXuat = Integer.parseInt(edtSoLuongXuat.getText().toString());
                String ngayXuat = edtNgayXuat.getText().toString();

                KhoModel khoXuat = new KhoModel();

                khoXuat.setMaHang(maHangXuat);
                khoXuat.setTheloaihang(theLoaiHangXuat);
                khoXuat.setTenHang(tenHangXuat);
                khoXuat.setSoLuong(soLuongXuat);
                khoXuat.setNgayNhap(ngayXuat);
                
                boolean result = xuatKhoDAO.themhangxuat(khoXuat);

                if(result){
                    Toast.makeText(getActivity(),"xuất kho thành công",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getActivity(),"xuất kho không thành công",Toast.LENGTH_LONG).show();
                }


            }
        });

        btnFindDSNhapKho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timKiemHangTrongKho();
            }
        });

        return view;


    }


    public void timKiemHangTrongKho(){
        String maHangNhapKho = edtFinDSNhapKho.getText().toString().trim();
        if(maHangNhapKho.isEmpty()){
            edtFinDSNhapKho.setError("NHẬP DỮ LIỆU TRƯỚC");
            return;
        }

        nhapKhoDAO = new NhapKhoDAO(databaseDuAn1);
        List<KhoModel> listHangTrongKho = nhapKhoDAO.FindHangKhoNhap(maHangNhapKho);

        if(listHangTrongKho.size() > 0){
            edtFinDSNhapKho.setError("KHÔNG TÌM THẤY DỮ LIỆU NÀO");
            adapterNhapKho = new AdapterDanhSachSanPhamTrongKho(listHangTrongKho,getActivity());
            lvFindDSNhapKho.setAdapter(adapterNhapKho);
            adapterNhapKho.notifyDataSetChanged();
        }

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