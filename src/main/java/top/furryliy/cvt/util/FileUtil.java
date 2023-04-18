package top.furryliy.cvt.util;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import top.furryliy.cvt.CustomVillagerTrades;

import java.io.*;

public class FileUtil {
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
        CustomVillagerTrades.LOGGER.info("Check folder info...");

        if (! CustomVillagerTrades.CONFIG_DIR.toFile().exists()){
            CustomVillagerTrades.LOGGER.info("cfg folder not found, create and writing data.");
            CustomVillagerTrades.CONFIG_DIR.toFile().mkdir();
            writeFile(CustomVillagerTrades.CVT_CFG.toFile(), "[]");
        }
        //不管怎么样，都需要覆盖一遍sample.txt
        writeFile(CustomVillagerTrades.CVT_SAM.toFile(), SAMPLE);
    }

    public static NbtCompound getNBT(String key) throws CommandSyntaxException {
        File file = CustomVillagerTrades.CVT_NBT.resolve(key+".nbt.txt").toFile();
        return NbtHelper.fromNbtProviderString(readFile(file));
    }



    public static final String SAMPLE = """
            [
              {
                "villager": {
                  "profession": "farmer",
                  "level": 1,
                  "max_count": 3,
                  "max_discount": 0.5,
                  "xp": 5
                },
                "item": {
                  "require": [
                    {
                      "name": "minecraft:diamond_block",
                      "count": 64
                    },
                    {
                      "name": "minecraft:diamond",
                      "count": 64
                    }
                  ],
                  "result": {
                    "name": "minecraft:wheat",
                    "count": 1
                  }
                }
              }
            ]
            """;
}
