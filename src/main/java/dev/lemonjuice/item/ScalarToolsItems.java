package dev.lemonjuice.item;

import dev.lemonjuice.item.sword.AbstractBaseSwordItem;
import dev.lemonjuice.item.sword.HalitosisSwordItem;
import dev.lemonjuice.item.sword.PrismaticSwordItem;
import dev.lemonjuice.item.sword.WitherImbuedSwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static dev.lemonjuice.ScalarTools.MOD_ID;

public class ScalarToolsItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

    public static final Supplier<HalitosisSwordItem> HALITOSIS_SWORD = ITEMS.register("halitosis_sword", () -> new HalitosisSwordItem(Tiers.NETHERITE, swordPropertyGenerator(Tiers.NETHERITE)));
    public static final Supplier<PrismaticSwordItem> PRISMATIC_SWORD = ITEMS.register("prismatic_sword", () -> new PrismaticSwordItem(Tiers.IRON, swordPropertyGenerator(Tiers.IRON)));
    public static final Supplier<WitherImbuedSwordItem> WITHER_IMBUED_SWORD = ITEMS.register("wither_imbued_sword", () -> new WitherImbuedSwordItem(Tiers.DIAMOND, swordPropertyGenerator(Tiers.DIAMOND)));

    /**
     * Generates the properties for a sword item
     *
     * @param tier The tier of the sword
     * @return The properties for the sword
     */
    public static Item.Properties swordPropertyGenerator(Tier tier){
        return new Item.Properties().attributes(SwordItem.createAttributes(tier, 3, -2.4f));
    }

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
