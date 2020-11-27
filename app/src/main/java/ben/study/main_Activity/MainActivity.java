package ben.study.main_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

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


    }

    public void kho(View view) {
        Intent intent = new Intent(MainActivity.this, Home.class);
        startActivity(intent);
    }
}