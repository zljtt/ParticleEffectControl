package costum_particle_control.capability.particleItem;

import costum_particle_control.interfaces.IParticleItem;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class ParticleItemStorage implements IStorage<IParticleItem>
{
	@Override
    public NBTBase writeNBT(Capability<IParticleItem> capability, IParticleItem instance, EnumFacing side)
    {
		int type = instance.getParticleType();
		int amount = instance.getParticleAmount();
		float range = instance.getParticleRange();
		int model = instance.getParticleModel();
		float special_1 = instance.getParticleSpecial_1();
		float special_2 = instance.getParticleSpecial_2();
		int x = instance.getBlockPos().getX();
		int y = instance.getBlockPos().getY();
		int z = instance.getBlockPos().getZ();
		int time = instance.getTime();

		String nbt = type+" "+amount+" "+range+" "+model+" "+special_1+" "+special_2+" "+x+" "+y+" "+z+" "+time;
        return new NBTTagString(nbt);
    }

    @Override
    public void readNBT(Capability<IParticleItem> capability, IParticleItem instance, EnumFacing side, NBTBase nbt)
    {
    	String[] nbt2 = ((NBTTagString) nbt).getString().split(" ");
        instance.setParticleType(Integer.parseInt(nbt2[0]));
        instance.setParticleAmount(Integer.parseInt(nbt2[1]));
        instance.setParticleRange(Float.parseFloat(nbt2[2]));
        
        instance.setParticleModel(Integer.parseInt(nbt2[3]));
        instance.setParticleSpecial_1(Float.parseFloat(nbt2[4]));
        instance.setParticleSpecial_2(Float.parseFloat(nbt2[5]));
        
        instance.setBlockPos(new BlockPos(Integer.parseInt(nbt2[6]),Integer.parseInt(nbt2[7]),Integer.parseInt(nbt2[8])));
        instance.setTime(Integer.parseInt(nbt2[9]));

    }
}
