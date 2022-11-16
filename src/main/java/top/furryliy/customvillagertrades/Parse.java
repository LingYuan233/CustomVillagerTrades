package top.furryliy.customvillagertrades;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import top.furryliy.customvillagertrades.ele.Base;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Parse {
    public static ArrayList<Base> parse(String json){
        Gson gson = new Gson();
        Type type = new TypeToken<List<Base>>(){}.getType();
        ArrayList<Base> baseList = gson.fromJson(json, type);
        return baseList;
    }
}
