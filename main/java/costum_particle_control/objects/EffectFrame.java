package costum_particle_control.objects;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class EffectFrame 
{
	public BlockPos Pos;
	public int particleType;
	public int particleAmount;
	public float particleRange;
	public int particleModel;
	public float particleSpecial_1;
	public float particleSpecial_2;

	public EffectFrame(int Type,int Amount,float Range,int Model,float Special_1,float Special_2, EntityPlayer player)
	{
		this.particleType=Type;
		this.particleAmount=Amount;
		this.particleModel=Model;
		this.particleRange= Range;
		this.particleSpecial_1= Special_1;
		this.particleSpecial_2= Special_2;
		this.Pos = player.getPosition();
	}
	public EffectFrame(int Type,int Amount,float Range,int Model,float Special_1,float Special_2, BlockPos pos)
	{
		this.particleType=Type;
		this.particleAmount=Amount;
		this.particleModel=Model;
		this.particleRange= Range;
		this.particleSpecial_1= Special_1;
		this.particleSpecial_2= Special_2;
		this.Pos = pos;
	}

}
