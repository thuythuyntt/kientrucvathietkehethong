package d14cn2ptit.com.salemanagementsystem.home.electronics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import d14cn2ptit.com.salemanagementsystem.R;
import d14cn2ptit.com.salemanagementsystem.home.book.BookFragment;

/**
 * Created by thuy on 26/03/2018.
 */

public class ElectronicsFragment extends Fragment{
    public static ElectronicsFragment newInstance(){
        return new ElectronicsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_electronics_home, container, false);

        return view;
    }
}
