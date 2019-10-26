package costum_particle_control.handlers;

import costum_particle_control.Gui.container.ContainerBlockCostumizer;
import costum_particle_control.Gui.container.ContainerCostumizer;
import costum_particle_control.Gui.gui.GuiBlockCostumizer;
import costum_particle_control.Gui.gui.GuiCostumizer;
import costum_particle_control.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_COSTUMIZER) return new ContainerCostumizer(player.inventory,new BlockPos(x, y, z),world);
		if(ID == Reference.GUI_BLOCKCOSTUMIZER) return new ContainerBlockCostumizer(player.inventory,new BlockPos(x, y, z),world);
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_COSTUMIZER) return new GuiCostumizer(player.inventory,new BlockPos(x, y, z),world);
		if(ID == Reference.GUI_BLOCKCOSTUMIZER) return new GuiBlockCostumizer(player.inventory,new BlockPos(x, y, z),world);

		return null;
	}
}
