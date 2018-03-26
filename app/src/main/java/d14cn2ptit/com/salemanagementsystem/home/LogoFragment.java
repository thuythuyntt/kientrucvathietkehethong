package d14cn2ptit.com.salemanagementsystem.home;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import d14cn2ptit.com.salemanagementsystem.R;
import d14cn2ptit.com.salemanagementsystem.activity.MainActivity;
import d14cn2ptit.com.salemanagementsystem.utils.FragmentUtils;
import d14cn2ptit.com.salemanagementsystem.utils.StatusbarUtils;

/**
 * Created by thuy on 18/03/2018.
 */

public class LogoFragment extends Fragment {

    public static LogoFragment newInstance(){
        return new LogoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        StatusbarUtils.darkenStatusBar(getActivity(), R.color.colorTextWhite);
        return inflater.inflate(R.layout.fragment_logo, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        showHomeFragment();
    }

    private void showHomeFragment(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ((MainActivity)getActivity()).goToScreen(FragmentUtils.CONTAINER_MAIN, HomeFragment.newInstance(), FragmentUtils.FLAG_REPLACE);
                getActivity().overridePendingTransition(R.anim.splash_in, R.anim.splash_out);
            }
        }, 1000);
    }
}
