package costum_particle_control.objects.items;

import costum_particle_control.Main;
import costum_particle_control.init.ItemInit;
import costum_particle_control.interfaces.IHasModel;
import costum_particle_control.objects.creativetabs.CreativetabItems;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{
	public ItemBase(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativetabItems.creativetab_items);
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
