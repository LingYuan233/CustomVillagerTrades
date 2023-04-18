package top.furryliy.cvt.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.server.command.ServerCommandSource;
import top.furryliy.cvt.CustomVillagerTrades;
import top.furryliy.cvt.Trades;
import top.furryliy.cvt.util.FileUtil;

import static net.minecraft.server.command.CommandManager.literal;

public class CVTCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher){
        dispatcher.register(literal("cvt")//根命令
                .then(literal("reload").executes(ctx -> reload(ctx)))//二级命令
        );
    }

    private static int reload(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException {
        ItemStack item = ctx.getSource().getPlayer().getMainHandStack();
        assert item.getNbt() != null;
        NbtCompound nbt = NbtHelper.fromNbtProviderString("{Damage:0,Enchantments:[{id:\"minecraft:efficiency\",lvl:5s}],RepairCost:1}");
        ItemStack i = new ItemStack(Items.ITEM_FRAME);
        i.setNbt(nbt);
        ctx.getSource().getPlayer().giveItemStack(i);
//        FileUtil.writeFile(CustomVillagerTrades.CONFIG_DIR.resolve("nbt.txt").toFile(), item.getNbt().toString());
        return Command.SINGLE_SUCCESS;
    }
}
