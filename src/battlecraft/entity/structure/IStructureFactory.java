package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;

import gameframework.core.GameEntity;

public interface IStructureFactory {
	
	GameEntity createHouse(Canvas defaultCanvas, Point position, int number);

}
