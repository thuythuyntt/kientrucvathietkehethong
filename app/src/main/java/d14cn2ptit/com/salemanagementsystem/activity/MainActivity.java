package d14cn2ptit.com.salemanagementsystem.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import d14cn2ptit.com.salemanagementsystem.R;
import d14cn2ptit.com.salemanagementsystem.home.LogoFragment;
import d14cn2ptit.com.salemanagementsystem.utils.FragmentUtils;
import d14cn2ptit.com.salemanagementsystem.utils.KeyboardUtils;
import d14cn2ptit.com.salemanagementsystem.utils.StatusbarUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goToScreen(LogoFragment.newInstance());
        StatusbarUtils.darkenStatusBar(this, R.color.colorHeader);
    }

    //abc

    public <F extends Fragment> void goToScreen(@NonNull F fragment) {
        goToScreen(FragmentUtils.CONTAINER_MAIN, fragment, FragmentUtils.FLAG_ADD);
    }

    public <F extends Fragment> void goToScreen(int containerLayoutResource,
                                                @NonNull F fragment,
                                                int actionFlag) {
        goToScreen(containerLayoutResource, fragment, actionFlag, null);
    }

    public <F extends Fragment> void goToScreen(int containerLayoutResource,
                                                @NonNull F fragment,
                                                int actionFlag, View element) {
        hideKeyboard();
        if (actionFlag == FragmentUtils.FLAG_ADD) {
            FragmentUtils.add(getSupportFragmentManager(), containerLayoutResource, fragment, true, element);
        } else if (actionFlag == FragmentUtils.FLAG_REPLACE) {
            FragmentUtils.replace(getSupportFragmentManager(), containerLayoutResource, fragment, false, element);
        } else if (actionFlag == FragmentUtils.FLAG_NEW_TASK) {
            FragmentUtils.clearBackStack(getSupportFragmentManager());
            FragmentUtils.replace(getSupportFragmentManager(), containerLayoutResource, fragment, true, element);
        }
    }

    public void backToScreen(String screenName) {
        hideKeyboard();
        FragmentUtils.backToFragment(getSupportFragmentManager(), screenName);
    }

    public void moveBack() {
        hideKeyboard();
        FragmentUtils.moveBack(getSupportFragmentManager(), this);
    }

    protected void clearAllScreens() {
        FragmentUtils.clearBackStack(getSupportFragmentManager());
    }

    public void showKeyboard(EditText editText) {
        KeyboardUtils.showKeyboard(editText, this);
    }

    public void hideKeyboard() {
        KeyboardUtils.hideKeyboard(this);
    }
}
