package costum_particle_control;


import costum_particle_control.handlers.RegistryHandler;
import costum_particle_control.proxy.ClientProxy;
import costum_particle_control.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid=Reference.MODID, name=Reference.NAME, version=Reference.VERSION)
public class Main
{

	@Instance
	public static Main instance;

	@SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
	public static ClientProxy proxy;
	
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		RegistryHandler.preInitRegistries();
	}
	@EventHandler
	public static void init(FMLInitializationEvent event)
    {
		RegistryHandler.initRegistries();
    }
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
    {
		RegistryHandler.postInitRegistries();
    }
	@EventHandler
	public static void serverInit(FMLServerStartingEvent event)
    {
		RegistryHandler.serverInitRegistries(event);
    }
}
