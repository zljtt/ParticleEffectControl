package costum_particle_control.handlers;

import costum_particle_control.objects.message.MessageButtom;
import costum_particle_control.objects.message.MessageButtom2;
import costum_particle_control.objects.message.MessageOpenGUI;
import costum_particle_control.util.Reference;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler 
{
	private static SimpleNetworkWrapper INSTANCE;
	public static void init()
	{
		INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);
		
		INSTANCE.registerMessage(MessageOpenGUI.class, MessageOpenGUI.class, 0, Side.SERVER);
		INSTANCE.registerMessage(MessageButtom2.class, MessageButtom2.class, 0, Side.SERVER);	
		INSTANCE.registerMessage(MessageButtom.class, MessageButtom.class, 0, Side.SERVER);
	}
	
	public static void sendToServer(IMessage message)
	{
		INSTANCE.sendToServer(message);
	}

}
