package noobsdev.firstmod.client;

import net.fabricmc.api.ClientModInitializer;
import noobsdev.firstmod.client.commands.*;

public class CommandListener implements ClientModInitializer{


    @Override
    public void onInitializeClient() {
        clienttaterCommand.register();
    }
}