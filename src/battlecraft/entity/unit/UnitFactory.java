package battlecraft.entity.unit;

import java.awt.Canvas;
import java.awt.Point;

import battlecraft.entity.tile.Tile;
import gameframework.core.GameEntity;
import gameframework.core.GameMovableDriverDefaultImpl;
import gameframework.moves_rules.MoveStrategyKeyboard;

public class UnitFactory implements IUnitFactory {

	@Override
	public GameEntity createSoldier(Canvas defaultCanvas) {
		String imagePath = "images/Medieval/Unit/20.png";
		return new Soldier(defaultCanvas, imagePath);
	}

}
