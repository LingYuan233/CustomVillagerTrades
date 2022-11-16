package top.furryliy.customvillagertrades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;

public class ReadFile {
    public static String readCfg(Path path) throws InterruptedException {
        File file = path.toFile();
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = reader.readLine()) != null){
                buffer.append(text).append(System.getProperty("line.separator"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
