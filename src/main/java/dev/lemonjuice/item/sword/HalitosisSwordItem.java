package dev.lemonjuice.item.sword;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
 * Halitosis Sword Item
 * When the player holds the Prismatic Sword they switch between off-mode, fire-mode, and poison-mode.
 */
public class HalitosisSwordItem extends AbstractBaseSwordItem {
    final String defaultMode = "off";
    String currentMode;

    public HalitosisSwordItem(Tier tier, Properties properties) {
        super(tier, properties);
        this.currentMode = defaultMode;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.translatable("tooltip.scalar_tools.halitosis_sword"));

        // This is a stupid way to do this, but it seems that this is the only way it will work.
        Component modeComponent = Component.translatable("tooltip.scalar_tools.halitosis_sword.current_mode");
        Component offComponent = Component.translatable("tooltip.scalar_tools.halitosis_sword.current_mode_off").withStyle(ChatFormatting.YELLOW);
        Component fireComponent = Component.translatable("tooltip.scalar_tools.halitosis_sword.current_mode_fire").withStyle(ChatFormatting.RED);
        Component poisonComponent = Component.translatable("tooltip.scalar_tools.halitosis_sword.current_mode_poison").withStyle(ChatFormatting.GREEN);

        Component offModeComponent = modeComponent.copy().append(offComponent);
        Component fireModeComponent = modeComponent.copy().append(fireComponent);
        Component poisonModeComponent = modeComponent.copy().append(poisonComponent);

        if (currentMode.equals("off")) components.add(offModeComponent);
        else if (currentMode.equals("fire")) components.add(fireModeComponent);
        else components.add(poisonModeComponent);
    }

    /**
     * When the player uses the Prismatic Sword they right-click to switch between off-mode, fire-mode, and poison-mode.
     *
     * @param level The level
     * @param player The player
     * @param interactionHand The interaction hand
     * @return
     */
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        if(currentMode.equals("fire")) currentMode = "poison";
        else if(currentMode.equals("off")) currentMode = "fire";
        else currentMode = "off";
        level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.EXPERIENCE_ORB_PICKUP, player.getSoundSource(), 1.0f, 1.0f);
        return super.use(level, player, interactionHand);
    }

    /**
     * When the player attacks an entity with the Halitosis Sword, the entity will be affected by the current mode.
     * If the current mode is off-mode, the entity will not be affected.
     * If the current mode is fire-mode, the entity will be set on fire for five seconds.
     * If the current mode is poison-mode, the entity will be poisoned for five seconds.
     *
     * @param itemStack The item stack
     * @param livingEntity The living entity
     * @param attacker The attacker
     */
    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity livingEntity, LivingEntity attacker) {
        if(currentMode.equals("fire")) livingEntity.setRemainingFireTicks(100);
        else if(currentMode.equals("poison")) livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0));
        return super.hurtEnemy(itemStack, livingEntity, attacker);
    }
}
