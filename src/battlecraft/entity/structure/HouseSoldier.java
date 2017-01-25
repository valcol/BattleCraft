package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.Teams;
import gameframework.core.GameEntity;

public class HouseSoldier extends House {

	public HouseSoldier(Canvas defaultCanvas, Point position, String spritePath, Rectangle BOUNDING_BOX, Teams team) {
		super(defaultCanvas, position, spritePath, BOUNDING_BOX, team);
	}

	@Override
	public GameEntity createUnit(Canvas c) {
		return unit.createSoldier(c);
	}

}
