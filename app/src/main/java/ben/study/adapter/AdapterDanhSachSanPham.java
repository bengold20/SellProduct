package ben.study.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

import ben.study.codeduan1.R;
import ben.study.database.DatabaseDuAn1;
import ben.study.database.XuatKhoDAO;
import ben.study.model.KhoModel;

public class AdapterDanhSachSanPham extends BaseAdapter {
    private ArrayList<KhoModel> khoModels ;
    private Context context;
    public AdapterDanhSachSanPham(ArrayList<KhoModel> khoModels , Context context){
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
        view = LayoutInflater.from(context).inflate(R.layout.item_listview_danhsachxuatkho,viewGroup,false);
        TextView txtLvTenHangXK = view.findViewById(R.id.txtLvTenHangXK);
        TextView txtLvTenTheLoaiXK = view.findViewById(R.id.txtLvTenTheLoaiXK);
        TextView txtLvSoLuongXK = view.findViewById(R.id.txtLvSoLuongXK);
        TextView txtLvGiaXK =view.findViewById(R.id.txtLvGiaXK);
        txtLvTenHangXK.setText(khoModels.get(i).getTenHang());
        txtLvTenTheLoaiXK.setText(khoModels.get(i).getTheloaihang());
        txtLvSoLuongXK.setText(khoModels.get(i).getSoLuong());
//        txtLvGiaXK.setText((int) sanPhamModels.get(i).getGia());
        txtLvGiaXK.setText(String.valueOf(khoModels.get(i).getGia()));
        view.findViewById(R.id.imgXoaTheLoaiXK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Xóa Thể Loại Hàng");
                builder.setTitle("Bạn có chắc muốn xóa thể loại hàng này không , lưu ý khi xóa thể loại hàng này sẽ mất vĩnh viễn.!");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i1) {
                        DatabaseDuAn1 databaseDuAn1 = new DatabaseDuAn1(view.getContext());
                        XuatKhoDAO xuatKhoDAO = new XuatKhoDAO(databaseDuAn1);
                        String ma = khoModels.get(i).getMaHang();
                        boolean ketQua = xuatKhoDAO.xoahangtrongkhoxuat(ma);
                        if (ketQua) {
                            Toast.makeText(viewGroup.getContext(), "Xoa Thanh Cong!!!" ,
                                    Toast.LENGTH_SHORT).show();
                            khoModels.remove(i);
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
        return view;
    }
}
