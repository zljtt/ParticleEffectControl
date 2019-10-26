package costum_particle_control.interfaces;

import java.util.Map;

import costum_particle_control.objects.EffectFrame;

public interface IPlayerInfo
{
	public void addFrame(int time , EffectFrame frame);
		
	public void replaceFrame(int time , EffectFrame frame);
	
	public void clearFrameByKey(int time);

	public void clearAll();
		
	public void setMap(Map<Integer,EffectFrame> map);
	
	public Map<Integer,EffectFrame> getMap();
	
	public EffectFrame getFrame(int time);


}
