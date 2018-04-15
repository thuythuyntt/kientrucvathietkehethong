package d14cn2ptit.com.salemanagementsystem.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.transition.Fade;
import android.support.transition.TransitionManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import d14cn2ptit.com.salemanagementsystem.R;
import d14cn2ptit.com.salemanagementsystem.activity.MainActivity;
import d14cn2ptit.com.salemanagementsystem.home.book.BookFragment;
import d14cn2ptit.com.salemanagementsystem.home.clothes.ClothesFragment;
import d14cn2ptit.com.salemanagementsystem.home.electronics.ElectronicsFragment;
import d14cn2ptit.com.salemanagementsystem.utils.FragmentUtils;

/**
 * Created by thuy on 17/03/2018.
 */

public class HomeFragment extends Fragment {
//gyqgw
    ImageView imageHomeMenu;
    TextView textTitle;
    ImageView imageRight;
    Toolbar toolbarHeader;
    RelativeLayout relativeContentContainer;
    NavigationView navView;
    DrawerLayout drawer;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        toolbarHeader = (Toolbar) view.findViewById(R.id.toolbarHeader);
        imageHomeMenu = (ImageView) view.findViewById(R.id.imageHomeMenu);
        textTitle = (TextView) view.findViewById(R.id.textTitle);
        navView = (NavigationView) view.findViewById(R.id.nav_view);
        drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        setupView();
        return view;
    }

    private void setupView() {
        setupHeader();
        setupDrawerView();
    }

    private void setupHeader() {
        setHeaderTitle(getResources().getString(R.string.title_book_navigation_bar), true);
        setHeaderLeftButton(R.drawable.ic_home_menu, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawer != null) {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });
    }

    private void setupDrawerView() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.itemBook) {
                    ((MainActivity)getActivity()).goToScreen(R.id.relativeContentContainer, BookFragment.newInstance(), FragmentUtils.FLAG_REPLACE);
                    setHeaderTitle(getResources().getString(R.string.title_book_navigation_bar), true);
                } else if (id == R.id.itemClothes) {
                    ((MainActivity)getActivity()).goToScreen(R.id.relativeContentContainer, ClothesFragment.newInstance(), FragmentUtils.FLAG_REPLACE);
                    setHeaderTitle(getResources().getString(R.string.title_clothes_navigation_bar), true);
                } else if (id == R.id.itemElectronics) {
                    ((MainActivity)getActivity()).goToScreen(R.id.relativeContentContainer, ElectronicsFragment.newInstance(), FragmentUtils.FLAG_REPLACE);
                    setHeaderTitle(getResources().getString(R.string.title_electronics_navigation_bar), true);
                } else if (id == R.id.itemProfile) {
                    Toast.makeText(getActivity(), "Profile", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.itemLogout) {
                    Toast.makeText(getActivity(), "Logout", Toast.LENGTH_SHORT).show();
                }
                if (drawer != null)
                    drawer.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    protected void setHeaderLeftButton(int iconResource, View.OnClickListener onClickListener) {
        imageHomeMenu.setVisibility(View.VISIBLE);
        imageHomeMenu.setImageResource(iconResource);
        imageHomeMenu.setOnClickListener(onClickListener);
    }

    protected void setHeaderTitle(String title, boolean isAnimate) {
        textTitle.setVisibility(View.INVISIBLE);
        if (isAnimate)
            TransitionManager.beginDelayedTransition(toolbarHeader, new Fade());
        textTitle.setVisibility(View.VISIBLE);
        textTitle.setText(title == null ? "" : title.trim().toUpperCase());
    }
}
