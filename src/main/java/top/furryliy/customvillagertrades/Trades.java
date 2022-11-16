package top.furryliy.customvillagertrades;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import top.furryliy.customvillagertrades.ele.Base;
import java.util.ArrayList;

public class Trades {
    ArrayList<Base> list;
    public Trades(ArrayList<Base> list){
        this.list = list;
    }

    public void startAdd(){
        int i = 1;
        for (Base base : list){
            Main.LOGGER.info("第"+i+"位自定义配置文件加载");
            addTrades(base);
        }
    }

    private void addTrades(Base base){
        VillagerProfession profession = getProfession(base.getVillager().getProfession());
        int level = base.getVillager().getLevel();
        int xp = base.getVillager().getXp();
        int max_count = base.getVillager().getMax_count();
        float max_discount = base.getVillager().getMax_discount();

        ItemStack require_item = getStackFromId(base.getItem().getRequire().getItem());
        int require_count = base.getItem().getRequire().getCount();

        ItemStack result_item = getStackFromId(base.getItem().getResult().getItem());
        int result_count = base.getItem().getResult().getCount();

        TradeOfferHelper.registerVillagerOffers(profession, level, (factories -> {
            factories.add(((entity, random) -> new TradeOffer(new ItemStack(require_item.getItem(), require_count), new ItemStack(result_item.getItem(), result_count), max_count, xp, max_discount)));
        }));

    }
    private static VillagerProfession getProfession(String name){
        return switch (name) {
            case "farmer" -> VillagerProfession.FARMER;
            case "armorer" -> VillagerProfession.ARMORER;
            case "butcher" -> VillagerProfession.BUTCHER;
            case "cartographer" -> VillagerProfession.CARTOGRAPHER;
            case "cleric" -> VillagerProfession.CLERIC;
            case "fishman" -> VillagerProfession.FISHERMAN;
            case "fletcher" -> VillagerProfession.FLETCHER;
            case "leatherworker" -> VillagerProfession.LEATHERWORKER;
            case "librarian" -> VillagerProfession.LIBRARIAN;
            case "mason" -> VillagerProfession.MASON;
            case "shepherd" -> VillagerProfession.SHEPHERD;
            case "toolsmith" -> VillagerProfession.TOOLSMITH;
            case "weaponsmith" -> VillagerProfession.WEAPONSMITH;
            default -> VillagerProfession.NITWIT;
        };
    }
    private static ItemStack getStackFromId(String id){
        return Registry.ITEM.get(new Identifier(id)).getDefaultStack();
    }

}
