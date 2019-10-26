package costum_particle_control.objects.message;

import costum_particle_control.Gui.container.ContainerCostumizer;
import costum_particle_control.Gui.gui.GuiCostumizer;
import costum_particle_control.capability.particleItem.ParticleItemProvider;
import costum_particle_control.interfaces.IParticleItem;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;

public class MessageButtom extends MessageBase<MessageButtom>
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
	protected void handleServerSide(MessageButtom message, EntityPlayer player) 
	{
    	if (player!=null)
    	{
    		ItemStack item = ContainerCostumizer.stackToEnchant;
    		if (item!=null && item!=ItemStack.EMPTY)
    		{
    			IParticleItem particle = item.getCapability(ParticleItemProvider.PARTICLE_CAP, null);
            	if (particle!=null)
            	{
            		int text_type = particle.getParticleType();
        			int text_amount = particle.getParticleAmount();
        			float text_range = particle.getParticleRange();
        			int text_model = particle.getParticleModel();
        			float text_special_1= particle.getParticleSpecial_1();
                	float text_special_2= particle.getParticleSpecial_2();
                	
        			//type                	
                	try
            		{
            			text_type = Integer.parseInt(GuiCostumizer.particleType);
                    	particle.setParticleType(text_type);                	             		
            		}
                	catch(NumberFormatException ex)
                	{
                		if (text_type==0)
                		{
                	        player.sendMessage(new TextComponentString(String.format("Insert Interger for TYPE")));
                		}
                	}                	      			
        			
        			//amount
        			try
        			{
                    	text_amount = Integer.parseInt(GuiCostumizer.particleAmount);
                		particle.setParticleAmount(text_amount);

        			}catch(NumberFormatException ex)
        			{
        				if (text_amount==0)
                		{
                	        player.sendMessage(new TextComponentString(String.format("Insert Interger for TYPE")));
                		}
        			}

        			//range
        			try
        			{
                    	text_range = Float.parseFloat(GuiCostumizer.particleRange);
                		particle.setParticleRange(text_range);
        			}catch(NumberFormatException ex) 
        			{
        				if (text_range==0)
                		{
                	        player.sendMessage(new TextComponentString(String.format("Insert Float for RANGE")));
                		}
        			}
        			
        			//model
        			try
        			{
                    	text_model = Integer.parseInt(GuiCostumizer.particleModel);
                		particle.setParticleModel(text_model);
                		
        			}catch(NumberFormatException ex)
        			{
        				if (text_model==0)
                		{
                	        player.sendMessage(new TextComponentString(String.format("Insert Interger for MODEL")));
                		}
        			}
        			
        			//special 1
            		try
                	{
            			text_special_1 = Float.parseFloat(GuiCostumizer.particleSpecial_1);
                    	particle.setParticleSpecial_1(text_special_1);        			

                	}
            		catch(NumberFormatException ex)
            		{
            		}
        			
        			//special 2
            		try
                	{
            			text_special_2 = Float.parseFloat(GuiCostumizer.particleSpecial_2);
                    	particle.setParticleSpecial_2(text_special_2);        			

                	}
            		catch(NumberFormatException ex)
            		{
            		}
        			
            		player.addItemStackToInventory(item);
            	}
    			
    		}    		  		
    	}
	}

	@Override
	protected void handleClientSide(MessageButtom message, EntityPlayer player) 
	{
	}

}
