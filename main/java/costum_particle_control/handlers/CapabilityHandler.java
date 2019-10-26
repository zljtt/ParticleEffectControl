 package costum_particle_control.handlers;

import costum_particle_control.capability.PlayerInfo.PlayerInfoProvider;
import costum_particle_control.capability.particleItem.ParticleItemProvider;
import costum_particle_control.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler 
{
	public static final ResourceLocation PARTICLEITEM = new ResourceLocation(Reference.MODID, "particle_item");
	public static final ResourceLocation PLAYERINFO = new ResourceLocation(Reference.MODID, "player_info");
	public static final ResourceLocation PARTICLEBLOCK = new ResourceLocation(Reference.MODID, "particle_block");


    @SubscribeEvent
    public void attachCapabilityItem(AttachCapabilitiesEvent<ItemStack> event)
    {
        if (!(event.getObject() instanceof ItemStack)) return;

        event.addCapability(PARTICLEITEM, new ParticleItemProvider());

    }
//    @SubscribeEvent
//    public void attachCapabilityBlock(AttachCapabilitiesEvent<TileEntity> event)
//    {
//        if (!(event.getObject() instanceof TileEntity)) return;
//
//        event.addCapability(PARTICLEBLOCK, new ParticleBlockProvider());
//
//    }
    @SubscribeEvent
    public void attachCapabilityPlayer(AttachCapabilitiesEvent<EntityPlayer> event)
    {
        if (!(event.getObject() instanceof EntityPlayer)) return;

        event.addCapability(PLAYERINFO, new PlayerInfoProvider());

    }
}
