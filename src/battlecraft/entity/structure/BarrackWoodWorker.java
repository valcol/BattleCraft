package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.LevelManager;
import battlecraft.entity.unit.Worker;
import battlecraft.enums.Ressources;
import battlecraft.enums.Teams;

public class BarrackWoodWorker extends Barrack{

	public BarrackWoodWorker(Canvas defaultCanvas, Point position, String spritePathMiddleAge, String spritePathScifi, Rectangle BOUNDING_BOX, Teams team) {
		super(defaultCanvas, position, spritePathMiddleAge, spritePathScifi, BOUNDING_BOX, team, new BarrackCosts(Ressources.ORE, 1000, Ressources.WOOD, 10));
	}
	
	@Override
	public void createUnit() {
		Point p = new Point(this.position.x+30, this.position.y+30);
		LevelManager.getInstance().addWorker((Worker) unit.createWoodWorker(defaultCanvas, p));
	}
}
