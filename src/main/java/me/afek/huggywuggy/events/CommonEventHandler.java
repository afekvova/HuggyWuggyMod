package me.afek.huggywuggy.events;

import me.afek.huggywuggy.HuggyWuggyMod;
import me.afek.huggywuggy.entity.HuggyWuggyEntity;
import me.afek.huggywuggy.item.ModItems;
import me.afek.huggywuggy.packets.PosterCountChangePacket;
import me.afek.huggywuggy.packets.ScaredPacket;
import me.afek.huggywuggy.renderer.ScareRenderer;
import me.afek.huggywuggy.renderer.TitleRenderer;
import me.afek.huggywuggy.tileentity.TileEntityLightSource;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
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
    private TitleRenderer titleRenderer;
    private ScareRenderer scareRenderer;

    public CommonEventHandler(TitleRenderer titleRenderer, ScareRenderer scareRenderer) {
        this.titleRenderer = titleRenderer;
        this.scareRenderer = scareRenderer;
    }

    @SubscribeEvent
    public void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModItems.HUGGY_WUGGY_ENTITY.get(), HuggyWuggyEntity.createAttributes().build());
    }

    @SubscribeEvent
    public void clientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.START && !Minecraft.getInstance().isPaused()) {
            this.titleRenderer.tick();
            this.scareRenderer.tick();
        }
    }

    @SubscribeEvent
    public void writeTitle(RenderGameOverlayEvent.Pre event) {
        if (!Minecraft.getInstance().options.renderDebug) {
            this.titleRenderer.renderText(event);
            this.scareRenderer.renderImage(event);
        }
    }

    @SubscribeEvent
    public void writeTextOnScreen(RenderGameOverlayEvent.Post event) {
        FontRenderer fontRenderer = Minecraft.getInstance().font;

        if (HuggyWuggyMod.isHuggy)
            return;

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
            HuggyWuggyMod.getInstance().getTitleRenderer().displayTitle(new StringTextComponent("Кто-то нашёл постер!"), new StringTextComponent("Осталось " + (20 - HuggyWuggyMod.POSTER_COUNT) + " " + padezh("Постер", "", "а", "", (20 - HuggyWuggyMod.POSTER_COUNT))));
            ModidPacketHandler.INSTANCE.send(PacketDistributor.ALL.noArg(), new PosterCountChangePacket(HuggyWuggyMod.POSTER_COUNT));
        }
    }

    public String padezh(String ed, String a, String b, String c, int n) {
        if (n < 0) n = -n;
        int last = n % 100;
        if (last > 10 && last < 21) return ed + c;
        last = n % 10;
        if (last == 0 || last > 4) return ed + c;
        if (last == 1) return ed + a;
        if (last < 5) return ed + b;
        return ed + c;
    }

    @SubscribeEvent
    public void onPlayerInteractEvent(PlayerInteractEvent.RightClickEmpty event) {
        if (!HuggyWuggyMod.isHuggy || event.getEntity() == null) return;
        ModidPacketHandler.INSTANCE.send(PacketDistributor.ALL.noArg(), new ScaredPacket((int) event.getPlayer().position().x(), (int) event.getPlayer().position().y(), (int) event.getPlayer().position().z()));
    }

    @SubscribeEvent
    public void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!HuggyWuggyMod.isHuggy) return;
        ModidPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()), new PosterCountChangePacket(HuggyWuggyMod.POSTER_COUNT));
    }

    @SubscribeEvent
    public void onPlayerUpdate(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        ItemStack itemStack = player.getItemBySlot(EquipmentSlotType.MAINHAND).getItem() == ModItems.FLASH_LIGHT_ITEM.get() ? player.getItemBySlot(EquipmentSlotType.MAINHAND) : player.getItemBySlot(EquipmentSlotType.OFFHAND);
        if (event.phase == TickEvent.Phase.START && ((player.getItemBySlot(EquipmentSlotType.MAINHAND).getItem() != Items.AIR && player.getItemBySlot(EquipmentSlotType.MAINHAND).getItem() == ModItems.FLASH_LIGHT_ITEM.get() && player.getItemBySlot(EquipmentSlotType.MAINHAND).hasTag() && player.getItemBySlot(EquipmentSlotType.MAINHAND).getTag().getBoolean("active")) || (player.getItemBySlot(EquipmentSlotType.OFFHAND).getItem() != Items.AIR && player.getItemBySlot(EquipmentSlotType.OFFHAND).getItem() == ModItems.FLASH_LIGHT_ITEM.get() && player.getItemBySlot(EquipmentSlotType.OFFHAND).hasTag() && player.getItemBySlot(EquipmentSlotType.OFFHAND).getTag().getBoolean("active")))) {
            int range = 2;

            int cx = (int) player.position().x();
            int cy = (int) player.position().y();
            int cz = (int) player.position().z();
            int rSquared = range * range;
            for (int x = cx - range; x <= cx + range; x++) {
                for (int z = cz - range; z <= cz + range; z++) {
                    if ((cx - x) * (cx - x) + (cz - z) * (cz - z) <= rSquared) {
                        if (player.level.getBlockState(new BlockPos(x, cy, z)).getBlock() == Blocks.AIR)
                            createLight(player, new BlockPos(x, cy, z));
                    }
                }
            }

            if (time >= random.nextInt(700 - 100) + 100) {
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

    private void createLight(PlayerEntity player, BlockPos blockPos) {
        World world = player.level;
        TileEntity tile = world.getBlockEntity(blockPos);
        if (!(tile instanceof TileEntityLightSource) && world.getBlockState(blockPos).getBlock() != ModItems.LIGHT_SOURCE_BLOCK.get()) {
            world.setBlock(blockPos, ModItems.LIGHT_SOURCE_BLOCK.get().defaultBlockState(), 1);
        }
    }
}
