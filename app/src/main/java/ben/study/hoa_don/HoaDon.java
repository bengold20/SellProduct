package ben.study.hoa_don;

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
import ben.study.theLoai.TheLoaiScreen;
import ben.study.theLoai.ThemSua_TheLoai;

public class HoaDon extends AppCompatActivity {
    Toolbar toolbarHoaDon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);

        addControls();
        addEvents();
    }

    private void addEvents() {
        setSupportActionBar(toolbarHoaDon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbarHoaDon.setNavigationIcon(R.drawable.ic_back);

        toolbarHoaDon.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(HoaDon.this, Home.class);
                startActivity(intent2);
            }
        });

    }

    private void addControls() {
        toolbarHoaDon = findViewById(R.id.toolbarHoaDon);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_hoadon,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_search_hoadon:
                Toast.makeText(this,"tìm kiếm đi",Toast.LENGTH_LONG).show();
                break;
            case R.id.item_ThemHoaDon:
                Intent intent = new Intent(HoaDon.this, Them_Sua_HoaDon.class);
                startActivity(intent);
                break;
            case R.id.item_SuaHoaDon:
                Intent intent1 = new Intent(HoaDon.this,Them_Sua_HoaDon.class);
                startActivity(intent1);
                break;
            case R.id.item_TrangChuHoaDon:
                Intent intent2 = new Intent(HoaDon.this, Home.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}