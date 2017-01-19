/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package battleengine.soldier.units;

import battleengine.soldier.core.BehaviorSoldierStd;
import battleengine.soldier.core.BreakingRuleException;
import battleengine.soldier.core.UnitInfantry;
import battleengine.soldier.core.Weapon;

public class UnitCenturion extends UnitInfantry {

	public UnitCenturion(String soldierName) {
		super(soldierName, new BehaviorSoldierStd(15, 100));
	}

	/**
	 * A Centurion can have at most two equipments
	 */
	@Override
	public void addEquipment(Weapon w) {
		if (nbWeapons() > 1)
			throw new BreakingRuleException();
		super.addEquipment(w);
	}

}
