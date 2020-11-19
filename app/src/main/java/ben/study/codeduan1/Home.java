package ben.study.codeduan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ben.study.theLoai.TheLoaiScreen;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void kho(View view) {
        Intent intent = new Intent(Home.this,kho.class);
        startActivity(intent);
    }

    public void the_loai(View view) {
        Intent intent = new Intent(Home.this, TheLoaiScreen.class);
        startActivity(intent);
    }
}