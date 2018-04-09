package d14cn2ptit.com.salemanagementsystem.home.clothes.adapter.model;

import java.util.ArrayList;
import java.util.List;

import d14cn2ptit.com.salemanagementsystem.R;

/**
 * Created by Srijith on 08-10-2017.
 */

public class ClothesData extends MyItems {

    private List<ClothesType> clothesTypeList = new ArrayList<ClothesType>() {
        {
            add(new ClothesType(0, "Suit", R.drawable.men_suit, "Men's fashion"));
            add(new ClothesType(1, "Shirt", R.drawable.men_shirt, "Men's fashion"));
            add(new ClothesType(2, "Sweater", R.drawable.men_sweater, "Men's fashion"));
            add(new ClothesType(3, "Jacket", R.drawable.men_jacket, "Men's fashion"));
            add(new ClothesType(4, "Jeans", R.drawable.men_jeans, "Men's fashion"));
            add(new ClothesType(5, "Dress", R.drawable.women_dress, "Women's fashion"));
            add(new ClothesType(6, "Skirt", R.drawable.women_skirt, "Women's fashion"));
            add(new ClothesType(7, "T-shirt", R.drawable.women_tshirt, "Women's fashion"));
            add(new ClothesType(8, "Trousers & Leggings", R.drawable.women_legging, "Women's fashion"));
            add(new ClothesType(9, "Jeans", R.drawable.women_jeans, "Women's fashion"));
            add(new ClothesType(10, "Sport shoes", R.drawable.sport_shoes, "Shoes"));
            add(new ClothesType(11, "Slip-on", R.drawable.slip_on_shoes, "Shoes"));
            add(new ClothesType(12, "High heels", R.drawable.high_heels, "Shoes"));
            add(new ClothesType(13, "Sandals", R.drawable.sandals, "Shoes"));
            add(new ClothesType(14, "Flip-flops", R.drawable.flip_flop, "Shoes"));
            add(new ClothesType(15, "Backpack", R.drawable.backpack, "Bag"));
            add(new ClothesType(16, "Satchel bag", R.drawable.satchel_bag, "Bag"));
            add(new ClothesType(17, "Handbag", R.drawable.handbag, "Bag"));
        }
    };

    private List<String> clothesHeaderList = new ArrayList<String>() {
        {
            add("Men's fashion");
            add("Women's fashion");
            add("Shoes");
            add("Bag");
        }
    };

    public List<ClothesType> getClothesTypeList() {
        return clothesTypeList;
    }

    public List<String> getClothesHeaderList() {
        return clothesHeaderList;
    }

    public class ClothesType {

        private int id;
        private String name;
        private int imageUrl;
        private String type;

        public ClothesType(int id, String name, int imageUrl, String type) {
            this.id = id;
            this.name = name;
            this.imageUrl = imageUrl;
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getImageUrl() {
            return imageUrl;
        }

        public String getType() {
            return type;
        }

        public Object clone() {
            Object clone = null;
            try {
                clone = super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return clone;

        }
    }
}
