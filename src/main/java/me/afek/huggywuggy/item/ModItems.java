package me.afek.huggywuggy.item;

import me.afek.huggywuggy.HuggyWuggyMod;
import me.afek.huggywuggy.blocks.BlockLightSource;
import me.afek.huggywuggy.blocks.CanonBlock;
import me.afek.huggywuggy.blocks.ChargeBlock;
import me.afek.huggywuggy.entity.HuggyWuggyEntity;
import me.afek.huggywuggy.entity.PosterEntity;
import me.afek.huggywuggy.tileentity.TileEntityLightSource;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HuggyWuggyMod.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, HuggyWuggyMod.MODID);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, HuggyWuggyMod.MODID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.ENTITIES, HuggyWuggyMod.MODID);

    public static final RegistryObject<Item> POSTER_ITEM = ITEMS.register("poster_item", () -> new PosterItem((new Item.Properties()).stacksTo(64).tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<Block> LIGHT_SOURCE_BLOCK = BLOCKS.register("lightsource", BlockLightSource::new);
    public static final RegistryObject<Block> CHARGE_BLOCK = BLOCKS.register("chargeblock", ChargeBlock::new);
    public static final RegistryObject<Block> CANON_BLOCK = BLOCKS.register("canonblock", CanonBlock::new);

    public static final RegistryObject<TileEntityType<TileEntityLightSource>> LIGHT_SOURCE = TILE_ENTITIES.register("lightsource", () -> TileEntityType.Builder.of(TileEntityLightSource::new, LIGHT_SOURCE_BLOCK.get()).build(null));
    public static final RegistryObject<Item> FLASH_LIGHT_ITEM = ITEMS.register("flashlight", BaseItemFlashlightClass::new);
    public static final RegistryObject<Item> CHARGE_BLOCK_ITEM = ITEMS.register("chargeblock_item", () -> new BlockItem(CHARGE_BLOCK.get(), (new Item.Properties()).tab(ItemGroup.TAB_DECORATIONS)));
    public static final RegistryObject<Item> CANON_BLOCK_ITEM = ITEMS.register("canonblock_item", () -> new BlockItem(CANON_BLOCK.get(), (new Item.Properties()).tab(ItemGroup.TAB_DECORATIONS)));
    public static final RegistryObject<EntityType<PosterEntity>> POSTER_ENTITY = ENTITY_TYPE.register("posterentity", () -> EntityType.Builder.<PosterEntity>of(PosterEntity::new, EntityClassification.MISC).build(new ResourceLocation(HuggyWuggyMod.MODID, "posterentity").toString()));
    public static final RegistryObject<EntityType<HuggyWuggyEntity>> HUGGY_WUGGY_ENTITY = ENTITY_TYPE.register("huggywuggy_entity", () -> EntityType.Builder.of(HuggyWuggyEntity::new, EntityClassification.MISC).build(new ResourceLocation(HuggyWuggyMod.MODID, "huggywuggy_entity").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPE.register(eventBus);
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        TILE_ENTITIES.register(eventBus);
    }
}
