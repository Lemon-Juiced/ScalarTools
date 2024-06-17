package dev.lemonjuice.item.sword;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * Prismatic Sword Item
 * When the player holds the Prismatic Sword they can grant themselves five seconds of water breathing.
 */
public class PrismaticSwordItem extends AbstractBaseSwordItem {
    public PrismaticSwordItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.translatable("tooltip.scalar_tools.prismatic_sword"));
    }

    /**
     * When the player uses the Prismatic Sword they can grant themselves five seconds of water breathing.
     *
     * @param level The level
     * @param player The player
     * @param interactionHand The interaction hand
     * @return
     */
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 100, 0));
        return super.use(level, player, interactionHand);
    }
}
