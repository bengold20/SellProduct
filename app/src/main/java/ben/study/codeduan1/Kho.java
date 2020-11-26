package ben.study.codeduan1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import ben.study.adapter.pageradapterkho;
import ben.study.danh_sach_san_pham.DanhSachSanPham;
import ben.study.danh_sach_san_pham.DanhSachSanPhamTrongKho;

public class Kho extends AppCompatActivity {
   ViewPager viewPager;
   Toolbar toolbarKho;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kho);
        viewPager = findViewById(R.id.viewpager);
        addtab(viewPager);
        ((TabLayout)findViewById(R.id.tablayout)).setupWithViewPager(viewPager);

        addControls();
        addEvents();
    }

    private void addEvents() {
        toolbarKho.setNavigationIcon(R.drawable.ic_back);

        toolbarKho.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Kho.this, Home.class);
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        toolbarKho = findViewById(R.id.toolbarKho);

        setSupportActionBar(toolbarKho);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    public void addtab(ViewPager viewPager){
        pageradapterkho pageradapterkho = new pageradapterkho(getSupportFragmentManager());
        pageradapterkho.add(new xuatkhoFragment(),"xuatkho");
        pageradapterkho.add(new nhapkhoFragment(),"nhapkho");
        viewPager.setAdapter(pageradapterkho);

    }
}