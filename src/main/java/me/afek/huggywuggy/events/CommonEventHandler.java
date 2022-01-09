package me.afek.huggywuggy.events;

import com.mojang.blaze3d.systems.RenderSystem;
import me.afek.huggywuggy.HuggyWuggyMod;
import me.afek.huggywuggy.entity.HuggyWuggyEntity;
import me.afek.huggywuggy.item.ModItems;
import me.afek.huggywuggy.packets.PosterCountChangePacket;
import me.afek.huggywuggy.packets.ScaredPacket;
import me.afek.huggywuggy.tileentity.TileEntityLightSource;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.network.PacketDistributor;

import java.awt.*;
import java.util.Random;

public class CommonEventHandler {

    Random random = new Random();
    int time = 0;

    @SubscribeEvent
    public void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModItems.HUGGY_WUGGY_ENTITY.get(), HuggyWuggyEntity.createAttributes().build());
    }

    @SubscribeEvent
    public void writeTextOnScreen(RenderGameOverlayEvent.Post event) {
        FontRenderer fontRenderer = Minecraft.getInstance().font;
        if (HuggyWuggyMod.isHuggy) return;

        if (HuggyWuggyMod.SCARED >= 250) {
            int imageWidth = 400, imageHeight = 400;
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft.getInstance().getTextureManager().bind(new ResourceLocation(HuggyWuggyMod.MODID, "textures/picture.png"));
            int i = (event.getWindow().getWidth() - imageWidth) / 4;
            int j = (event.getWindow().getHeight() - imageHeight) / 4;
            AbstractGui.blit(event.getMatrixStack(), i, j, 0, 0, imageWidth / 2, imageHeight / 2, 256, 256);
            HuggyWuggyMod.SCARED--;
            return;
        }

        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            if (Minecraft.getInstance().player != null) {
                ItemStack itemStack = Minecraft.getInstance().player.getItemBySlot(EquipmentSlotType.MAINHAND).getItem() == ModItems.FLASH_LIGHT_ITEM.get() ? Minecraft.getInstance().player.getItemBySlot(EquipmentSlotType.MAINHAND) : Minecraft.getInstance().player.getItemBySlot(EquipmentSlotType.OFFHAND);
                if (itemStack.getItem() == ModItems.FLASH_LIGHT_ITEM.get()) {
                    String text = "Заряд: " + (itemStack.hasTag() ? ((itemStack.getTag().contains("charge") ? itemStack.getTag().getInt("charge") : 100)) + "%" : "100%");
                    fontRenderer.drawShadow(event.getMatrixStack(), text, event.getWindow().getGuiScaledWidth() - fontRenderer.width(text) - 5, event.getWindow().getGuiScaledHeight() / 2 - 8, new Color(241, 196, 15).getRGB());
                }
            }

            String text = "Постеров: " + HuggyWuggyMod.POSTER_COUNT + "/20";
            fontRenderer.drawShadow(event.getMatrixStack(), text, event.getWindow().getGuiScaledWidth() - fontRenderer.width(text) - 5, event.getWindow().getGuiScaledHeight() / 2 + 8, new Color(241, 196, 15).getRGB());
        }
    }

    @SubscribeEvent
    public void onPlayerPickUp(PlayerEvent.ItemPickupEvent event) {
        if (event.getStack().getItem() == ModItems.POSTER_ITEM.get() && !HuggyWuggyMod.isHuggy) {
            HuggyWuggyMod.POSTER_COUNT++;
            ModidPacketHandler.INSTANCE.send(PacketDistributor.ALL.noArg(), new PosterCountChangePacket(HuggyWuggyMod.POSTER_COUNT));
        }
    }

    @SubscribeEvent
    public void onPlayerInteractEvent(PlayerInteractEvent.RightClickEmpty event) {
        if (!HuggyWuggyMod.isHuggy || event.getEntity() == null) return;
        if (event.getEntity() instanceof ServerPlayerEntity) {
            ServerPlayerEntity entity = (ServerPlayerEntity) event.getEntity();
            ModidPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> entity), new ScaredPacket(false));
        }
    }

    @SubscribeEvent
    public void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!HuggyWuggyMod.isHuggy) return;
        ModidPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()), new PosterCountChangePacket(HuggyWuggyMod.POSTER_COUNT));
    }

    @SubscribeEvent
    public void onPlayerInteractEventLeft(PlayerInteractEvent.LeftClickEmpty event) {
        if (!HuggyWuggyMod.isHuggy) return;
        PlayerEntity player = event.getPlayer();
        if (event.getEntity() == null) return;
        if (event.getEntity() instanceof ServerPlayerEntity) {
            ServerPlayerEntity entity = (ServerPlayerEntity) event.getEntity();
            ModidPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> entity), new ScaredPacket(true));
        }
    }

    @SubscribeEvent
    public void onPlayerUpdate(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
//        CustomServerBossInfoManager customserverbossinfomanager = player.getServer().getCustomBossEvents();
//        ResourceLocation resourceLocation = new ResourceLocation("huggywuggy:bossbar", "id");
//        CustomServerBossInfo customServerBossInfo = customserverbossinfomanager.get(resourceLocation);
//        ;
//        if (customServerBossInfo == null)
//            customServerBossInfo = customserverbossinfomanager.create(resourceLocation, new StringTextComponent("test"));
//
//        customServerBossInfo.setMax(100);
//        customServerBossInfo.setValue(50);
//        customServerBossInfo.setPlayers((Collection<ServerPlayerEntity>) player);

        ItemStack itemStack = player.getItemBySlot(EquipmentSlotType.MAINHAND).getItem() == ModItems.FLASH_LIGHT_ITEM.get() ? player.getItemBySlot(EquipmentSlotType.MAINHAND) : player.getItemBySlot(EquipmentSlotType.OFFHAND);
        if (event.phase == TickEvent.Phase.START && ((player.getItemBySlot(EquipmentSlotType.MAINHAND).getItem() != Items.AIR && player.getItemBySlot(EquipmentSlotType.MAINHAND).getItem() == ModItems.FLASH_LIGHT_ITEM.get() && player.getItemBySlot(EquipmentSlotType.MAINHAND).hasTag() && player.getItemBySlot(EquipmentSlotType.MAINHAND).getTag().getBoolean("active")) || (player.getItemBySlot(EquipmentSlotType.OFFHAND).getItem() != Items.AIR && player.getItemBySlot(EquipmentSlotType.OFFHAND).getItem() == ModItems.FLASH_LIGHT_ITEM.get() && player.getItemBySlot(EquipmentSlotType.OFFHAND).hasTag() && player.getItemBySlot(EquipmentSlotType.OFFHAND).getTag().getBoolean("active")))) {
            int range = 25;

            createLight(player, range);
            int lightNumber = range / 5;
            int lightRange = range;
            for (int i = 0; i < lightNumber; i++) {
                lightRange -= 5;
                createLight(player, lightRange);
            }

            if (time >= random.nextInt(1200 - 350) + 350) {
                CompoundNBT nbt = itemStack.getOrCreateTag();
                int charge = nbt.contains("charge") ? nbt.getInt("charge") : 100;
                nbt.putInt("charge", --charge);
                itemStack.setTag(nbt);
                time = 0;
            }

            time++;
        }
    }

    protected BlockPos lookingAt(PlayerEntity player, int rangeL) {
        return ((BlockRayTraceResult) player.pick(rangeL, 0.0F, false)).getBlockPos();
    }

    private void createLight(PlayerEntity player, int lookingRange) {
        World world = player.level;
        TileEntity tile = null;
        int x = lookingAt(player, lookingRange).getX();
        int y = lookingAt(player, lookingRange).getY();
        int z = lookingAt(player, lookingRange).getZ();
        boolean createLight = false;
        for (int i = 0; i < 5; i++) {
            tile = world.getBlockEntity(new BlockPos(x, y, z));
            if (tile instanceof TileEntityLightSource) {
                createLight = true;
                break;
            }
            if (world.getBlockState(new BlockPos(x, y, z)).getMaterial() != Material.AIR) {
                int pX = (int) (player.getPosition(0)).x;
                int pY = (int) (player.getPosition(0)).y;
                int pZ = (int) (player.getPosition(0)).z;
                if (pX > x) {
                    x++;
                } else if (pX < x) {
                    x--;
                }
                if (pY > y) {
                    y++;
                } else if (pY < y) {
                    y--;
                }
                if (pZ > z) {
                    z++;
                } else if (pZ < z) {
                    z--;
                }
            }
            if (world.getBlockState(new BlockPos(x, y, z)).getMaterial() == Material.AIR) {
                createLight = true;
                break;
            }
        }
        if (createLight) {
            tile = world.getBlockEntity(new BlockPos(x, y, z));
            if (tile instanceof TileEntityLightSource) {
                ((TileEntityLightSource) tile).ticksExisted = 0;
            } else if (world.getBlockState(new BlockPos(x, y, z)).getBlock() != ModItems.LIGHT_SOURCE_BLOCK.get()) {
                world.setBlock(new BlockPos(x, y, z), ModItems.LIGHT_SOURCE_BLOCK.get().defaultBlockState(), 1);
            }
        }
    }
}
