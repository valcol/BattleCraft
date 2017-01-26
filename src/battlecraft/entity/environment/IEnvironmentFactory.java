package battlecraft.entity.environment;

import java.awt.Canvas;
import java.awt.Point;

import gameframework.core.GameEntity;

public interface IEnvironmentFactory {

	GameEntity createNormalPineTree(Canvas defaultCanvas, Point position);

	GameEntity createNormalTree(Canvas defaultCanvas, Point position);

	GameEntity createSmallTree(Canvas defaultCanvas, Point position);

	GameEntity createSmallPineTree(Canvas defaultCanvas, Point position);

	GameEntity createGreyRock(Canvas defaultCanvas, Point position);

	GameEntity createYellowRock(Canvas defaultCanvas, Point position);

	GameEntity createCopperOre(Canvas defaultCanvas, Point position);

	GameEntity createGoldOre(Canvas defaultCanvas, Point position);
}
