package costum_particle_control.objects.tileentity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import costum_particle_control.Main;
import costum_particle_control.capability.particleBlock.ParticleBlockProvider;
import costum_particle_control.capability.particleItem.ParticleItemProvider;
import costum_particle_control.handlers.EventHandler;
import costum_particle_control.interfaces.IParticleBlock;
import costum_particle_control.interfaces.IParticleItem;
import costum_particle_control.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.tileentity.TileEntityNote;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

public class TileEntityParticleTable extends TileEntity implements ITickable
{
	private Random ran = new Random();
	private World world;
	
	public TileEntityParticleTable(World worldIn)
	{		
		world = worldIn;
	}
	

	@Override
	public void update() 
	{
		IParticleBlock particle = this.getCapability(ParticleBlockProvider.PARTICLE_CAP, null);
		if(particle!=null)
		{
			
		}
		
	}

	@Override
	@Nullable
    public SPacketUpdateTileEntity getUpdatePacket()
    {
        return new SPacketUpdateTileEntity(this.pos, 3, this.getUpdateTag());
    }
	@Override
	public NBTTagCompound getUpdateTag()
    {
        return this.writeToNBT(new NBTTagCompound());
    }

	
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		super.writeToNBT(compound);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		super.readFromNBT(compound);

	}




}
