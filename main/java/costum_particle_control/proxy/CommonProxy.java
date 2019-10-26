package costum_particle_control.proxy;

import costum_particle_control.interfaces.IProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CommonProxy implements IProxy
{
	
	public void registerItemRenderer(Item item, int meta, String id ) 
	{
			
	}
		
	public void registerVariantRenderer(Item item, int meta, String filename, String id) 
	{
			
	}

	@Override
	public EntityPlayer getPlayerEntityFromContext(MessageContext ctx) 
	{
        return ctx.getServerHandler().player;
	}



}
