package costum_particle_control.objects.creativetabs;

import costum_particle_control.init.BlockInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CreativetabBlocks extends CreativeTabs
{
	public static CreativetabBlocks creativetab_blocks = new CreativetabBlocks();
    
    public CreativetabBlocks()
    {
        super("creativetab_blocks");
    }

    public ItemStack getTabIconItem()
    {
        return new ItemStack(BlockInit.CONTROL);
    }

}
