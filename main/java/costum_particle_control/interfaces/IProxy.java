package costum_particle_control.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public interface IProxy 
{
    EntityPlayer getPlayerEntityFromContext(MessageContext parContext);
}
