package net.orcinus.overweightfarming.integration;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class CompatObjects {
    /*
      * Object Holders
      *
      * these can return null on get instead of throwing
    */

    public static final Supplier<Item> MELON_JUICE = makeCompatObject("farmersdelight:melon_juice", ForgeRegistries.ITEMS);

    private static <T extends IForgeRegistryEntry<T>, U extends T> NullableRegistryObject<T, U> makeCompatObject(String name, IForgeRegistry<T> registry) {
        return new NullableRegistryObject<>(getRegistryObject(name, registry));
    }

    private static <T extends IForgeRegistryEntry<T>, U extends T> RegistryObject<U> getRegistryObject(String name, IForgeRegistry<T> registry) {
        return RegistryObject.create(new ResourceLocation(name), registry);
    }

    private record NullableRegistryObject<T extends IForgeRegistryEntry<T>, U extends T>(RegistryObject<U> obj) implements Supplier<T> {
        @Nullable
        @Override
        public T get() {
            return obj.orElse(null);
        }
    }
}
