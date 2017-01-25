package battlecraft.entity.unit;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.Ressources;
import battlecraft.Teams;
import battlecraft.entity.tile.Tile;
import gameframework.core.GameEntity;
import gameframework.core.GameMovableDriverDefaultImpl;
import gameframework.moves_rules.MoveStrategyKeyboard;

public class UnitFactory implements IUnitFactory {
	
	private Teams team;
	Rectangle boundingBox = new Rectangle(32,32,30,30);

	public UnitFactory(Teams team) {
		super();
		this.team = team;
	}

	@Override
	public GameEntity createSoldier(Canvas defaultCanvas) {
		String imagePath = "images/Medieval/Unit/"+team.toString()+"/4.png";
		return new Soldier(defaultCanvas, imagePath, boundingBox, team);
	}

	@Override
	public GameEntity createWorker(Canvas defaultCanvas) {
		String imagePath = "images/Medieval/Unit/"+team.toString()+"/1.png";
		return new Worker(defaultCanvas, imagePath, boundingBox);
	}

}
