package ben.study.codeduan1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import ben.study.adapter.pageradapterkho;

public class kho extends AppCompatActivity {
   ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kho);
        viewPager = findViewById(R.id.viewpager);
        addtab(viewPager);
        ((TabLayout)findViewById(R.id.tablayout)).setupWithViewPager(viewPager);


    }
    public void addtab(ViewPager viewPager){
        pageradapterkho pageradapterkho = new pageradapterkho(getSupportFragmentManager());
        pageradapterkho.add(new xuatkhoFragment(),"xuatkho");
        pageradapterkho.add(new nhapkhoFragment(),"nhapkho");
        viewPager.setAdapter(pageradapterkho);

    }
}