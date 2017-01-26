package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.LevelManager;
import battlecraft.Teams;
import battlecraft.entity.unit.Worker;

public class BarrackWoodWorker extends Barrack{

	public BarrackWoodWorker(Canvas defaultCanvas, Point position, String spritePathMiddleAge, String spritePathScifi, Rectangle BOUNDING_BOX, Teams team) {
		super(defaultCanvas, position, spritePathMiddleAge, spritePathScifi, BOUNDING_BOX, team);
	}
	
	@Override
	public void createUnit(Canvas c) {
		Point p = new Point(this.position.x+30, this.position.y+30);
		LevelManager.getInstance().addWorker((Worker) unit.createWoodWorker(c, p));
	}
}
