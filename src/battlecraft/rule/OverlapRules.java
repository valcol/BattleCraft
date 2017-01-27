package battlecraft.rule;

import java.awt.Canvas;
import java.util.Vector;

import battlecraft.IA;
import battlecraft.Player;
import battlecraft.entity.environment.Environment;
import battlecraft.entity.unit.Soldier;
import battlecraft.entity.unit.Worker;
import battlecraft.enums.Teams;
import battlecraft.strategy.MoveStrategySelect;
import gameframework.core.GameUniverse;
import gameframework.core.ObservableValue;
import gameframework.moves_rules.OverlapRulesApplierDefaultImpl;

public class OverlapRules extends OverlapRulesApplierDefaultImpl {
	protected GameUniverse universe;
	protected MoveStrategySelect strategy;
	protected Vector<Soldier> vSoldier = new Vector<Soldier>();
	protected Canvas canvas;
	protected Player player;
	protected IA ia;
	
	protected ObservableValue<Integer> wood;
	protected ObservableValue<Integer> ore;
	protected ObservableValue<Integer> rock;


	public OverlapRules() {
	
	}

	public void setUniverse(GameUniverse universe) {
		this.universe = universe;
	}

	public void setStrategy(MoveStrategySelect strategy) {
		this.strategy = strategy;
	}

	public void setCanvas(Canvas c) {
		this.canvas = c;
	}

	public void overlapRule(Soldier g, Soldier g2) {
		if (g.getTeam() != g2.getTeam()) {
			g.setCombat(true);
			g2.setCombat(true);
			float st1 = g.strike();
			g2.parry(st1);
			float st2 = g2.strike();
			g.parry(st2);

			if (!g.alive()) {
				strategy.removeUnit(g);
				universe.removeGameEntity(g);
			}

			if (!g2.alive()) {
				strategy.removeUnit(g2);
				universe.removeGameEntity(g2);
			}
		}
	}

	public void overlapRule(Worker w, Environment e) {
		if (e.getType() == w.getType()) {
			if (e.health > 0) {
				w.setGathering(true);
				float st1 = w.gather();
				e.takeDamages(st1);
				if (w.getTeam() == Teams.BLUE)
					player.addToRessources(e.getType(), (int) st1);
				else
					ia.addToRessources(e.getType(), (int) st1);
			} else
				w.setGathering(false);
		}
	}

	public void setPlayer(Player p) {
		player = p;
	}
	
	public void setIA(IA ia) {
		this.ia = ia;
	}
}
