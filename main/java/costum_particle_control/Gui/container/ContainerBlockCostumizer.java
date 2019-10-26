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

public class ContainerBlockCostumizer extends Container
{
	protected static Slot slot1,slot2,slot3,slot4,slot5,slot6,slot7,slot8,slot9,slot_get;
	protected static Slot[] slots = new Slot[] {slot1,slot2,slot3,slot4,slot5,slot6,slot7,slot8,slot9};

    private ItemStackHandler items = new ItemStackHandler(10);

    private final World world;
    /** Position of the workbench */
    private final BlockPos pos;
    private final EntityPlayer player;
    
    public ContainerBlockCostumizer(InventoryPlayer inventory,BlockPos pos , World world)
    {
        super();
        this.world = world;
        this.pos = pos;
        this.player = inventory.player;
        
        this.addSlotToContainer(slot_get = new SlotItemHandler(items, 36+10, 225, 106 )
        {
            @Override
            public int getItemStackLimit(ItemStack stack)
            {
                return 1;
            }
        });
        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(slots[i] = new SlotItemHandler(items, 36+i, 8 + i * 18, 21 )
            {
                @Override
                public int getItemStackLimit(ItemStack stack)
                {
                    return 1;
                }
            }); 
        }
        
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

            if (index >= 0 && index < 8)
            {
                isMerged = mergeItemStack(newStack, 36, 45, false)
                		|| mergeItemStack(newStack, 8, 36, false);
            }
            else if (index >= 8 && index < 36)
            {
            	isMerged = mergeItemStack(newStack, 36, 45, false)
                        || mergeItemStack(newStack, 0, 8, false);
                
            }
            else if (index >= 36 && index < 45)
            {
                isMerged = mergeItemStack(newStack, 8, 36, false)
                        || mergeItemStack(newStack, 0, 8, false);
            }
            else if (index == 45)
            {
                isMerged = mergeItemStack(newStack, 8, 36, false)
                        || mergeItemStack(newStack, 0, 8, false);
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
        }    }

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return true;
	}
    

}
