package d14cn2ptit.com.salemanagementsystem.home.clothes.adapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by thuy on 18/03/2018.
 */

public class ClothesModel {
    public String name;
    public ArrayList<Type> list;

    public ClothesModel(String name, ArrayList<Type> list) {
        this.name = name;
        this.list = list;
    }

    public class Type{
        public String name;

        public Type(String name) {
            this.name = name;
        }
    }
}
