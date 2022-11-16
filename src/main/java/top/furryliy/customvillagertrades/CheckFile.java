package top.furryliy.customvillagertrades;

import java.io.File;
import java.nio.file.Path;

public class CheckFile {
    public static void check(Path path){
        File cfg = path.toFile();
        if (!cfg.exists()){
            cfg.mkdir();
        }
        File cfgFile = path.resolve("VillagerConfig.json").toFile();
        WriteFile.write(cfgFile, "[]");
    }
}
