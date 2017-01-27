package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;

import gameframework.core.GameEntity;

public interface IStructureFactory {
	
	GameEntity createBarrackRockWorker(Canvas defaultCanvas, Point position);
	GameEntity createCastle(Canvas defaultCanvas, Point position);
	GameEntity createHouseSoldier(Canvas defaultCanvas, Point position);
	GameEntity createBarrackWoodWorker(Canvas defaultCanvas, Point position);
	GameEntity createBarrackOreWorker(Canvas defaultCanvas, Point position);

}
