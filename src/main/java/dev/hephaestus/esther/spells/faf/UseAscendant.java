package dev.hephaestus.esther.spells.faf;

import dev.hephaestus.esther.Esther;
import dev.hephaestus.esther.items.AscendantItem;
import dev.hephaestus.esther.spells.Spell;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

public class UseAscendant extends Spell {
    public UseAscendant(Identifier id, Difficulty difficulty, int level) {
        super(id, difficulty, level);
    }

    @Override
    public void cast(ServerPlayerEntity player) {
        super.cast(player);
        try {
            AscendantItem.teleport(player, player.getStackInHand(player.getActiveHand()).getSubTag(Esther.MOD_ID));
        } catch (NullPointerException e) {
        }
    }

    @Override
    public boolean canCast(ServerPlayerEntity player) {
        try {
            return (player.isCreative() || super.canCast(player)) &&
                    player.getStackInHand(player.getActiveHand()).getItem() == Esther.ASCENDANT &&
                    player.getStackInHand(player.getActiveHand()).getTag().contains(Esther.MOD_ID);
        } catch (NullPointerException e) {
            return true;
        }
    }
}
