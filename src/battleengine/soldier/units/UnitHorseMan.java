/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package battleengine.soldier.units;

import battleengine.soldier.core.BehaviorSoldierStd;
import battleengine.soldier.core.BreakingRuleException;
import battleengine.soldier.core.UnitRider;
import battleengine.soldier.core.UnitVisitor;
import battleengine.soldier.core.Weapon;

public class UnitHorseMan extends UnitRider {

	public UnitHorseMan(String soldierName) {
		super(soldierName, new BehaviorSoldierStd(20, 120));
	}

	@Override
	public void accept(UnitVisitor v) {
		v.visit(this);
	}

	/**
	 * A HorseMan can only have two equipments, and one of each kind
	 */
	@Override
	public void addEquipment(Weapon w) {
		int nbW = nbWeapons();
		if (nbW > 1)
			throw new BreakingRuleException();
		if (nbW == 1 && getWeapons().next().getClass() == w.getClass())
			throw new BreakingRuleException();
		super.addEquipment(w);
	}

}
