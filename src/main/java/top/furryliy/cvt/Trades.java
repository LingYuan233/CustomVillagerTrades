package top.furryliy.cvt;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import top.furryliy.cvt.elements.Base;
import top.furryliy.cvt.util.FileUtil;
import top.furryliy.cvt.util.JsonParse;

import java.util.ArrayList;

public class Trades {
    public final ArrayList<Base> list;
    private Trades(ArrayList<Base> ls){
        this.list = ls;
    }
    public static Trades getTrades(){
        return new Trades(JsonParse.parseConfig());
    }

    public void registerTrades() throws CommandSyntaxException {
        CustomVillagerTrades.LOGGER.info("Start to registry Trades");
        for (int i = 0; i < list.size(); i++) {
            CustomVillagerTrades.LOGGER.info("Registering trade No."+i);
            //如果require只有一个物品，进入rM_1，否则进入rM_2
            if (list.get(i).getItem().getRequire().length == 1){
                registerMethod_1(list.get(i));
            }
            else {
                registerMethod_2(list.get(i));
            }
        }
        CustomVillagerTrades.LOGGER.info("Registry over");
    }


    //注册方法
    private void registerMethod_1(Base base) throws CommandSyntaxException {
        VillagerProfession profession = getProfession(base.getVillager().getProfession());
        int level = base.getVillager().getLevel();
        int xp = base.getVillager().getXp();
        int max_count = base.getVillager().getMax_count();
        float max_discount = base.getVillager().getMax_discount();

        ItemStack require = new ItemStack(getStackFromId(base.getItem().getRequire()[0].getName()), base.getItem().getRequire()[0].getCount());
        if (! base.getItem().getRequire()[0].getNbt().equals("")){
            require.setNbt(FileUtil.getNBT(base.getItem().getRequire()[0].getNbt()));
        }

        ItemStack result = new ItemStack(getStackFromId(base.getItem().getResult().getName()), base.getItem().getResult().getCount());
        if (! base.getItem().getResult().getNbt().equals("")){
            require.setNbt(FileUtil.getNBT(base.getItem().getResult().getNbt()));
        }

        TradeOfferHelper.registerVillagerOffers(profession, level, (factories -> {
            factories.add(((entity, random) ->
                    new TradeOffer(
                            require,
                            result,
                            max_count, xp, max_discount)));
        }));
    }
    private void registerMethod_2(Base base) throws CommandSyntaxException {
        VillagerProfession profession = getProfession(base.getVillager().getProfession());
        int level = base.getVillager().getLevel();
        int xp = base.getVillager().getXp();
        int max_count = base.getVillager().getMax_count();
        float max_discount = base.getVillager().getMax_discount();

        ItemStack require_1 = new ItemStack( getStackFromId(base.getItem().getRequire()[0].getName()), base.getItem().getRequire()[0].getCount());
        if (! base.getItem().getRequire()[0].getNbt().equals("")){
            require_1.setNbt(FileUtil.getNBT(base.getItem().getRequire()[0].getNbt()));
        }

        ItemStack require_2 = new ItemStack( getStackFromId(base.getItem().getRequire()[1].getName()), base.getItem().getRequire()[1].getCount());
        if (! base.getItem().getRequire()[0].getNbt().equals("")){
            require_2.setNbt(FileUtil.getNBT(base.getItem().getRequire()[1].getNbt()));
        }

        ItemStack result = new ItemStack( getStackFromId(base.getItem().getResult().getName()), base.getItem().getResult().getCount());
        if (! base.getItem().getResult().getNbt().equals("")){
            result.setNbt(FileUtil.getNBT(base.getItem().getRequire()[0].getNbt()));
        }

        TradeOfferHelper.registerVillagerOffers(profession, level, (factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    require_1,
                    require_2,
                    result,
                    max_count, xp, max_discount)));
        }));
    }

    //工具方法
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
    private static Item getStackFromId(String id){
        return Registry.ITEM.get(new Identifier(id));
    }
}
