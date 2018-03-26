package d14cn2ptit.com.salemanagementsystem.home.clothes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import d14cn2ptit.com.salemanagementsystem.R;
import d14cn2ptit.com.salemanagementsystem.home.clothes.adapter.ClothesAdapter;
import d14cn2ptit.com.salemanagementsystem.home.clothes.adapter.model.ClothesData;

/**
 * Created by thuy on 18/03/2018.
 */

public class ClothesFragment extends Fragment {
    public static final String MY_TAG = ClothesFragment.class.getSimpleName();
    View view;
    RecyclerView recycleList;
    ClothesAdapter adapter;

    public static ClothesFragment newInstance() {
        return new ClothesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_clothes, container, false);
        initialization();
        return view;
    }

    public void initialization(){
        recycleList = (RecyclerView) view.findViewById(R.id.recycle_list);
        adapter = new ClothesAdapter();
        ClothesData data = new ClothesData();
        List<ClothesData.ClothesType> clothesTypeList = data.getClothesTypeList();
        List<String> clothesHeaderList = data.getClothesHeaderList();
        adapter.setHeaderAndType(clothesTypeList, clothesHeaderList);
        Log.d(MY_TAG, clothesHeaderList.size() + " " + clothesTypeList.size());

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recycleList.setLayoutManager(llm);

        recycleList.setAdapter(adapter);
    }
}
