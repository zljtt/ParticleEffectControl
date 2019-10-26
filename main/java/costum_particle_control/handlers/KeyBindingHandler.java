package costum_particle_control.handlers;

import org.lwjgl.input.Keyboard;

import costum_particle_control.proxy.ClientProxy;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyBindingHandler 
{

	public static void init()
	{
//		KeyBinding[] keyBindings﻿ = ClientProxy.keyBindings;	
		KeyBinding[] keyBindings = new KeyBinding[1]; 
		keyBindings[0] = new KeyBinding("key.structure.desc", Keyboard.KEY_J, "key.magicbeans.category");
		for (int i = 0; i < keyBindings.length; ++i) 
		{
		    ClientRegistry.registerKeyBinding(keyBindings[i]);
		}
	}
}
