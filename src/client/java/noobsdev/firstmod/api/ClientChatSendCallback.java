package noobsdev.firstmod.api;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public interface ClientChatSendCallback {
    Event<ClientChatSendCallback> EVENT = EventFactory.createArrayBacked(ClientChatSendCallback.class,
            (listeners) -> (message) -> {
                for (ClientChatSendCallback listener : listeners) {
                    listener.onChatMessage(message);
                }
            });

    void onChatMessage(String message);
}