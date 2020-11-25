package ben.study.hoa_don;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import ben.study.codeduan1.R;

public class Them_Sua_HoaDon extends AppCompatActivity {
    EditText edtNgayMua ;
    Button btnNgayMua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them__sua__hoa_don);
    edtNgayMua = findViewById(R.id.edtNgayMua);
    btnNgayMua = findViewById(R.id.btnNgayMua);

    }

    public void NgayMua(View view) {
        Calendar ngayMua = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String date =i2 + "/" + (i1 +1) + "/" +i ;
                edtNgayMua.setText(date);
            }
        },ngayMua.get(ngayMua.YEAR),ngayMua.get(ngayMua.MONTH),ngayMua.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
}