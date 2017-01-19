package battlecraft.entity.environment;

import java.awt.Canvas;
import java.awt.Point;

import battlecraft.entity.Tile;

public interface IEnvironmentFactory {

	Tile createNormalPineTree(Canvas defaultCanvas, Point position);
	Tile createNormalTree(Canvas defaultCanvas, Point position);
	Tile createSmallTree(Canvas defaultCanvas, Point position);
	Tile createSmallPineTree(Canvas defaultCanvas, Point position);
}
