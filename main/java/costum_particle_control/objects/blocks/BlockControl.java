package costum_particle_control.objects.blocks;


import costum_particle_control.Main;
import costum_particle_control.init.BlockInit;
import costum_particle_control.init.ItemInit;
import costum_particle_control.interfaces.IHasModel;
import costum_particle_control.objects.creativetabs.CreativetabBlocks;
import costum_particle_control.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockControl extends Block implements IHasModel
{
	public BlockControl(String name, Material material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativetabBlocks.creativetab_blocks);
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
		setHardness(5);
		setHarvestLevel("pickaxe", 3);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		int id = Reference.GUI_COSTUMIZER;
		playerIn.openGui(Main.instance, id, worldIn, (int)pos.getX(),(int) pos.getY(),(int) pos.getZ());

        return true;
	}
//	@Override
//	public boolean hasTileEntity(IBlockState state) 
//	{
//		return true;
//	}
//	@Override
//	public TileEntity createTileEntity(World world, IBlockState state) 
//	{
//		return new TileEntityControl(world);
//	}	

}
