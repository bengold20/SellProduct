package ben.study.main_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import ben.study.codeduan1.Home;
import ben.study.codeduan1.R;

public class MainActivity extends AppCompatActivity {
    EditText edtUser ,edtPass;
    CheckBox Chekbox;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvents();
    }

    private void addEvents() {
    }

    private void addControl() {
//    edtUser = findViewById(R.id.edtUser);
//    edtPass = findViewById(R.id.edtPass);
//    Chekbox = findViewById(R.id.Chekbox);
//    btnLogin = findViewById(R.id.btnLogin);
//    btnLogin.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            String user = edtUser.getText().toString();
//            String pass =  edtPass.getText().toString();
//            if (user.equals("admin") && pass.equals("admin")){
//                Toast.makeText(MainActivity.this,"Đăng nhập hệ thống thành công: !" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
//            }else {
//                Toast.makeText(MainActivity.this,"Đăng nhập hệ thống thất bại vui lòng xem lại đi bạn eei:1" , Toast.LENGTH_LONG).show();
//            }
//
//        }
//    });
    }
}