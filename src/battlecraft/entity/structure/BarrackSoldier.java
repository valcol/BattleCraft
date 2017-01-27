package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import battlecraft.LevelManager;
import battlecraft.entity.unit.Soldier;
import battlecraft.enums.Ressources;
import battlecraft.enums.Teams;

public class BarrackSoldier extends Barrack implements ActionListener {

	private Teams team;
	private Timer timer;
	private Canvas c;
	public final static int SECOND = 1000;

	public BarrackSoldier(Canvas defaultCanvas, Point position, String spritePathMiddleAge, String spritePathScifi,
			Rectangle BOUNDING_BOX, Teams team) {
		super(defaultCanvas, position, spritePathMiddleAge, spritePathScifi, BOUNDING_BOX, team, new BarrackCosts(Ressources.ORE, 1000, Ressources.ROCK, 100));
		this.team = team;
		this.c = defaultCanvas;
		timer = new Timer(SECOND, this);
	}

	@Override
	public void createUnit() {
		Point p = new Point((int) (this.position.x+(Math.random() * (10))+30), (int) (this.position.y+(Math.random() * (10))+30));
		LevelManager.getInstance().addPlayerSoldier((Soldier) unit.createSoldier(defaultCanvas, p));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		createUnit();
	}

}
