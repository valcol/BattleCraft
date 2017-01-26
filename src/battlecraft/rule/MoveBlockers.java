package battlecraft.rule;

import battlecraft.Teams;
import battlecraft.entity.structure.Castle;
import battlecraft.entity.unit.Soldier;
import gameframework.core.ObservableValue;
import gameframework.moves_rules.IllegalMoveException;
import gameframework.moves_rules.MoveBlockerRulesApplierDefaultImpl;

public class MoveBlockers extends MoveBlockerRulesApplierDefaultImpl {

	private final ObservableValue<Boolean> endOfGame;
	private final ObservableValue<Integer> life;

	public MoveBlockers(ObservableValue<Boolean> endOfGame, ObservableValue<Integer> life) {
		this.endOfGame=endOfGame;
		this.life=life;
	}

	public void moveBlockerRule(Soldier g, Castle w) throws IllegalMoveException {

		// TODO: ajouter Player castle et IA castle, verif health pour condition
		// victoire

		if (g.getTeam() != w.getTeam()) {
			float st1 = g.strike();
			System.out.println(g.getTeam() + " attack with force : " + st1);
			w.takeDamages(st1);
			if(g.getTeam()==Teams.BLUE && w.getHealth()<=0)
				endOfGame.setValue(true);
			if(g.getTeam()==Teams.RED && w.getHealth()<=0)
				life.setValue(0);
		}
		throw new IllegalMoveException();

	}
}
