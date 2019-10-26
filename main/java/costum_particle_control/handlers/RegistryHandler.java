 package costum_particle_control.handlers;


import costum_particle_control.Main;
import costum_particle_control.capability.PlayerInfo.PlayerInfo;
import costum_particle_control.capability.PlayerInfo.PlayerInfoStorage;
import costum_particle_control.capability.particleItem.ParticleItem;
import costum_particle_control.capability.particleItem.ParticleItemStorage;
import costum_particle_control.init.BlockInit;
import costum_particle_control.init.ItemInit;
import costum_particle_control.interfaces.IHasModel;
import costum_particle_control.interfaces.IParticleItem;
import costum_particle_control.interfaces.IPlayerInfo;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@EventBusSubscriber
public class RegistryHandler 
{
	static Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void registerBlock(RegistryEvent.Register<Block> event)
	{ 
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
//		TileEntityHandler.registerTileEntities();
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{		
//		Main.proxy.registerModel(Item.getItemFromBlock(BlockInit.COPPER_CHEST), 0);
		
		for(Item item : ItemInit.ITEMS)
		{			
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : BlockInit.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
	}

	
	public static void preInitRegistries()
	{        
        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        NetworkHandler.init();
		CapabilityManager.INSTANCE.register(IParticleItem.class, new ParticleItemStorage(), ParticleItem.class);
//		CapabilityManager.INSTANCE.register(IParticleBlock.class, new ParticleBlockStorage(), ParticleBlock.class);
		CapabilityManager.INSTANCE.register(IPlayerInfo.class, new PlayerInfoStorage(), PlayerInfo.class);
		KeyBindingHandler.init();

       
	}
	
	public static void initRegistries()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}

	public static void postInitRegistries() 
	{
	}
	
	public static void serverInitRegistries(FMLServerStartingEvent event)
	{
	}
}
