package costum_particle_control.capability.particleBlock;
import costum_particle_control.interfaces.IParticleBlock;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class ParticleBlockProvider implements ICapabilitySerializable<NBTBase>
{
	@CapabilityInject(IParticleBlock.class)
    public static final Capability<IParticleBlock> PARTICLE_CAP = null;

    private IParticleBlock instance = PARTICLE_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        return capability == PARTICLE_CAP;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        return capability == PARTICLE_CAP ? PARTICLE_CAP.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT()
    {
        return PARTICLE_CAP.getStorage().writeNBT(PARTICLE_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt)
    {
    	PARTICLE_CAP.getStorage().readNBT(PARTICLE_CAP, this.instance, null, nbt);
    }

}
