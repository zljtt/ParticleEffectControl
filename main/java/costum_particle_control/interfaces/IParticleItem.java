package costum_particle_control.interfaces;

import net.minecraft.util.math.BlockPos;

public interface IParticleItem
{
	public void setParticleType(int points);
		
	public int getParticleType();

	//
	public void setParticleAmount(int points);

	public int getParticleAmount();
	//
	public void setParticleRange(float points);

	public float getParticleRange();
	
	//
	public void setParticleModel(int points);

	public int getParticleModel();
	
	//
	public void setParticleSpecial_1(float points);

	public float getParticleSpecial_1();
	//
	public void setParticleSpecial_2(float points);

	public float getParticleSpecial_2();
	//
	public void setBlockPos(BlockPos pos);

	public BlockPos getBlockPos();
	//
	public void setTime(int time);

	public int getTime();
}
