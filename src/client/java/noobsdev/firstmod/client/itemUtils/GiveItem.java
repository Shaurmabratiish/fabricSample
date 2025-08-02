package noobsdev.firstmod.client.itemUtils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;
import net.minecraft.text.Text;

public class GiveItem {
    public static void giveItemSmart(MinecraftClient client, ItemStack item) {
        ClientPlayerEntity player = client.player;

        if (!player.getAbilities().creativeMode) {
            player.sendMessage(Text.of("Ты не в креативе, братан! Сервер не даст тебе алмаз."), false);
            return;
        }

        PlayerInventory inv = player.getInventory();

        ItemStack held = inv.getMainHandStack();
        int targetSlot;

        if (held.isEmpty()) {
            // Кладём прямо в руку
            targetSlot = 36 + inv.selectedSlot;
        } else {
            targetSlot = findFreeSlot(inv);
            if (targetSlot == -1) {
                player.sendMessage(Text.of("Инвентарь забит! 😭"), false);
                return;
            }
        }

        // Отправляем серверу валидный пакет
        client.getNetworkHandler().sendPacket(
                new CreativeInventoryActionC2SPacket(targetSlot, item)
        );
    }

    private static int findFreeSlot(PlayerInventory inv) {
        // Слоты 9–35 — основной инвентарь
        for (int i = 9; i < 36; i++) {
            if (inv.getStack(i).isEmpty()) {
                return i;
            }
        }
        return -1;
    }
}
