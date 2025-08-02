package noobsdev.firstmod.api;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import noobsdev.firstmod.api.sub.ClientChatSendEvent;

public interface ClientChatSendCallback {
    Event<ClientChatSendCallback> EVENT = EventFactory.createArrayBacked(ClientChatSendCallback.class,
            (listeners) -> (event) -> {
                for (ClientChatSendCallback listener : listeners) {
                    listener.onChatMessage(event);
                    if (event.isCanceled()) {
                        break;
                    }
                }
            });

    void onChatMessage(ClientChatSendEvent event);
}