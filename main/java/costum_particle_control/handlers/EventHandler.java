package costum_particle_control.handlers;

import java.util.Random;

import costum_particle_control.capability.PlayerInfo.PlayerInfoProvider;
import costum_particle_control.capability.particleItem.ParticleItemProvider;
import costum_particle_control.interfaces.IParticleItem;
import costum_particle_control.interfaces.IPlayerInfo;
import costum_particle_control.objects.message.MessageButtom2;
import costum_particle_control.objects.message.MessageOpenGUI;
import costum_particle_control.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemPickupEvent;

public class EventHandler 
{
	Minecraft mc = Minecraft.getMinecraft();
	Random random = new Random();

	@SubscribeEvent
	public void onPlayerPressKey(InputEvent.KeyInputEvent event)
    {
	    KeyBinding[] keyBindings = ClientProxy.keyBindings;
	    if (keyBindings[0].isPressed()) 
	    {
	    	NetworkHandler.sendToServer(new MessageOpenGUI());
	    }

    }
	
	@SubscribeEvent
    public void onPlayerUsingItem(PlayerInteractEvent.RightClickItem event)
    {	
		EntityPlayer player = event.getEntityPlayer();
    	IParticleItem particle = event.getItemStack().getCapability(ParticleItemProvider.PARTICLE_CAP, null);
    	float pitch = player.rotationPitch;
		float yaw = player.rotationYawHead;
		float x_change = -(float) Math.sin(Math.toRadians(yaw));
		float y_change = -(float) Math.sin(Math.toRadians(pitch));
		float z_change = (float) Math.cos(Math.toRadians(yaw));
//		System.out.println(pitch);
    	if (particle!=null)// &&particle.getParticle()!=0
    	{
//    		for (int i = 0 ; i < 100; i++)
//    		{
    			EnumParticleTypes particle_type = EnumParticleTypes.getParticleFromId(particle.getParticleType());
    			int amount = particle.getParticleAmount();
    			float range = particle.getParticleRange();
    			float special_1 = particle.getParticleSpecial_1();
    			float special_2 = particle.getParticleSpecial_2();

    			for (int i = 0; i < amount; i++)
    			{
    				switch (particle.getParticleModel())
    				{
    				case 1:
    					double angle_1 = random.nextDouble()*360;
    					double angle_2 = random.nextDouble()*360;
    					double random_range = special_1+random.nextDouble()*range;
    					event.getWorld().spawnParticle(particle_type, 
            				player.posX + (random_range)*Math.cos(Math.toRadians(angle_2))*Math.cos(Math.toRadians(angle_1)), 
            				player.posY + (random_range)*Math.sin(Math.toRadians(angle_2)), 
            				player.posZ + (random_range)*Math.cos(Math.toRadians(angle_2))*Math.sin(Math.toRadians(angle_1)), 
            				special_2/2 - random.nextFloat()*special_2,
            				special_2/2 - random.nextFloat()*special_2, 
            				special_2/2 - random.nextFloat()*special_2,
            				1);
    					break;
    				case 2:
    					float ran = random.nextFloat()*special_1;
    					event.getWorld().spawnParticle(particle_type, 
    							player.posX + ran*x_change - range + random.nextFloat()*range*2, 
    							player.posY +1 + ran*y_change - special_2 + random.nextFloat()*special_2*2, 
    							player.posZ + ran*z_change  - range + random.nextFloat()*range*2, 
                    			0, 0, 0, 1);
    					break;
    				case 3:
    					
    					double x = player.posX - range + random.nextFloat()*range*2;
    					double y = player.posY + 1 - range + random.nextFloat()*range*2; 
    					double z = player.posZ - range + random.nextFloat()*range*2;
    					int dir = special_2 >=0 ? 1 : -1;				
    					event.getWorld().spawnParticle(particle_type, x,y,z,						
                				( (x-player.posX) /range)*dir*special_1, 
                				( (y- (player.posY + Math.abs(special_2)) ) /range)*dir*special_1,
                				( (z-player.posZ) /range)*dir*special_1,
                				1);
    					break;
    				case 4:
    					break;
    				case 5:
    					break;
    				default:
    					
    					
    				}
    				
    			}
    			
//    		}
    		
    	}
    }
	@SubscribeEvent
	public void onTooltip(ItemTooltipEvent event)
	{
    	IParticleItem particle = event.getItemStack().getCapability(ParticleItemProvider.PARTICLE_CAP, null);        		
    	if (particle!=null && particle.getParticleType()!=0) 
    	{    		
    		event.getToolTip().add("Particle Type: " + particle.getParticleType());
    		event.getToolTip().add("Particle Amount: " + particle.getParticleAmount());
    		event.getToolTip().add("Particle Range: " + particle.getParticleRange());

    		event.getToolTip().add("Particle Model: " + particle.getParticleModel() 
    								+ "  SPECIAL: "+ particle.getParticleSpecial_1() + " / "+particle.getParticleSpecial_2());


    	}
	}
	
	
	@SubscribeEvent
	public void onPlayerPickup(ItemPickupEvent event)
    {
    }
	
	@SubscribeEvent
    public void onPlayerClone(net.minecraftforge.event.entity.player.PlayerEvent.Clone event)
    {
        EntityPlayer player= event.getEntityPlayer();
        
        IPlayerInfo info = player.getCapability(PlayerInfoProvider.PARTICLEID_CAP, null);
        IPlayerInfo oldinfo = event.getOriginal().getCapability(PlayerInfoProvider.PARTICLEID_CAP, null);        
        info.setMap(oldinfo.getMap());

    }
}
