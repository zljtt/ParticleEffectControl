package costum_particle_control.Gui.container;

import costum_particle_control.Gui.gui.GuiCostumizer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerCostumizer extends Container
{
	protected static Slot stack;
	protected static Slot SlotGet;
	protected static Slot SlotPut;

    private ItemStackHandler items = new ItemStackHandler(2);
    private final World world;
    /** Position of the workbench */
    private final BlockPos pos;
    private final EntityPlayer player;
    public static ItemStack stackToEnchant = null;
    
    public ContainerCostumizer(InventoryPlayer inventory,BlockPos pos , World world)
    {
        super();
        this.world = world;
        this.pos = pos;
        this.player = inventory.player;
        this.addSlotToContainer(this.SlotPut = new SlotItemHandler(items, 0, 12+1, 16+1)
        {
        	
//        	@Override
//            public boolean isItemValid(ItemStack stack)
//            {
//                return stack != null && stack.getItem() == ItemInit.ORIGINIUM && super.isItemValid(stack);
//            }

            @Override
            public int getItemStackLimit(ItemStack stack)
            {
                return 64;
            }
            
            @Override
            public void onSlotChanged()
            {
            	ItemStack stack_put = SlotPut.getStack();
            	stackToEnchant = stack_put;
            	GuiCostumizer.open = true;
//            	if (stack_put!=null && stack_put!=ItemStack.EMPTY 
//            			&& SlotGet.getStack() != ItemStack.EMPTY && SlotGet.getStack() != null)
//            	{
//            		SlotGet.putStack(stack_put);
//            		
//            		ItemStack stack_get = SlotGet.getStack();     	
//                	IParticle particle = stack_get.getCapability(ParticleProvider.PARTICLE_CAP, null);        		
//            		if (particle!=null)
//            		{
//            			particle.setParticleType(3);
//            		}
//            		
//            	}     
            	
            	
                super.onSlotChanged();

            }
        });
//        this.addSlotToContainer(this.SlotGet = new SlotItemHandler(items, 1, 146+1, 16+1)
//        {
//        	
//            @Override
//            public int getItemStackLimit(ItemStack stack)
//            {
//                return 64;
//            }
//            @Override
//            public void onSlotChanged()
//            {
//            	
//            }
//            @Override
//            public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) 
//            {
//            	return super.onTake(thePlayer, stack);
//            }
//        }); 
        
        
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 101 + i * 18));//51
            }
        }

        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 159));//109
        }
    }
    
    
    @Override
    public void onContainerClosed(EntityPlayer playerIn) 
    {
    	if (playerIn.world.isRemote)return;
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
    	{
            Slot slot = inventorySlots.get(index);

            if (!slot.getHasStack())
            {
                return ItemStack.EMPTY;
            }

            ItemStack newStack = slot.getStack(), oldStack = newStack.copy();

            boolean isMerged = false;

            if (index >= 0 && index < 2)
            {
                isMerged = mergeItemStack(newStack, 1, 37, false);
            }
            else if (index >= 2 && index < 30)
            {
            	isMerged = mergeItemStack(newStack, 0, 0, false)
                        || mergeItemStack(newStack, 29, 37, false);
                
            }
            else if (index >= 30 && index < 39)
            {
                isMerged = mergeItemStack(newStack, 0, 0, false)
                        || mergeItemStack(newStack, 1, 29, false);
            }

            if (!isMerged)
            {
                return ItemStack.EMPTY;
            }

            if (newStack.getCount() == 0)
            {
                //slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }

            slot.onTake(playerIn, newStack);

            return oldStack;
        }
    }

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return true;
	}
    

}
