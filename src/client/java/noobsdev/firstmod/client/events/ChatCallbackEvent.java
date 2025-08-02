package noobsdev.firstmod.client.events;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import noobsdev.firstmod.api.ClientChatSendCallback;

public class ChatCallbackEvent {
    public static void register() {
        ClientChatSendCallback.EVENT.register((event) -> {
            if (event.getMessage().equalsIgnoreCase("привет")) {
                MinecraftClient.getInstance().player.sendMessage(Text.of("Привет от обработчика!"), false);
            }else {
                event.setCanceled(true);
            }
        });
    }
}
