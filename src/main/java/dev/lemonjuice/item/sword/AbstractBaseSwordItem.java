package dev.lemonjuice.item.sword;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

/**
 * Abstract Base Sword Item
 * This class is the base for all sword items.
 * This may be redundant, but will be useful if we need to add additional functionality to all swords.
 */
public class AbstractBaseSwordItem extends SwordItem {
    public AbstractBaseSwordItem(Tier tier, Properties properties) {
        super(tier, properties);
    }
}
