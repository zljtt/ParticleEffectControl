package costum_particle_control.objects.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CreativetabItems extends CreativeTabs
{
	public static CreativetabItems creativetab_items = new CreativetabItems();
    
    public CreativetabItems()
    {
        super("creativetab_items");
    }

    public ItemStack getTabIconItem()
    {
        return new ItemStack(Items.ARROW);
    }

}
