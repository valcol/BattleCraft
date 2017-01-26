package battlecraft.entity.unit;

import java.awt.Canvas;
import java.awt.Point;

import battlecraft.Ressources;
import gameframework.core.GameEntity;

public interface IUnitFactory {
	
	GameEntity createSoldier(Canvas defaultCanvas);
	GameEntity createWoodWorker(Canvas defaultCanvas);
	GameEntity createOreWorker(Canvas defaultCanvas);
	GameEntity createRockWorker(Canvas defaultCanvas);
}
