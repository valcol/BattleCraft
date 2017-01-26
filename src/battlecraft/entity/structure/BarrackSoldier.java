package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import battlecraft.LevelManager;
import battlecraft.Teams;
import battlecraft.entity.unit.Soldier;

public class BarrackSoldier extends Barrack implements ActionListener {

	private Teams team;
	private Timer timer;
	private Canvas c;
	public final static int SECOND = 1000;

	public BarrackSoldier(Canvas defaultCanvas, Point position, String spritePathMiddleAge, String spritePathScifi,
			Rectangle BOUNDING_BOX, Teams team) {
		super(defaultCanvas, position, spritePathMiddleAge, spritePathScifi, BOUNDING_BOX, team);
		this.team = team;
		this.c = defaultCanvas;
		timer = new Timer(SECOND, this);
		
	}

	@Override
	public void createUnit(Canvas c) {
		if (this.team == Teams.RED) {
			Point p = new Point(this.position.x + 30, this.position.y + 30);
			LevelManager.getInstance().addIAToCastleSoldier((Soldier) unit.createSoldier(c, p));
			if (!timer.isRunning())
				timer.start();
		}
		if (this.team == Teams.BLUE) {
			Point p = new Point(this.position.x + 30, this.position.y + 30);
			LevelManager.getInstance().addPlayerSoldier((Soldier) unit.createSoldier(c, p));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		createUnit(c);
	}

}
