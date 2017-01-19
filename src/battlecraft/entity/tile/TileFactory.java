package battlecraft.entity.tile;

import java.awt.Canvas;
import java.awt.Point;
import java.util.Arrays;

import battlecraft.entity.Tile;

public class TileFactory implements ITileFactory {
	
	private String path;
	private String prefix = "Tile/";
	private String suffix = ".png";
	private int[] solid = {44,48,49,47};

	public TileFactory(String path) {
		this.path = path+"";
	}

	@Override 
	public Tile createTile(Canvas defaultCanvas, Point position, int number) {
		boolean isSolid = Arrays.stream(solid).anyMatch(i -> i == number);
		String sprite = path + prefix + number + suffix;
		return new Tile(defaultCanvas, position, sprite, isSolid);
	}
}
