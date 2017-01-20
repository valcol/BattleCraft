/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package battleengine.soldier.weapon;

import battleengine.soldier.core.BehaviorExtension;
import battleengine.soldier.core.BehaviorSoldier;
import battleengine.soldier.core.Weapon;

public class BehaviorExtLogLin extends BehaviorExtension {
	public BehaviorExtLogLin(Weapon owner, BehaviorSoldier s) {
		super(owner, s);
	}

	@Override
	public float parry(float force) {
		float effectiveReceivedForce = force
				- (float) Math.log(1. + 2 * super.getHealthPoints());
		return super.parry(effectiveReceivedForce);
	}

	@Override
	public float strike() {
		float effectiveGivenForce = super.strike() + 1;
		return effectiveGivenForce;
	}

	@Override
	public float getInitialHealth() {
		// TODO Auto-generated method stub
		return 0;
	}
}
