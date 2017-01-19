package battlecraft.entity.tile;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Arrays;

import gameframework.core.GameEntity;

public class TileFactory implements ITileFactory {
	
	private int[] solid = {44,48,49,47};

	public TileFactory() {
	}

	@Override
	public GameEntity createForestTile(Canvas defaultCanvas, Point position, int number) {
		Rectangle bb = new Rectangle(1,0,1,1);
		String imagePath = "images/Medieval/Tile/49.png";
		return new MoveBlockerTile(defaultCanvas, position, imagePath, bb);
	}

	@Override
	public GameEntity createLandTile(Canvas defaultCanvas, Point position, int number) {
		String imagePath = "images/Medieval/Tile/59.png";
		return new Tile(defaultCanvas, position, imagePath);
	}
}
