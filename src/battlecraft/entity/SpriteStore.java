package battlecraft.entity;

import java.awt.Canvas;
import java.util.HashMap;

import gameframework.core.DrawableImage;

public class SpriteStore {
	
	private SpriteStore()
	{}
 
	private static class SpriteStoreHolder
	{		
		private final static SpriteStore instance = new SpriteStore();
	}
 
	public static SpriteStore getInstance()
	{
		return SpriteStoreHolder.instance;
	}

	private HashMap<String, DrawableImage> sprites = new HashMap<String, DrawableImage>();
	

	public DrawableImage getSprite(String path, Canvas defaultCanvas) {

		if (sprites.get(path) != null) {
			return (DrawableImage) sprites.get(path);
		}
		
		DrawableImage sprite = new DrawableImage(path, defaultCanvas);
		sprites.put(path,sprite);
		
		return sprite;
	}
}
