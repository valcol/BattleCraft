package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;

import battlecraft.entity.Tile;

public interface IStructureFactory {
	
	Tile createHouse(Canvas defaultCanvas, Point position, int number);

}
