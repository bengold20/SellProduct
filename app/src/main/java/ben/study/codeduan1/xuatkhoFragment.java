package ben.study.codeduan1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class xuatkhoFragment extends Fragment {
    Button button1;


    public xuatkhoFragment() {

    }

    public static xuatkhoFragment newInstance() {
        xuatkhoFragment fragment = new xuatkhoFragment();
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_xuatkho, container, false);


    }
}