package ben.study.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ben.study.codeduan1.R;
import ben.study.model.HoaDonModel;

public class AdapterDSTop10 extends BaseAdapter {

    private List<HoaDonModel> listTop10;
    private Context context;

    public AdapterDSTop10(List<HoaDonModel> listTop10,Context context)
    {
        this.listTop10 = listTop10;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listTop10.size();
    }

    @Override
    public Object getItem(int i) {
        return listTop10.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_listview_top10,viewGroup,false);
        TextView txtTenHangTop10 = view.findViewById(R.id.txtTenHangTop10);
        TextView txtTheLoaiTop10 = view.findViewById(R.id.txtTheLoaiTop10);
        TextView txtSoLuongTop10 = view.findViewById(R.id.txtSoLuongTop10);

        txtTenHangTop10.setText(listTop10.get(i).getTenMatHang());
        txtTheLoaiTop10.setText(listTop10.get(i).getTheLoaiMatHang());
        txtSoLuongTop10.setText(String.valueOf(listTop10.get(i).getSoLuongMatHang()));

        return view;
    }
}
