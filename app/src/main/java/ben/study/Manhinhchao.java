package ben.study;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import ben.study.codeduan1.R;

public class Manhinhchao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_manhinhchao);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_manhinhchao);
        //chuyển màn
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new
                        Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        }, 2000);
    }
}