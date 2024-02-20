package top.liy233.mods.cvt.customvillagertrades;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class CustomVillagerTrades implements ModInitializer {

    public static Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("CustomVillagerTrades");
    public static Path CONFIG_FILE = CONFIG_PATH.resolve("CVT.json");
    public static Path SAMPLE_CONFIG_FILE = CONFIG_PATH.resolve("sample.txt");
    public static Logger LOGGER = LoggerFactory.getLogger("CVT");
    @Override
    public void onInitialize() {
        try {
            ConfigManager.check();
            Trades trades = Trades.getTrades();

            trades.registerTrades();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
