package battlecraft.entity.tile;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.core.GameEntity;

public class TileFactory implements ITileFactory {

	public TileFactory() {
	}

	@Override
	public GameEntity createForestTile(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(0,0,100,100);
		String imagePath = "images/Medieval/Tile/49.png";
		return new MoveBlockerTile(defaultCanvas, position, imagePath, boundingBox);
	}

	@Override
	public GameEntity createLandTile(Canvas defaultCanvas, Point position) {
		String imagePath = "images/Medieval/Tile/59.png";
		return new Tile(defaultCanvas, position, imagePath);
	}
}
