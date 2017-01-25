package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;

import gameframework.core.GameEntity;

public interface IStructureFactory {
	
	GameEntity createHouseWorker(Canvas defaultCanvas, Point position);
	GameEntity createCastleTop(Canvas defaultCanvas, Point position);
	GameEntity createCastleBottom(Canvas defaultCanvas, Point position);
	GameEntity createHouseSoldier(Canvas defaultCanvas, Point position);

}
