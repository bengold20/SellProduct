package ben.study.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

import ben.study.codeduan1.R;
import ben.study.database.DatabaseDuAn1;
import ben.study.database.HoaDonDAO;
import ben.study.model.HoaDon;

public class adapterhoadon extends BaseAdapter {
    private ArrayList<HoaDon> hoadons;
    private Context context;
    public adapterhoadon(ArrayList<HoaDon> hoadons,Context context){
        this.hoadons = hoadons;
        this.context = context;
    }
    @Override
    public int getCount() {
        return hoadons.size();
    }

    @Override
    public Object getItem(int i) {
        return hoadons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.itemhoadon,viewGroup,false);

        ImageView imgHoaDon = view.findViewById(R.id.imgHoaDon);
        ImageView imgXoa = view.findViewById(R.id.imgXoa);
        TextView txtTenHang = view.findViewById(R.id.txtTenHang);
        TextView txtTheLoai = view.findViewById(R.id.txtTheLoaiHang);
        TextView txtTongThanhToan = view.findViewById(R.id.txtTongThanhToan);

        txtTenHang.setText(hoadons.get(i).getTenMatHang());
        txtTheLoai.setText(hoadons.get(i).getTheLoaiMatHang());
        txtTongThanhToan.setText((int) hoadons.get(i).getTongThanhToan());
        imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Xóa Hóa Đơn");
                builder.setTitle("Bạn có chắc muốn xóa hóa đơn này không , lưu ý khi xóa hóa đơn sẽ mất vĩnh viễn.!");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DatabaseDuAn1 databaseDuAn1 = new DatabaseDuAn1(view.getContext());
                        HoaDonDAO hoadonDAO = new HoaDonDAO(databaseDuAn1);
                        String mahoadon = hoadons.get(i).getMaHoaDon();
                        boolean ketQua = hoadonDAO.xoahoadon(mahoadon);
                        if (ketQua) {
                            Toast.makeText(viewGroup.getContext(), "Xoa Thanh Cong!!!",
                                    Toast.LENGTH_SHORT).show();
                            hoadons.remove(i);
                            notifyDataSetChanged();
                        } else {
                            Toast.makeText(viewGroup.getContext(), "Xoa KHONG Thanh Cong!!!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(view.getContext(),"",Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });


        return null;
    }
}
