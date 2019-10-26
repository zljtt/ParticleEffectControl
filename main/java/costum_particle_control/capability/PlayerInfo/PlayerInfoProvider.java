package costum_particle_control.capability.PlayerInfo;
import costum_particle_control.interfaces.IPlayerInfo;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class PlayerInfoProvider implements ICapabilitySerializable<NBTBase>
{
	@CapabilityInject(IPlayerInfo.class)
    public static final Capability<IPlayerInfo> PARTICLEID_CAP = null;

    private IPlayerInfo instance = PARTICLEID_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        return capability == PARTICLEID_CAP;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        return capability == PARTICLEID_CAP ? PARTICLEID_CAP.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT()
    {
        return PARTICLEID_CAP.getStorage().writeNBT(PARTICLEID_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt)
    {
    	PARTICLEID_CAP.getStorage().readNBT(PARTICLEID_CAP, this.instance, null, nbt);
    }

}
