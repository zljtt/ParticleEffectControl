package costum_particle_control.objects.message;

import costum_particle_control.Gui.container.ContainerCostumizer;
import costum_particle_control.Gui.gui.GuiBlockCostumizer;
import costum_particle_control.Gui.gui.GuiCostumizer;
import costum_particle_control.capability.particleItem.ParticleItemProvider;
import costum_particle_control.interfaces.IParticleItem;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

public class MessageButtom2 extends MessageBase<MessageButtom2>
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
	protected void handleServerSide(MessageButtom2 message, EntityPlayer player) 
	{
    	if (player!=null)
    	{
    		ItemStack item = new ItemStack(Items.APPLE);
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
                	
                	int text_x= particle.getBlockPos().getX();
                	int text_y= particle.getBlockPos().getY();
                	int text_z= particle.getBlockPos().getZ();
                	
                	int text_time= particle.getTime();

        			//type                	
                	try
            		{
            			text_type = Integer.parseInt(GuiBlockCostumizer.particleType);
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
                    	text_amount = Integer.parseInt(GuiBlockCostumizer.particleAmount);
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
                    	text_range = Float.parseFloat(GuiBlockCostumizer.particleRange);
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
                    	text_model = Integer.parseInt(GuiBlockCostumizer.particleModel);
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
            			text_special_1 = Float.parseFloat(GuiBlockCostumizer.particleSpecial_1);
                    	particle.setParticleSpecial_1(text_special_1);        			

                	}
            		catch(NumberFormatException ex)
            		{
            		}
        			
        			//special 2
            		try
                	{
            			text_special_2 = Float.parseFloat(GuiBlockCostumizer.particleSpecial_2);
                    	particle.setParticleSpecial_2(text_special_2);        			

                	}
            		catch(NumberFormatException ex)
            		{
            		}
        			
            		//x                	
                	try
            		{
            			text_x = Integer.parseInt(GuiBlockCostumizer.particleX);
            			text_y = Integer.parseInt(GuiBlockCostumizer.particleY);
            			text_z = Integer.parseInt(GuiBlockCostumizer.particleZ);

                    	particle.setBlockPos(new BlockPos(text_x,text_y,text_z));                	             		
            		}
                	catch(NumberFormatException ex)
                	{
                		if (text_x==0||text_y==0||text_z==0)
                		{
                	        player.sendMessage(new TextComponentString(String.format("Insert Interger for Block Position")));
                		}
                	}
                	
                	//time                	
                	try
            		{
                		text_time = Integer.parseInt(GuiBlockCostumizer.particleTime);
                    	particle.setTime(text_time);                	             		
            		}
                	catch(NumberFormatException ex)
                	{
                		if (text_time==0)
                		{
                	        player.sendMessage(new TextComponentString(String.format("Insert Interger for TIME")));
                		}
                	}
                	
            		player.addItemStackToInventory(item);
            	}
    			
    		}    		  		
    	}
	}

	@Override
	protected void handleClientSide(MessageButtom2 message, EntityPlayer player) 
	{
	}

}
