package ben.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import ben.study.codeduan1.Home;
import ben.study.codeduan1.R;
import ben.study.codeduan1.kho;

public class MainActivity extends AppCompatActivity {

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