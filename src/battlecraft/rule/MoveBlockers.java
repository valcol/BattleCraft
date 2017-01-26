package battlecraft.rule;

import battlecraft.entity.structure.Castle;
import battlecraft.entity.structure.MoveBlockerStructure;
import battlecraft.entity.tile.Tile;
import battlecraft.entity.unit.Soldier;
import gameframework.moves_rules.IllegalMoveException;
import gameframework.moves_rules.MoveBlocker;
import gameframework.moves_rules.MoveBlockerRulesApplierDefaultImpl;
import pacman.entity.Ghost;

public class MoveBlockers extends MoveBlockerRulesApplierDefaultImpl {

	public void moveBlockerRule(Soldier g, Castle w) throws IllegalMoveException {
		
		//TODO: ajouter Player castle et IA castle, verif health pour condition victoire

		if (g.getTeam() != w.getTeam()){
			float st1 = g.strike();
			System.out.println(g.getTeam() + " attack with force : " + st1);
			w.takeDamages(st1);
		}
			throw new IllegalMoveException();

	}
}
