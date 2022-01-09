package me.afek.huggywuggy;

import me.afek.huggywuggy.entity.HuggyWuggyEntity;
import me.afek.huggywuggy.entity.HuggyWuggyRender;
import me.afek.huggywuggy.events.CommonEventHandler;
import me.afek.huggywuggy.events.ModidPacketHandler;
import me.afek.huggywuggy.item.ModItems;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.PaintingRenderer;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.item.PaintingType;
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
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod(HuggyWuggyMod.MODID)
public class HuggyWuggyMod {

    public static final String MODID = "huggywuggy";
    private static final Logger LOGGER = LogManager.getLogger();
    public static int POSTER_COUNT = 0, SCARED;
    public static boolean isHuggy = false;

    public HuggyWuggyMod() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::enqueueIMC);
        eventBus.addListener(this::processIMC);

        eventBus.addGenericListener(PaintingType.class, this::registerPaintings);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new CommonEventHandler());
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(ModItems.HUGGY_WUGGY_ENTITY.get(), HuggyWuggyEntity.createAttributes().build()));
    }

    private void clientSetup(FMLClientSetupEvent event) {
        ModidPacketHandler.init();
        RenderTypeLookup.setRenderLayer(ModItems.CHARGE_BLOCK.get(), RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(ModItems.CANON_BLOCK.get(), RenderType.cutoutMipped());
        RenderingRegistry.registerEntityRenderingHandler(ModItems.POSTER_ENTITY.get(), PaintingRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModItems.HUGGY_WUGGY_ENTITY.get(), HuggyWuggyRender::new);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
//        InterModComms.sendTo("examplemod", "helloworld", () -> {
//            LOGGER.info("Hello world from the MDK"), "test";
//            return "Hello world";
//        });
    }

    private void processIMC(final InterModProcessEvent event) {
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    //
//    @SubscribeEvent
//    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
//        event.registerEntityRenderer(EntityInit.EXAMPLE_ENTITY.get(), ExampleEntityRenderer::new);
//    }
//

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
