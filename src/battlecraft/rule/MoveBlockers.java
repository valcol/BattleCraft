package battlecraft.rule;

import battlecraft.entity.structure.Castle;
import battlecraft.entity.unit.Soldier;
import gameframework.core.ObservableValue;
import gameframework.moves_rules.IllegalMoveException;
import gameframework.moves_rules.MoveBlockerRulesApplierDefaultImpl;

public class MoveBlockers extends MoveBlockerRulesApplierDefaultImpl {

	private final ObservableValue<Boolean> endOfGame;

	public MoveBlockers(ObservableValue<Boolean> endOfGame) {
		this.endOfGame=endOfGame;
	}

	public void moveBlockerRule(Soldier g, Castle w) throws IllegalMoveException {

		// TODO: ajouter Player castle et IA castle, verif health pour condition
		// victoire

		if (g.getTeam() != w.getTeam()) {
			float st1 = g.strike();
			System.out.println(g.getTeam() + " attack with force : " + st1);
			w.takeDamages(st1);
			if(w.getHealth()<=0)
				endOfGame.setValue(true);
		}
		throw new IllegalMoveException();

	}
}
