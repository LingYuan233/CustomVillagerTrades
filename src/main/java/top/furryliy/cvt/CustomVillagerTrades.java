package top.furryliy.cvt;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.lwjgl.system.CallbackI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.furryliy.cvt.elements.Base;
import top.furryliy.cvt.util.FileUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class CustomVillagerTrades implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("CVT");

	//主配置文件夹
	public static final Path CONFIG_DIR = FabricLoader.getInstance().getConfigDir().resolve("CVT");
	//配置文件
	public static final Path CVT_CFG = CONFIG_DIR.resolve("CVT.json");
	//示例文件
	public static final Path CVT_SAM = CONFIG_DIR.resolve("sample.txt");
	//NBT文件夹
	public static final Path CVT_NBT = CONFIG_DIR.resolve("nbt");



	@Override
	public void onInitialize() {
		LOGGER.info("CVT initialization...");
		try {
			FileUtil.check();
			Trades trades = Trades.getTrades();
			trades.registerTrades();
		} catch (IOException | CommandSyntaxException e) {
			throw new RuntimeException(e);
		}
	}
}
