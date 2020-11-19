package ben.study.codeduan1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import ben.study.model.KhoModel;


public class nhapkhoFragment extends Fragment {
    private Button btnngaynhap,btnnhapkho,btnhuy;
    private ImageView imgkho;
    private EditText edtmahang,edttheloaihang,edttenhang,edtsoluong,edtngaynhap;

    public nhapkhoFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_nhapkho, container, false);
        btnngaynhap = view.findViewById(R.id.btnngaynhap);
        btnnhapkho = view.findViewById(R.id.btnnhapkho);
        btnhuy = view.findViewById(R.id.btnhuy);
        imgkho = view.findViewById(R.id.imgkho);
        edtmahang = view.findViewById(R.id.edtmahang);
        edttheloaihang = view.findViewById(R.id.edttheloaihang);
        edttenhang = view.findViewById(R.id.edttenhang);
        edtsoluong = view.findViewById(R.id.edtsoluong);
        edtngaynhap = view.findViewById(R.id.edtngaynhap);
        xulylaydulieu();
        return view;
    }

    private void xulylaydulieu() {
        KhoModel kho = new KhoModel();
        String mahang = edtmahang.getText().toString();
        String theloaihang = edttheloaihang.getText().toString();
        String tenhang = edttenhang.getText().toString();
//        int soluong = Integer.parseInt(edtsoluong.getText().toString());

        kho.setMaHang(mahang);
        kho.setTheloaihang(theloaihang);
        kho.setTenHang(tenhang);
//        kho.setSoLuong(soluong);

    }
}