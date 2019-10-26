package costum_particle_control.objects.blocks;


import costum_particle_control.Main;
import costum_particle_control.init.BlockInit;
import costum_particle_control.init.ItemInit;
import costum_particle_control.interfaces.IHasModel;
import costum_particle_control.objects.creativetabs.CreativetabBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel
{
	public BlockBase(String name, Material material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativetabBlocks.creativetab_blocks);
		
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
