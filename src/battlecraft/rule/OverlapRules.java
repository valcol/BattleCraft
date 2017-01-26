package battlecraft.rule;

import java.awt.Canvas;
import java.awt.Point;
import java.util.Vector;

import battlecraft.MoveStrategySelect;
import battlecraft.entity.EntityFactory;
import battlecraft.entity.environment.Environment;
import battlecraft.entity.unit.Soldier;
import battlecraft.entity.unit.Worker;
import gameframework.core.GameUniverse;
import gameframework.core.ObservableValue;
import gameframework.moves_rules.OverlapRulesApplierDefaultImpl;

public class OverlapRules extends OverlapRulesApplierDefaultImpl {
	protected GameUniverse universe;
	protected MoveStrategySelect strategy;
	protected Vector<Soldier> vSoldier = new Vector<Soldier>();
	protected EntityFactory ef;
	protected Canvas canvas;

	// TODO: remplacer compteur vie etc par wood ore rock (montant r�colt�s
	// recup st1 dans overlapRule(Worker w, Environment e)

	public OverlapRules(Point pacPos, Point gPos, ObservableValue<Integer> life, ObservableValue<Integer> score,
			ObservableValue<Boolean> endOfGame) {
	}

	public void setUniverse(GameUniverse universe) {
		this.universe = universe;
	}

	public void setEntityFactory(EntityFactory ef) {
		this.ef = ef;
	}

	public void setStrategy(MoveStrategySelect strategy) {
		this.strategy = strategy;
	}

	public void setCanvas(Canvas c) {
		this.canvas = c;
	}

	public void addSoldier(Soldier g) {
		vSoldier.addElement(g);
	}

	public void overlapRule(Soldier g, Soldier g2) {
		if (g.getTeam() != g2.getTeam()) {
			g.setCombat(true);
			g2.setCombat(true);
			float st1 = g.strike();
			System.out.println(g.getTeam() + " attack with force : " + st1);
			g2.parry(st1);
			float st2 = g2.strike();
			System.out.println(g2.getTeam() + " attack with force : " + st2);
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
			} else
				w.setGathering(false);

		}
	}
}
