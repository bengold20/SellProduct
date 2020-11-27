package ben.study.theLoai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ben.study.codeduan1.R;
import ben.study.database.DatabaseDuAn1;
import ben.study.database.TheLoaiDAO;
import ben.study.model.TheLoaiModel;

public class ThemSua_TheLoai extends AppCompatActivity {
    EditText edtMaTheLoai ,edtTenTheLoai,edtViTri;
    Button btnThemTheLoai,btnSuaTheLoai;
//    private DatabaseDuAn1 databaseDuAn1 = new DatabaseDuAn1(this);
//    private TheLoaiDAO theLoaiDAO = new TheLoaiDAO(databaseDuAn1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sua__the_loai);
        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {
        edtMaTheLoai = findViewById(R.id.edtMaTheLoai);
        edtTenTheLoai = findViewById(R.id.edtTenTheLoai);
        edtViTri = findViewById(R.id.edtViTri);
        btnThemTheLoai = findViewById(R.id.btnThemTheLoai);
        btnSuaTheLoai =findViewById(R.id.btnSuaTheLoai);
       btnThemTheLoai.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               xulythemtheloai();
           }
       });
       btnSuaTheLoai.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               xulysuatheloai();
           }
       });

    }

    private void xulysuatheloai() {
        DatabaseDuAn1 databaseDuAn1 = new DatabaseDuAn1(this);
        TheLoaiDAO theLoaiDAO = new TheLoaiDAO(databaseDuAn1);
        TheLoaiModel theLoaiModel = new TheLoaiModel();
        String tenTheLoai =edtTenTheLoai.getText().toString();
        int viTri = Integer.parseInt(edtViTri.getText().toString());
        theLoaiModel.setTenTheLoai(tenTheLoai);
        theLoaiModel.setViTri(viTri);

//        checkEmpty(theLoaiModel.getMaTheLoai(),edtMaTheLoai);
//        checkEmpty(theLoaiModel.getTenTheLoai(),edtTenTheLoai);
//        checkEmpty(String.valueOf(theLoaiModel.getViTri()),edtViTri);

        long kq = theLoaiDAO.suaTheloai(theLoaiModel);
        if (kq == 1 ){
            Toast.makeText(this,"Sửa thể loại thành công hi hi " ,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,TheLoaiScreen.class);
            startActivity(intent);
        }else {
            Toast.makeText(this,"Sửa thể loại thất bại rồi xem lại đi bạn ơi " ,Toast.LENGTH_LONG).show();
        }


    }

    private void xulythemtheloai() {
        TheLoaiModel theLoaiModel = new TheLoaiModel();
        String maTheLoai =  edtMaTheLoai.getText().toString();
        String tenTheLoai =edtTenTheLoai.getText().toString();
        int viTri = Integer.parseInt(edtViTri.getText().toString());
        theLoaiModel.setMaTheLoai(maTheLoai);
        theLoaiModel.setTenTheLoai(tenTheLoai);
        theLoaiModel.setViTri(viTri);
        DatabaseDuAn1 databaseDuAn1 = new DatabaseDuAn1(this);
        TheLoaiDAO theLoaiDAO = new TheLoaiDAO(databaseDuAn1);

//        checkEmpty(theLoaiModel.getMaTheLoai(),edtMaTheLoai);
//        checkEmpty(theLoaiModel.getTenTheLoai(),edtTenTheLoai);
//        checkEmpty(String.valueOf(theLoaiModel.getViTri()),edtViTri);

        boolean kq = theLoaiDAO.themTheloai(theLoaiModel);
        if (kq ){
            Toast.makeText(this,"thêm thể loại thành công hi hi " ,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,TheLoaiScreen.class);
            startActivity(intent);
        }else {
            Toast.makeText(this,"thêm thể loại thất bại rồi xem lại đi bạn ơi " ,Toast.LENGTH_LONG).show();
        }

    }


    public void checkEmpty(String data , EditText edt) {
        if (data.isEmpty()) {
            edt.setError(" Vui lòng nhập đủ thông tin ... ");
            return;
        }
    }

}