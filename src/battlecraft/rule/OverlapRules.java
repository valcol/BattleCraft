package battlecraft.rule;

import gameframework.core.GameMovableDriverDefaultImpl;
import gameframework.core.GameUniverse;
import gameframework.core.ObservableValue;
import gameframework.moves_rules.MoveStrategyRandom;
import gameframework.moves_rules.MoveStrategyStraightLine;
import gameframework.moves_rules.Overlap;
import gameframework.moves_rules.OverlapRulesApplierDefaultImpl;

import java.awt.Point;
import java.util.Vector;

import battlecraft.MoveStrategySelect;
import battlecraft.entity.unit.Soldier;
import pacman.entity.Ghost;
import pacman.entity.Jail;
import pacman.entity.Pacgum;
import pacman.entity.Pacman;
import pacman.entity.SuperPacgum;
import pacman.entity.TeleportPairOfPoints;

public class OverlapRules extends OverlapRulesApplierDefaultImpl {
	protected GameUniverse universe;
	protected MoveStrategySelect strategy;
	protected Vector<Soldier> vSoldier = new Vector<Soldier>();

	public OverlapRules(Point pacPos, Point gPos,
			ObservableValue<Integer> life, ObservableValue<Integer> score,
			ObservableValue<Boolean> endOfGame) {
	}

	public void setUniverse(GameUniverse universe) {
		this.universe = universe;
	}

	public void setStrategy(MoveStrategySelect strategy) {
		this.strategy = strategy;
	}

	public void addSoldier(Soldier g) {
		vSoldier.addElement(g);
	}
	
	public void overlapRule(Soldier g, Soldier g2){
		//TODO : random order
		if (g.getTeam() != g2.getTeam()){
			g.setCombat(true);
			g2.setCombat(true);
			float st1 = g.strike();
			System.out.println(g.getTeam() + " attack with force : " + st1);
			g2.parry(st1);
			float st2 = g2.strike();
			System.out.println(g2.getTeam() + " attack with force : " + st2);
			g.parry(st2);
			
			if (!g.alive()){
				strategy.removeUnit(g);
				universe.removeGameEntity(g);
			}
			
			if (!g2.alive()){
				strategy.removeUnit(g2);
				universe.removeGameEntity(g2);
			}
				
		}
	}

}
