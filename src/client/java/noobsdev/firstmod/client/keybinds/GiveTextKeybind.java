package noobsdev.firstmod.client.keybinds;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;


public class GiveTextKeybind {
    public static KeyBinding GIVE_ITEM_KEY;

    public static void register() {
        GIVE_ITEM_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.firstmod.give_item_text",
                InputUtil.Type.KEYSYM,
                -1,
                "category.firstmod.keys"
        ));
    }
}