package ben.study.thong_ke;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ben.study.codeduan1.Home;
import ben.study.codeduan1.R;
import ben.study.theLoai.TheLoaiScreen;

public class ThongKe extends AppCompatActivity {
    Toolbar toolbarThongKe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);

        addControls();
        addEvents();
    }



    private void addEvents() {
        setSupportActionBar(toolbarThongKe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbarThongKe.setNavigationIcon(R.drawable.ic_back);

        toolbarThongKe.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ThongKe.this, Home.class);
                startActivity(intent2);
            }
        });

    }

    private void addControls() {
        toolbarThongKe = findViewById(R.id.toolbarThongKe);
    }
}