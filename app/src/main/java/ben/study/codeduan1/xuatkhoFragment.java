package ben.study.codeduan1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import ben.study.model.KhoModel;


public class xuatkhoFragment extends Fragment {
    private  Button btnngayxuat,btnxuatkho,btnhuy;
    private ImageView imgkho;
    private EditText edtmahang,edttenhang,edtsoluong,edtngayxuat;
    private Spinner sptheloaihang;


    public xuatkhoFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_xuatkho, container, false);
        btnngayxuat = view.findViewById(R.id.btnngayxuat);
        btnxuatkho = view.findViewById(R.id.btnxuatkho);
        btnhuy =view.findViewById(R.id.btnHuy);
        imgkho = view.findViewById(R.id.imgkho);
        edtmahang = view.findViewById(R.id.edtMahang);
        edttenhang= view.findViewById(R.id.edtTenHang);
        edtsoluong = view.findViewById(R.id.edtSoLuong);
        edtngayxuat = view.findViewById(R.id.edtngayxuat);
        sptheloaihang = view.findViewById(R.id.sptheloaihang);
        xulylaydulieu();
        return view;

    }

    private void xulylaydulieu() {
        KhoModel kho = new KhoModel();
        String mahang = edtmahang.getText().toString();
        String tenhang = edttenhang.getText().toString();
//        int soluong = Integer.parseInt(edtsoluong.getText().toString());

//        String theloaihang = sptheloaihang.getSelectedItem().toString();

        kho.setMaHang(mahang);
        kho.setTenHang(tenhang);
//        kho.setSoLuong(soluong);
//        kho.setTheloaihang(theloaihang);

    }
}