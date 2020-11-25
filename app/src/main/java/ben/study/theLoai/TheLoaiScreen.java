package ben.study.theLoai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import ben.study.codeduan1.Home;
import ben.study.codeduan1.R;
import ben.study.hoa_don.HoaDon;

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

        toolbar_theLoai.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(TheLoaiScreen.this, Home.class);
                startActivity(intent2);
            }
        });

    }

    private void addControls() {
        toolbar_theLoai = findViewById(R.id.toolbarTheLoai);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_theloai,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_search_theloai:
                Toast.makeText(this,"tìm kiếm đi",Toast.LENGTH_LONG).show();
            break;
            case R.id.item_ThemTheLoai:
                Intent intent = new Intent(TheLoaiScreen.this,ThemSua_TheLoai.class);
                startActivity(intent);
                break;
            case R.id.item_SuaTheLoai:
                Intent intent1 = new Intent(TheLoaiScreen.this,ThemSua_TheLoai.class);
                startActivity(intent1);
                break;
            case R.id.item_TrangChuTheLoai:
                Intent intent2 = new Intent(TheLoaiScreen.this, Home.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


