package top.liy233.mods.cvt.customvillagertrades;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import top.liy233.mods.cvt.customvillagertrades.ele.Base;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ConfigManager {

    public static ArrayList<Base> parseConfig(){
        CustomVillagerTrades.LOGGER.info("Start to parse Config");
        ArrayList<Base> trades;
        Gson gson = new Gson();
        Type type = new TypeToken<List<Base>>(){}.getType();
        //解析Config
        String config = readFile(CustomVillagerTrades.CONFIG_FILE.toFile());
        trades = gson.fromJson(config, type);
        CustomVillagerTrades.LOGGER.info("Parse over, get "+trades.size()+" trades");
        if (trades.size() == 0){
            throw new NullConfigException();
        }
        return trades;
    }

    public static String readFile(File file){
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader;
        try {
            CustomVillagerTrades.LOGGER.info("Try to read data in "+file.getPath());
            reader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = reader.readLine()) != null){
                buffer.append(text).append(System.getProperty("line.separator"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        CustomVillagerTrades.LOGGER.info("Over read data in "+file.getPath());
        return buffer.toString();
    }

    public static void writeFile(File target, String text){
        try {
            if (!target.exists()){
                target.createNewFile();
                CustomVillagerTrades.LOGGER.info(target.getPath()+"is not exists, create and go on");
            }
            FileWriter writer = new FileWriter(target);
            writer.write(text);
            writer.flush();
            writer.close();
            CustomVillagerTrades.LOGGER.info("Write data in "+target.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void check() throws IOException {
        //配置项文件夹是否存在
        if (! CustomVillagerTrades.CONFIG_PATH.toFile().exists()){
            CustomVillagerTrades.CONFIG_PATH.toFile().mkdir();
        }
        if (!CustomVillagerTrades.CONFIG_FILE.toFile().exists()){
            CustomVillagerTrades.CONFIG_FILE.toFile().createNewFile();
            writeFile(CustomVillagerTrades.CONFIG_FILE.toFile(), "[]");
        }
        if (!CustomVillagerTrades.SAMPLE_CONFIG_FILE.toFile().exists()){
            CustomVillagerTrades.SAMPLE_CONFIG_FILE.toFile().createNewFile();
        }
        writeFile(CustomVillagerTrades.SAMPLE_CONFIG_FILE.toFile(), SAMPLE_CONFIG);
    }

    public static String SAMPLE_CONFIG = """
            [
            {
                "villager":{
                    "profession": "farmer",
                    "level": 1,
                    "max_count": 3,
                    "max_discount": 0.5,
                    "xp": 5
                },
                "item":{
                    "require":[
                        {
                            "name":"minecraft:stone",
                            "count": 1,
                            "nbt": ""
                        }
                    ],
                    "result":{
                        "name": "minecraft:diamond_block",
                        "count": 64,
                        "nbt": ""
                    }
                }
            }
            ]
            """;

}
