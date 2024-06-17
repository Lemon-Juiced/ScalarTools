package dev.lemonjuice.item.sword;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

/**
 * Wither Imbued Sword Item
 * When the player attacks an entity with the Wither Imbued Sword, the entity will be withered for five seconds.
 */
public class WitherImbuedSwordItem extends AbstractBaseSwordItem {
    public WitherImbuedSwordItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.translatable("tooltip.scalar_tools.wither_imbued_sword"));
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity livingEntity, LivingEntity attacker) {
        livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
        return super.hurtEnemy(itemStack, livingEntity, attacker);
    }
}
