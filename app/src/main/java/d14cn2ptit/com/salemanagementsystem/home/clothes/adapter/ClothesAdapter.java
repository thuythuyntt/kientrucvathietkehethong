package d14cn2ptit.com.salemanagementsystem.home.clothes.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import d14cn2ptit.com.salemanagementsystem.R;

/**
 * Created by thuy on 18/03/2018.
 */

public class ClothesAdapter extends RecyclerView.Adapter {
    public static final int ITEM_HEADER = 1;
    public static final int ITEM_TYPE = 2;

    ArrayList<ClothesModel> clothesModels = new ArrayList<>();

    public void setClothesModels(ArrayList<ClothesModel> clothesModels) {
        this.clothesModels = clothesModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_HEADER)
            return new ClothesHeaderHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_clothes_header, parent, false));
        else
            return new ClothesTypeHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_clothes_type, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ClothesHeaderHolder) {
            ((ClothesHeaderHolder) holder).bindData(position);
        } else if(holder instanceof ClothesTypeHolder){
            ((ClothesTypeHolder) holder).bindData(position);
        }
    }

    @Override
    public int getItemCount() {
        return clothesModels.size()+clothesModels.li;
    }

    public class ClothesHeaderHolder extends RecyclerView.ViewHolder {

        public ClothesHeaderHolder(View itemView) {
            super(itemView);
        }

        public void bindData(int position){

        }
    }

    public class ClothesTypeHolder extends RecyclerView.ViewHolder {

        public ClothesTypeHolder(View itemView) {
            super(itemView);
        }

        public void bindData(int position){

        }
    }
}
