/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package battleengine.soldier.units;

import battleengine.soldier.core.BreakingRuleException;
import battleengine.soldier.core.UnitInfantry;
import battleengine.soldier.core.Weapon;

public class UnitRobot extends UnitInfantry {

	public UnitRobot(String soldierName) {
		super(soldierName, new BehaviorSoldierHealthBased( 50, 100));
	}
	
	/**
	 * A Robot can have at most four equipments
	 */
	@Override
	public void addEquipment(Weapon w) {
		if (nbWeapons()>3) throw new BreakingRuleException();
		super.addEquipment(w);
	}

	
}
