package top.furryliy.cvt.util;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import top.furryliy.cvt.CustomVillagerTrades;
import top.furryliy.cvt.elements.Base;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonParse {
    public static ArrayList<Base> parseConfig(){
        CustomVillagerTrades.LOGGER.info("Start to parse Config");
        ArrayList<Base> trades = new ArrayList<>();
        Gson gson = new Gson();
        Type type = new TypeToken<List<Base>>(){}.getType();
        //解析Config
        String config = FileUtil.readFile(CustomVillagerTrades.CVT_CFG.toFile());
        trades = gson.fromJson(config, type);
        CustomVillagerTrades.LOGGER.info("Parse over, get "+trades.size()+" trades");
        return trades;
    }
}
