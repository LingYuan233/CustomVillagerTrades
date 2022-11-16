package top.furryliy.customvillagertrades;

import com.mojang.datafixers.types.templates.Check;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.furryliy.customvillagertrades.ele.Base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("自定义村民交易");
	Path cfgFile = FabricLoader.getInstance().getConfigDir().resolve("CustomVillagerTrades/VillagerConfig.json");
	Path cvt_cfg_dir = FabricLoader.getInstance().getConfigDir().resolve("CustomVillagerTrades");
	Path cfg_dir = FabricLoader.getInstance().getConfigDir();
	@Override
	public void onInitialize() {
		CheckFile.check(cvt_cfg_dir);
		LOGGER.info("自定义村民模组加载成功");
		try {
			Thread.sleep(100);
			WriteFile.write(FabricLoader.getInstance().getConfigDir().resolve("CustomVillagerTrades/sample.txt").toFile(), ConfigText.defaultCfg);
			String cfg = ReadFile.readCfg(cfgFile);
			ArrayList<Base> list = Parse.parse(cfg);
			Trades trades = new Trades(list);
			trades.startAdd();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
