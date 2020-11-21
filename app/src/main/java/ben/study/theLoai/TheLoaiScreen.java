package ben.study.theLoai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import ben.study.codeduan1.R;

public class TheLoaiScreen extends AppCompatActivity {
    Toolbar toolbar_theLoai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai_screen);



        addControls();
        addEvents();
    }

    private void addEvents() {
        setSupportActionBar(toolbar_theLoai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar_theLoai.setNavigationIcon(R.drawable.ic_back);

    }

    private void addControls() {
        toolbar_theLoai = findViewById(R.id.toolbarTheLoai);

    }


    public void themHoaDon(Menu item){
        Intent intent = new Intent(TheLoaiScreen.this,ThemSua_TheLoai.class);
        startActivity(intent);
    }
}


