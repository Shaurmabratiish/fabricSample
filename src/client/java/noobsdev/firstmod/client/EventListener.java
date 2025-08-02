package noobsdev.firstmod.client;

import net.fabricmc.api.ClientModInitializer;
import noobsdev.firstmod.client.events.ChatCallbackEvent;

public class EventListener implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ChatCallbackEvent.register();
    }
}
