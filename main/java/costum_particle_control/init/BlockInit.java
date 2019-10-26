package costum_particle_control.init;

import java.util.ArrayList;
import java.util.List;

import costum_particle_control.objects.blocks.BlockControl;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Blocks
	public static final Block CONTROL = new BlockControl("control", Material.IRON);
}
