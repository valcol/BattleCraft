package battlecraft.rule;

import battlecraft.entity.Tile;
import gameframework.moves_rules.IllegalMoveException;
import gameframework.moves_rules.MoveBlockerRulesApplierDefaultImpl;
import pacman.entity.Ghost;

public class MoveBlockers extends MoveBlockerRulesApplierDefaultImpl {

	public void moveBlockerRule(Ghost g, Tile w) throws IllegalMoveException {
		// The default case is when a ghost is active and not able to cross a
		// wall
		if (g.isActive()) {
			throw new IllegalMoveException();
			// When a ghost is not active, it is able to cross a wall
		}
	}
}
