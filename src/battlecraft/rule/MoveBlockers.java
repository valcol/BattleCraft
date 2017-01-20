package battlecraft.rule;

import battlecraft.entity.environment.MoveBlockerEnvironment;
import battlecraft.entity.structure.MoveBlockerStructure;
import battlecraft.entity.tile.Tile;
import battlecraft.entity.unit.Soldier;
import gameframework.moves_rules.IllegalMoveException;
import gameframework.moves_rules.MoveBlocker;
import gameframework.moves_rules.MoveBlockerRulesApplierDefaultImpl;
import pacman.entity.Ghost;

public class MoveBlockers extends MoveBlockerRulesApplierDefaultImpl {

	public void moveBlockerRule(Soldier g, MoveBlockerStructure w) throws IllegalMoveException {
		// The default case is when a ghost is active and not able to cross a
		// wall
		System.out.println("collision");
			throw new IllegalMoveException();

	}
}
