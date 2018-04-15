package d14cn2ptit.com.salemanagementsystem.home.edit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import d14cn2ptit.com.salemanagementsystem.R;
import d14cn2ptit.com.salemanagementsystem.home.clothes.ClothesFragment;

public class EditClothesFragment extends Fragment {


    ImageView img_clothes;
    EditText name;
    EditText type;
    Button btn_update;
    String namestr, typestr;
    int img;
    int pos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_edit_clothes, container, false);
        namestr = getArguments().getString("editname");
        typestr = getArguments().getString("edittype");
        img = getArguments().getInt("editimage");
        pos = getArguments().getInt("editpos");
        initView(v);
        return v;
    }

    private void initView(View view) {
        img_clothes = (ImageView) view.findViewById(R.id.img_clothes);
        name = (EditText) view.findViewById(R.id.name_clothes);
        type = (EditText) view.findViewById(R.id.type_clothes);
        btn_update = (Button) view.findViewById(R.id.btn_up);
        name.setText(namestr);
        type.setText(typestr);
        img_clothes.setImageResource(img);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_clothes = name.getText().toString();
                String type_clothes = type.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("updatename", name_clothes);
                bundle.putString("updatetype", type_clothes);
//                bundle.putInt("updatetimage",  img_clothes.getI);
                bundle.putInt("updatenumbuer", pos);
                ClothesFragment clothesFragment = new ClothesFragment();
                clothesFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.relativeContentContainer, clothesFragment).commit();
                getActivity().getSupportFragmentManager().beginTransaction().remove(EditClothesFragment.this).commit();

            }
        });
    }


}
