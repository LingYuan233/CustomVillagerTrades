package top.furryliy.customvillagertrades;

import net.fabricmc.loader.api.FabricLoader;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Objects;

public class WriteFile {
    public static void write(File target, String text){
        try {
            if (!target.exists()){
                target.createNewFile();
                Main.LOGGER.info(target.getPath()+"文件不存在，已自动创建继续写入");
            }
            FileWriter writer = new FileWriter(target);
            writer.write(text);
            writer.flush();
            writer.close();
            Main.LOGGER.info(target.getPath()+"已写入数据");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
