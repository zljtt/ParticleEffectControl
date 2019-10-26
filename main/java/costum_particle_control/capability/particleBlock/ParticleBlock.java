package costum_particle_control.capability.particleBlock;

import costum_particle_control.interfaces.IParticleBlock;

public class ParticleBlock implements IParticleBlock
{
    private int particleType = 0;
    private int particleAmount = 0;
    private float particleRange = 0;
    private int particleModel = 0;
    private float particleSpecial_1 = 0;
    private float particleSpecial_2 = 0;

	@Override
	public void setParticleType(int points) 
	{
		this.particleType = points;
	}
	@Override
	public int getParticleType() 
	{		
		return particleType;
	}
	@Override
	public void setParticleAmount(int points) 
	{
		this.particleAmount = points;
	}
	@Override
	public int getParticleAmount() 
	{
		return particleAmount;
	}
	@Override
	public void setParticleModel(int points) 
	{
	this.particleModel = points;		
	}
	@Override
	public int getParticleModel() 
	{
		return particleModel;
	}
	@Override
	public void setParticleSpecial_1(float points) 
	{
		this.particleSpecial_1 = points;		
		
	}
	@Override
	public float getParticleSpecial_1() 
	{
		return particleSpecial_1;
	}
	@Override
	public void setParticleSpecial_2(float points) {
		this.particleSpecial_2 = points;		
		
	}
	@Override
	public float getParticleSpecial_2() {
		// TODO Auto-generated method stub
		return particleSpecial_2;
	}
	@Override
	public void setParticleRange(float points) {
		this.particleRange = points;		
	}
	@Override
	public float getParticleRange() {
		// TODO Auto-generated method stub
		return particleRange;
	}

}
