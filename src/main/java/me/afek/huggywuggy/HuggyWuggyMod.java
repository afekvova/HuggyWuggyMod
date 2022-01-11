package me.afek.huggywuggy;

import me.afek.huggywuggy.entity.HuggyWuggyEntity;
import me.afek.huggywuggy.entity.HuggyWuggyRender;
import me.afek.huggywuggy.events.CommonEventHandler;
import me.afek.huggywuggy.events.ModidPacketHandler;
import me.afek.huggywuggy.item.ModItems;
import me.afek.huggywuggy.renderer.ScareRenderer;
import me.afek.huggywuggy.renderer.TitleRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.PaintingRenderer;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(HuggyWuggyMod.MODID)
public class HuggyWuggyMod {

    public static final String MODID = "huggywuggy";
    private static final Logger LOGGER = LogManager.getLogger();
    public static int POSTER_COUNT = 0, SCARED;
    public static boolean isHuggy = false;
    private TitleRenderer titleRenderer;
    private ScareRenderer scareRenderer;
    private static HuggyWuggyMod instance;

    public HuggyWuggyMod() {
        instance = this;
        this.scareRenderer = new ScareRenderer(70, new ResourceLocation(HuggyWuggyMod.MODID, "textures/picture.png"));
        this.titleRenderer = new TitleRenderer(1, 70, 2, "00FF00", true, 3.0D, 0.0D, -15.0D, true);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        eventBus.addGenericListener(PaintingType.class, this::registerPaintings);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new CommonEventHandler(this.titleRenderer, this.scareRenderer));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(ModItems.HUGGY_WUGGY_ENTITY.get(), HuggyWuggyEntity.createAttributes().build()));
    }

    private void clientSetup(FMLClientSetupEvent event) {
        ModidPacketHandler.init();
        RenderTypeLookup.setRenderLayer(ModItems.CHARGE_BLOCK.get(), RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(ModItems.CANON_BLOCK.get(), RenderType.cutoutMipped());
        RenderingRegistry.registerEntityRenderingHandler(ModItems.POSTER_ENTITY.get(), PaintingRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModItems.HUGGY_WUGGY_ENTITY.get(), HuggyWuggyRender::new);
    }

    public static HuggyWuggyMod getInstance() {
        return instance;
    }

    public TitleRenderer getTitleRenderer() {
        return titleRenderer;
    }

    public ScareRenderer getScareRenderer() {
        return scareRenderer;
    }

    @SubscribeEvent
    public void onCommandsRegister(RegisterCommandsEvent event) {
        new SetupCommand(event.getDispatcher());
        new ClearScoreCommand(event.getDispatcher());
    }

    public static PaintingType POSTER = createPainting("poster_image", 16, 32);

    public void registerPaintings(RegistryEvent.Register<PaintingType> event) {
        IForgeRegistry<PaintingType> registry = event.getRegistry();
        registry.register(POSTER);
    }

    private static PaintingType createPainting(String id, int width, int height) {
        PaintingType type = new PaintingType(width, height);
        type.setRegistryName(MODID, id);
        return type;
    }
}
