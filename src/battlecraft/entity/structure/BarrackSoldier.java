package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.LevelManager;
import battlecraft.Teams;
import battlecraft.entity.unit.Soldier;
import gameframework.core.GameEntity;

public class BarrackSoldier extends Barrack {

	public BarrackSoldier(Canvas defaultCanvas, Point position, String spritePath, Rectangle BOUNDING_BOX, Teams team) {
		super(defaultCanvas, position, spritePath, BOUNDING_BOX, team);
	}

	@Override
	public void createUnit(Canvas c) {
		Point p = new Point(this.position.x+30, this.position.y+30);
		LevelManager.getInstance().addPlayerSoldier((Soldier) unit.createSoldier(c, p));
	}

}
