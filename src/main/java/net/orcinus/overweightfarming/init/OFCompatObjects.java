package net.orcinus.overweightfarming.init;

import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class OFCompatObjects {

    /// These can return null on get instead of throwing

    public static final Supplier<Item> FD_MELON_JUICE = makeCompatObject("farmersdelight:melon_juice", Registry.ITEM);
    public static final Supplier<Item> TOMATO_SAUCE = makeCompatObject("farmersdelight:tomato_sauce", Registry.ITEM);

    private static <T> Supplier<@Nullable T> makeCompatObject(String name, Registry<T> registry) {
        return Suppliers.memoize(() -> registry.getOptional(new ResourceLocation(name)).orElse(null));
    }
}
