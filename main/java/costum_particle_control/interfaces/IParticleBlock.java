package costum_particle_control.interfaces;

public interface IParticleBlock
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
}
