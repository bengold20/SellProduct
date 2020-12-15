package ben.study.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ben.study.codeduan1.R;
import ben.study.model.KhoModel;

public class AdapterThemSuaHoaDon extends BaseAdapter {
    private ArrayList<KhoModel> khoModels ;
    private Context context;

    public AdapterThemSuaHoaDon (ArrayList<KhoModel> khoModels , Context context){
        this.khoModels = khoModels;
        this.context = context;
    }

    @Override
    public int getCount() {
        return khoModels.size();
    }

    @Override
    public Object getItem(int i) {
        return khoModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_them_sua_hoadon,viewGroup,false);

        TextView txtLvMaHangXK_hoaDon = view.findViewById(R.id.txtLvMaHangXK_hoaDon);
        TextView txtLvTenHangXK_hoaDon = view.findViewById(R.id.txtLvTenHangXK_hoaDon);
        TextView txtLvTenTheLoaiXK_hoaDon = view.findViewById(R.id.txtLvTenTheLoaiXK_hoaDon);
        TextView txtLvSoLuongXK_hoaDon = view.findViewById(R.id.txtLvSoLuongXK_hoaDon);
        TextView txtLvGiaXK_hoaDon =view.findViewById(R.id.txtLvGiaXK_hoaDon);

        txtLvMaHangXK_hoaDon.setText("mã hàng:"+khoModels.get(i).getMaHang());
        txtLvTenHangXK_hoaDon.setText("tên hàng:"+khoModels.get(i).getTenHang());
        txtLvTenTheLoaiXK_hoaDon.setText("thể loại:"+khoModels.get(i).getTheloaihang());
        txtLvSoLuongXK_hoaDon.setText(String.valueOf("số lượng:"+khoModels.get(i).getSoLuong()));
        txtLvGiaXK_hoaDon.setText(String.valueOf("giá:"+khoModels.get(i).getGia()));

        return view;
    }
}
