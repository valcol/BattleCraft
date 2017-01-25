package battlecraft.rule;

import java.awt.Point;
import java.util.Vector;

import battlecraft.HouseStrategySelect;
import battlecraft.MoveStrategySelect;
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
	
	public void overlapRule(Worker w, Environment e){
		//TODO : random order
		if (e.health>0){
			float st1 = w.gather();
			e.takeDamages(st1);
		}
	}

	public void overlapRule (Soldier g, Environment e){
		//TODO : random order
		if (e.health>0){
			float st1 = g.strike();
			e.takeDamages(st1);
		}
	}
}
