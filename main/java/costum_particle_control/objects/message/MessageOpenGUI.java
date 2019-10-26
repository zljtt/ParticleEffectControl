package costum_particle_control.objects.message;

import costum_particle_control.Main;
import costum_particle_control.Gui.container.ContainerCostumizer;
import costum_particle_control.Gui.gui.GuiCostumizer;
import costum_particle_control.capability.particleItem.ParticleItemProvider;
import costum_particle_control.interfaces.IParticleItem;
import costum_particle_control.util.Reference;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;

public class MessageOpenGUI extends MessageBase<MessageOpenGUI>
{
//	int particleType;
//	public MessageButtom(int particletype)
//	{
//		particleType = particletype;
//	}
	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void handleServerSide(MessageOpenGUI message, EntityPlayer player) 
	{
    	if (player!=null)
    	{
    		int id = Reference.GUI_BLOCKCOSTUMIZER;
    		player.openGui(Main.instance, id, player.world, (int)player.posX,(int) player.posY,(int) player.posZ);
    	}
	}

	@Override
	protected void handleClientSide(MessageOpenGUI message, EntityPlayer player) 
	{
	}

}
