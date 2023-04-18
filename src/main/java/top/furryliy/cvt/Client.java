package top.furryliy.cvt;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import top.furryliy.cvt.commands.CVTCommand;

public class Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CommandRegistrationCallback.EVENT.register(((dispatcher, dedicated) -> {
            //有bug被废弃
            //CVTCommand.register(dispatcher);
        }));
    }
}
