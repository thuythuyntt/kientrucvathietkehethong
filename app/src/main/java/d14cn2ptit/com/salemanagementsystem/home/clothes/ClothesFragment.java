package d14cn2ptit.com.salemanagementsystem.home.clothes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import d14cn2ptit.com.salemanagementsystem.R;

/**
 * Created by thuy on 18/03/2018.
 */

public class ClothesFragment extends Fragment {
    public static ClothesFragment newInstance(){
        return new ClothesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clothes, container, false);
        return view;
    }
}
