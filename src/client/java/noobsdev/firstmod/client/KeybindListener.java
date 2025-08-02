package noobsdev.firstmod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import noobsdev.firstmod.client.keybinds.GiveNumberKeybind;
import noobsdev.firstmod.client.keybinds.GiveTextKeybind;
import noobsdev.firstmod.client.keybinds.GiveVarKeybind;

import static noobsdev.firstmod.client.itemUtils.GiveItem.giveItemSmart;

public class KeybindListener implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        GiveTextKeybind.register();
        GiveNumberKeybind.register();
        GiveVarKeybind.register();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (GiveTextKeybind.GIVE_ITEM_KEY.wasPressed()) {
                if (client.player != null && client.interactionManager != null && client.currentScreen == null) {
                    giveItemSmart(client, new ItemStack(Items.BOOK, 1));
                }
            }
            while (GiveNumberKeybind.GIVE_ITEM_KEY.wasPressed()) {
                if (client.player != null && client.interactionManager != null && client.currentScreen == null) {
                    giveItemSmart(client, new ItemStack(Items.SLIME_BALL, 1));
                }
            }
            while (GiveVarKeybind.GIVE_ITEM_KEY.wasPressed()) {
                if (client.player != null && client.interactionManager != null && client.currentScreen == null) {
                    giveItemSmart(client, new ItemStack(Items.MAGMA_CREAM, 1));
                }
            }
        });
    }
}
