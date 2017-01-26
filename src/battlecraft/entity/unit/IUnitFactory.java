package battlecraft.entity.unit;

import java.awt.Canvas;
import java.awt.Point;

import gameframework.core.GameEntity;

public interface IUnitFactory {
	
	GameEntity createSoldier(Canvas defaultCanvas, Point position);
	GameEntity createWoodWorker(Canvas defaultCanvas, Point position);
	GameEntity createOreWorker(Canvas defaultCanvas, Point position);
	GameEntity createRockWorker(Canvas defaultCanvas, Point position);
}
