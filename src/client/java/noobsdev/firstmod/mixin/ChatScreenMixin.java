package noobsdev.firstmod.mixin;

import net.minecraft.client.gui.screen.ChatScreen;
import noobsdev.firstmod.api.ClientChatSendCallback;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatScreen.class)
public class ChatScreenMixin {
    @Inject(method = "sendMessage", at = @At("HEAD"))
    private void onSendMessage(String chatText, boolean addToHistory, CallbackInfoReturnable<Boolean> cir) {
        ClientChatSendCallback.EVENT.invoker().onChatMessage(chatText);
    }
}
