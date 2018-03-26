package d14cn2ptit.com.salemanagementsystem.home.book;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import d14cn2ptit.com.salemanagementsystem.R;

/**
 * Created by thuy on 26/03/2018.
 */

public class BookFragment extends Fragment{
    public static BookFragment newInstance(){
        return new BookFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_home, container, false);

        return view;
    }
}
