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
import ben.study.database.TheLoaiDAO;
import ben.study.model.TheLoaiModel;

public class AdapterTheLoai extends BaseAdapter {
    private ArrayList<TheLoaiModel> theLoaiModels;
    private Context context;

    public  AdapterTheLoai( ArrayList<TheLoaiModel> theLoaiModels ,Context context){
        this.theLoaiModels = theLoaiModels;
        this.context = context;
    }


    @Override
    public int getCount() {
        return theLoaiModels.size();
    }

    @Override
    public Object getItem(int i) {
        return theLoaiModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_listview_theloai,viewGroup,false);
        ImageView imgTheLoai = view.findViewById(R.id.imgTheLoai);
//        ImageView imgXoaTheLoai = view.findViewById(R.id.imgXoaTheLoai);
        TextView txtListviewTenTheLoai = view.findViewById(R.id.txtListviewTenTheLoai);
        TextView txtListviewMaTheLoai = view.findViewById(R.id.txtListviewMaTheLoai);
        TextView txtListviewViTri = view.findViewById(R.id.txtListviewViTri);

        txtListviewTenTheLoai.setText(theLoaiModels.get(i).getTenTheLoai());
        txtListviewMaTheLoai.setText(theLoaiModels.get(i).getMaTheLoai());
        txtListviewViTri.setText(String.valueOf(theLoaiModels.get(i).getViTri()));
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
                        TheLoaiDAO theLoaiDAO = new TheLoaiDAO(databaseDuAn1);
                        String ma = theLoaiModels.get(i).getMaTheLoai();
                        boolean ketQua = theLoaiDAO.xoaTheLoai(ma);
                        if (ketQua) {
                            Toast.makeText(viewGroup.getContext(), "Xoa Thanh Cong!!!" ,
                                    Toast.LENGTH_SHORT).show();
                            theLoaiModels.remove(i);
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
