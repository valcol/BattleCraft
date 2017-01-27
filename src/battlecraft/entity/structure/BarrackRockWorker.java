package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.LevelManager;
import battlecraft.entity.unit.Worker;
import battlecraft.enums.Ressources;
import battlecraft.enums.Teams;

public class BarrackRockWorker extends Barrack {

	public BarrackRockWorker(Canvas defaultCanvas, Point position, String spritePathMiddleAge, String imagePathSciFi,
			Rectangle BOUNDING_BOX, Teams team) {
		super(defaultCanvas, position, spritePathMiddleAge, imagePathSciFi, BOUNDING_BOX, team, new BarrackCosts(Ressources.ORE, 1000, Ressources.WOOD, 200));
	}

	@Override
	public void createUnit() {
		Point p = new Point((int) (this.position.x+(Math.random() * (10))+30), (int) (this.position.y+(Math.random() * (10))+30));
		LevelManager.getInstance().addWorker((Worker) unit.createRockWorker(defaultCanvas, p));
	}
}
