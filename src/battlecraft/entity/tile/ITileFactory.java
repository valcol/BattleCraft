package battlecraft.entity.tile;

import java.awt.Canvas;
import java.awt.Point;

import gameframework.core.GameEntity;

public interface ITileFactory {

	GameEntity createForestTile(Canvas defaultCanvas, Point position, int number);
	GameEntity createLandTile(Canvas defaultCanvas, Point position, int number);
	
}
