package ben.study.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import ben.study.codeduan1.nhapkhoFragment;
import ben.study.codeduan1.xuatkhoFragment;

public class pageradapterkho extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> titlefm = new ArrayList<>();



    public pageradapterkho(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titlefm.get(position);
    }
    public void add(Fragment frm ,String t){
        fragmentList.add(frm);
        titlefm.add(t);
    }
}
