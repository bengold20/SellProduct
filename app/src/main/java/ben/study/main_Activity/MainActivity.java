package ben.study.main_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
    String struser = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvents();
    }

    private void addEvents() {
        if (checkremember() > 0){
            SharedPreferences sharedPreferences = getSharedPreferences("User.txt",MODE_PRIVATE);
            String user = sharedPreferences.getString("User","");
            edtUser.setText(user);
        }
    }

    private void addControl() {
    edtUser = findViewById(R.id.edtUser);
    edtPass = findViewById(R.id.edtPass);
    Chekbox = findViewById(R.id.Chekbox);
    btnLogin = findViewById(R.id.btnLogin);
    btnLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String user = edtUser.getText().toString();
            String pass =  edtPass.getText().toString();
            if (user.equals("admin") && pass.equals("admin")){
                Toast.makeText(MainActivity.this,"Đăng nhập hệ thống thành công: !" , Toast.LENGTH_LONG).show();
                rememberUser(user,Chekbox.isChecked());
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
            }else {
                Toast.makeText(MainActivity.this,"Đăng nhập hệ thống thất bại " , Toast.LENGTH_LONG).show();
            }

        }
    });
    }
    public  void  rememberUser (String user , boolean abc){
        SharedPreferences sharedPreferences = getSharedPreferences("User.txt",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (!abc){
            editor.clear();
        }else {
            editor.putString("User" , user);
            editor.putBoolean("Save" , abc);
        }
        editor.commit();
    }
    public int checkremember (){
        SharedPreferences sharedPreferences = getSharedPreferences("User.txt",MODE_PRIVATE);
        boolean chk = sharedPreferences.getBoolean("Save",false);
        if (chk){
            struser = sharedPreferences.getString("User","");
            return 1;
        }
        return -1 ;
    }
}