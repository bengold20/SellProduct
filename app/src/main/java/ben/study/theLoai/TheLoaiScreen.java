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

        setSupportActionBar(toolbar_theLoai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_theloai,menu);
        return true;
    }

    public void themHoaDon(Menu item){
        Intent intent = new Intent(TheLoaiScreen.this,ThemSua_TheLoai.class);
        startActivity(intent);
    }
}


