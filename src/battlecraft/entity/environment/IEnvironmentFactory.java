package battlecraft.entity.environment;

import java.awt.Canvas;
import java.awt.Point;

import battlecraft.entity.tile.Tile;
import gameframework.core.GameEntity;

public interface IEnvironmentFactory {

	GameEntity createNormalPineTree(Canvas defaultCanvas, Point position);
	GameEntity createNormalTree(Canvas defaultCanvas, Point position);
	GameEntity createSmallTree(Canvas defaultCanvas, Point position);
	GameEntity createSmallPineTree(Canvas defaultCanvas, Point position);
	GameEntity createSmallRock(Canvas defaultCanvas, Point position);
	GameEntity createNormalRock(Canvas defaultCanvas, Point position);
	GameEntity createBigRock(Canvas defaultCanvas, Point position);
	GameEntity createSmallMineral(Canvas defaultCanvas, Point position);
	GameEntity createNormalMineral(Canvas defaultCanvas, Point position);
	GameEntity createBigMineral(Canvas defaultCanvas, Point position);

}
