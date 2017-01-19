/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package battleengine.soldier.units;

import battleengine.soldier.core.BehaviorSoldierStd;
import battleengine.soldier.core.BreakingRuleException;
import battleengine.soldier.core.UnitRider;
import battleengine.soldier.core.Weapon;

public class UnitBikerMan extends UnitRider {

	public UnitBikerMan(String soldierName) {
		super(soldierName, new BehaviorSoldierStd(20, 120));
	}

	/**
	 * A BikerMan can have at most one equipment
	 */
	@Override
	public void addEquipment(Weapon w) {
		if (nbWeapons() > 0)
			throw new BreakingRuleException();
		super.addEquipment(w);
	}

}
