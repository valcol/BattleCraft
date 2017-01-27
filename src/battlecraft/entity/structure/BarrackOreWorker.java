package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.LevelManager;
import battlecraft.entity.unit.Worker;
import battlecraft.enums.Ressources;
import battlecraft.enums.Teams;

public class BarrackOreWorker extends Barrack{

	public BarrackOreWorker(Canvas defaultCanvas, Point position, String spritePathMiddleAge, String spritePathScifi, Rectangle BOUNDING_BOX, Teams team) {
		super(defaultCanvas, position, spritePathMiddleAge, spritePathScifi, BOUNDING_BOX, team, new BarrackCosts(Ressources.ORE, 1000, Ressources.ROCK, 100));
	}
	
	@Override
	public void createUnit() {
		Point p = new Point((int) (this.position.x+(Math.random() * (10))+30), (int) (this.position.y+(Math.random() * (10))+30));
		LevelManager.getInstance().addWorker((Worker) unit.createOreWorker(defaultCanvas, p));
	}
}
