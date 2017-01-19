package battlecraft.entity.tile;

import java.awt.Canvas;
import java.awt.Point;

import battlecraft.entity.Tile;

public interface ITileFactory {

	Tile createTile(Canvas defaultCanvas, Point position, int number);

}
