package costum_particle_control.objects.message;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public abstract class MessageBase<REQ extends IMessage> implements IMessage, IMessageHandler<REQ,REQ>
{
	

	@Override
	public REQ onMessage(REQ message, MessageContext ctx) 
	{
		if (ctx.side==Side.SERVER)
		{
			handleServerSide(message, ctx.getServerHandler().player);
		}
		else
			handleClientSide(message, null);
		return null;
	}

	protected abstract void handleServerSide(REQ message, EntityPlayer player);

	protected abstract void handleClientSide(REQ message, EntityPlayer player);
}
