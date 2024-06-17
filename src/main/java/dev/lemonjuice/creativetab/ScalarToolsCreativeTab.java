package dev.lemonjuice.creativetab;

import dev.lemonjuice.ScalarTools;
import dev.lemonjuice.item.ScalarToolsItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ScalarToolsCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ScalarTools.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SCALAR_TOOLS_TAB = CREATIVE_MODE_TABS.register("scalar_tools", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.scalar_tools"))
            .icon(() -> new ItemStack(ScalarToolsItems.PRISMATIC_SWORD.get()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == SCALAR_TOOLS_TAB.get()) {
            event.accept(ScalarToolsItems.PRISMATIC_SWORD.get());
            event.accept(ScalarToolsItems.WITHER_IMBUED_SWORD.get());
        }
    }

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
