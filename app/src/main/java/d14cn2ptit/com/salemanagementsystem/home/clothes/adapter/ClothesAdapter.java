package d14cn2ptit.com.salemanagementsystem.home.clothes.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import d14cn2ptit.com.salemanagementsystem.R;
import d14cn2ptit.com.salemanagementsystem.home.clothes.adapter.model.ClothesData;
import d14cn2ptit.com.salemanagementsystem.home.clothes.adapter.model.ViewType;

/**
 * Created by thuy on 18/03/2018.
 */

public class ClothesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int CLOTHES_TYPE = 1;
    private static final int CLOTHES_HEADER = 2;
    private List<ClothesData.ClothesType> clothesTypeList;
    private List<String> clothesHeader;
    private Context context;
    private ItemOnLongClick listener;

    private SparseArray<ViewType> viewTypes;
    private SparseIntArray headerExpandTracker;

    public ClothesAdapter(ItemOnLongClick listener) {
        this.listener = listener;
    }

    public void setClothesTypeList(List<ClothesData.ClothesType> clothesTypeList) {
        this.clothesTypeList = clothesTypeList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == CLOTHES_TYPE) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_clothes_type, parent, false);
            return new ClothesTypeViewHolder(view);

        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_clothes_header, parent, false);
            return new ClothesHeaderViewHolder(view, new ClothesHeaderViewHolder.HeaderViewHolderCallback() {
                @Override
                public void onHeaderClick(int position) {
                    ViewType viewType = viewTypes.get(position);
                    int dataIndex = viewType.getDataIndex();
                    String userType = clothesHeader.get(dataIndex);
                    int childCount = getChildCount(userType);
                    if (headerExpandTracker.get(dataIndex) == 0) {
                        // Collapsed. Now expand it
                        headerExpandTracker.put(dataIndex, 1);
                        notifyItemRangeInserted(position + 1, childCount);
                    } else {
                        // Expanded. Now collapse it
                        headerExpandTracker.put(dataIndex, 0);
                        notifyItemRangeRemoved(position + 1, childCount);
                    }
                }

                @Override
                public boolean isExpanded(int position) {
                    int dataIndex = viewTypes.get(position).getDataIndex();
                    return headerExpandTracker.get(dataIndex) == 1;
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        ViewType viewType = viewTypes.get(position);
        if (itemViewType == CLOTHES_TYPE) {
            bindTypeViewHolder(holder, viewType);
        } else {
            bindHeaderViewHolder(holder, position, viewType);

        }

        //hung code

    }

    private void bindHeaderViewHolder(RecyclerView.ViewHolder holder, int position, ViewType viewType) {
        int dataIndex = viewType.getDataIndex();
        ClothesHeaderViewHolder headerViewHolder = (ClothesHeaderViewHolder) holder;
        headerViewHolder.sectionTitle.setText(clothesHeader.get(dataIndex));
        if (headerViewHolder.callback.isExpanded(position)) {
            headerViewHolder.sectionTitle
                    .setCompoundDrawablesWithIntrinsicBounds(null, null, headerViewHolder.arrowUp, null);
        } else {
            headerViewHolder.sectionTitle
                    .setCompoundDrawablesWithIntrinsicBounds(null, null, headerViewHolder.arrowDown, null);
        }
    }

    private void bindTypeViewHolder(RecyclerView.ViewHolder holder, ViewType viewType) {
        final int dataIndex = viewType.getDataIndex();
        ((ClothesTypeViewHolder) holder).clothesName.setText(clothesTypeList.get(dataIndex).getName());
        ((ClothesTypeViewHolder) holder).desImage.setImageResource(clothesTypeList.get(dataIndex).getImageUrl());
//        Glide.with(mContext).load(clothesTypeList.get(dataIndex).getImageUrl()).into(((ClothesTypeViewHolder) holder).desImage);
        //hung code day

        ((ClothesTypeViewHolder) holder).tableRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final CharSequence[] items = {"Edit", "Delete"};

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle("Select The Action");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        //nếu xóa
                        if (item == 1) {
//                            clothesTypeList.remove(dataIndex);
//                            notifyItemRemoved(dataIndex);
//                            notifyItemRangeChanged(dataIndex, clothesTypeList.size());
                            listener.onDelete(dataIndex);
                        }
                        if(item == 0){

                        }
                    }
                });
                builder.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (clothesHeader != null && clothesTypeList != null) {
            viewTypes.clear();
            int collapsedCount = 0;
            for (int i = 0; i < clothesHeader.size(); i++) {
                viewTypes.put(count, new ViewType(i, CLOTHES_HEADER));
                count += 1;
                String userType = clothesHeader.get(i);
                int childCount = getChildCount(userType);
                if (headerExpandTracker.get(i) != 0) {
                    // Expanded State
                    for (int j = 0; j < childCount; j++) {
                        viewTypes.put(count, new ViewType(count - (i + 1) + collapsedCount, CLOTHES_TYPE));
                        count += 1;
                    }
                } else {
                    // Collapsed
                    collapsedCount += childCount;
                }
            }
        }
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        if (viewTypes.get(position).getType() == CLOTHES_HEADER) {
            return CLOTHES_HEADER;
        } else {
            return CLOTHES_TYPE;
        }
    }

    private int getChildCount(String type) {
        return getCount(type);
    }

    public int getCount(String type){
        int count = 0;
        for(ClothesData.ClothesType t:clothesTypeList){
            if(t.getType().equals(type)) count++;
        }
        return count;
    }

    public void setHeaderAndType(List<ClothesData.ClothesType> clothesTypeList, List<String> clothesHeaderList, Context context) {
        if (clothesTypeList != null && clothesHeaderList != null) {
            this.clothesTypeList = clothesTypeList;
            this.clothesHeader = clothesHeaderList;
            viewTypes = new SparseArray<>(clothesTypeList.size() + clothesHeaderList.size());
            headerExpandTracker = new SparseIntArray(clothesHeaderList.size());
            notifyDataSetChanged();
            this.context = context;
        }
    }

    public static class ClothesHeaderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView sectionTitle;
        private final HeaderViewHolderCallback callback;
        Drawable arrowUp;
        Drawable arrowDown;

        public ClothesHeaderViewHolder(View itemView, HeaderViewHolderCallback callback) {
            super(itemView);
            sectionTitle = (TextView) itemView.findViewById(R.id.text_clothes_header);
            this.callback = callback;
            arrowUp = ContextCompat.getDrawable(itemView.getContext(), R.drawable.ic_keyboard_arrow_up_black_24dp);
            arrowDown = ContextCompat.getDrawable(itemView.getContext(), R.drawable.ic_keyboard_arrow_down_black_24dp);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            callback.onHeaderClick(position);
            if (callback.isExpanded(position)) {
                sectionTitle.setCompoundDrawablesWithIntrinsicBounds(null, null, arrowUp, null);
            } else {
                sectionTitle.setCompoundDrawablesWithIntrinsicBounds(null, null, arrowDown, null);
            }
        }

        public interface HeaderViewHolderCallback {
            void onHeaderClick(int position);

            boolean isExpanded(int position);

        }
    }

    public interface ItemOnLongClick{
        void onDelete(int position);

    }

    public class ClothesTypeViewHolder extends RecyclerView.ViewHolder {
        ImageView desImage;
        TextView clothesName;
        TableRow tableRow;

        public ClothesTypeViewHolder(View itemView) {
            super(itemView);
            desImage = (ImageView) itemView.findViewById(R.id.image_clothes);
            clothesName = (TextView) itemView.findViewById(R.id.text_clothes);
            tableRow = (TableRow) itemView.findViewById(R.id.tbr_item);
        }
    }

}
