package costum_particle_control.objects.items;

import costum_particle_control.Main;
import costum_particle_control.init.ItemInit;
import costum_particle_control.interfaces.IHasModel;
import costum_particle_control.objects.creativetabs.CreativetabItems;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemOriginium extends ItemFood implements IHasModel
{
	public ItemOriginium(String name) 
	{
		super(10, false);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativetabItems.creativetab_items);
		ItemInit.ITEMS.add(this);
		
		setAlwaysEdible();
		this.setPotionEffect(new PotionEffect(Potion.getPotionById(6),20,10), 100);
		this.setMaxStackSize(16);	
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	
}
