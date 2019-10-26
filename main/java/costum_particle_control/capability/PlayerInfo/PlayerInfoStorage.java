package costum_particle_control.capability.PlayerInfo;

import java.util.HashMap;
import java.util.Map;

import costum_particle_control.interfaces.IPlayerInfo;
import costum_particle_control.objects.EffectFrame;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class PlayerInfoStorage implements IStorage<IPlayerInfo>
{
	@Override
    public NBTBase writeNBT(Capability<IPlayerInfo> capability, IPlayerInfo instance, EnumFacing side)
    {
		Map<Integer,EffectFrame> list = instance.getMap();
		String nbt = "";
		for (int time:list.keySet())
		{
			double x = list.get(time).Pos.getX();
			double y = list.get(time).Pos.getY();
			double z = list.get(time).Pos.getZ();

			int type = list.get(time).particleType;
			int amount = list.get(time).particleAmount;
			float range = list.get(time).particleRange;
			int model = list.get(time).particleModel;
			float special_1 = list.get(time).particleSpecial_1;
			float special_2 = list.get(time).particleSpecial_2;
			nbt = nbt+time+" "+type+" "+amount+" "+range+" "+model+" "+special_1+" "+special_2
					+" "+x+" "+y+" "+z+"split";
			
		}
		
		NBTTagString tag = new NBTTagString(nbt);
        return tag;
    }

    @Override
    public void readNBT(Capability<IPlayerInfo> capability, IPlayerInfo instance, EnumFacing side, NBTBase nbt)
    {
    	Map<Integer,EffectFrame> list  = new HashMap<Integer,EffectFrame>();
    	String[] nbt1 = ((NBTTagString) nbt).getString().split("split");
    	
		for (String string: nbt1)
		{
	    	String[] nbt2 = string.split(" ");
	    	int time = Integer.parseInt(nbt2[0]);
	    	int type = Integer.parseInt(nbt2[1]);
			int amount = Integer.parseInt(nbt2[2]);
			float range =  Float.parseFloat(nbt2[3]);
			int model = Integer.parseInt(nbt2[4]);
			float special_1 = Float.parseFloat(nbt2[5]);
			float special_2 =  Float.parseFloat(nbt2[6]);
			BlockPos pos = new BlockPos(Double.parseDouble(nbt2[7]),Double.parseDouble(nbt2[8]),Double.parseDouble(nbt2[9]));
			EffectFrame frame = new EffectFrame(type, amount, range, model, special_1, special_2, pos);
	    	
			list.put(time, frame);
			
			
		}    
		instance.setMap(list);
	}
}
