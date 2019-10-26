package costum_particle_control.capability.PlayerInfo;

import java.util.HashMap;
import java.util.Map;

import costum_particle_control.interfaces.IPlayerInfo;
import costum_particle_control.objects.EffectFrame;

public class PlayerInfo implements IPlayerInfo
{
	  private Map<Integer,EffectFrame> listFrames = new HashMap<Integer,EffectFrame>();

	@Override
	public void addFrame(int time, EffectFrame frame) {
		listFrames.put(time, frame);
	}
	
	@Override
	public void replaceFrame(int time, EffectFrame frame) 
	{
		listFrames.put(time, frame);
	}
	@Override
	public void clearFrameByKey(int time) 
	{
		listFrames.remove(time);
	}

	@Override
	public void clearAll() 
	{
		listFrames.clear();
	}

	@Override
	public void setMap(Map<Integer, EffectFrame> map) 
	{
		listFrames.clear();
		listFrames = map;
	}

	@Override
	public Map<Integer, EffectFrame> getMap() 
	{
		return listFrames;
	}

	@Override
	public EffectFrame getFrame(int time) 
	{
		return listFrames.get(time);
		
	}




}
