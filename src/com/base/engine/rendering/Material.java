package com.base.engine.rendering;

import com.base.engine.rendering.resourceManagement.MappedValues;

import java.util.HashMap;

public class Material extends MappedValues
{
	private HashMap<String, Texture> textureHashMap;

	public Material()
	{
		super();
		textureHashMap = new HashMap<String, Texture>();
		textureHashMap.put("normalMap", new Texture("default_normal.jpg"));
		textureHashMap.put("dispMap", new Texture("default_disp.png"));
		
		float baseBias = 1.0f/2.0f;
		addFloat("dispMapScale", 1.0f);
		addFloat("dispMapBias", -baseBias + baseBias * 0.0f);

	}

	public void addTexture(String name, Texture texture) { textureHashMap.put(name, texture); }

	public Texture getTexture(String name)
	{
		Texture result = textureHashMap.get(name);
		if(result != null)
			return result;

		return new Texture("test.png");
	}
}
