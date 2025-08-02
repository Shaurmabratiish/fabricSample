package noobsdev.firstmod.mixin;

import net.minecraft.client.gui.screen.ChatScreen;
import noobsdev.firstmod.api.ClientChatSendCallback;
import noobsdev.firstmod.api.sub.ClientChatSendEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatScreen.class)
public class ChatScreenMixin {

    @Inject(method = "sendMessage", at = @At("HEAD"), cancellable = true)
    private void onSendMessage(String message, boolean addToHistory, CallbackInfoReturnable<Boolean> cir) {
        ClientChatSendEvent event = new ClientChatSendEvent(message);
        ClientChatSendCallback.EVENT.invoker().onChatMessage(event);

        if (event.isCanceled()) {
            cir.setReturnValue(true);
        }
    }
}
