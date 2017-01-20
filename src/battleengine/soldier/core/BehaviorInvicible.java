/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universit� Bordeaux.
 */
package battleengine.soldier.core;


public class BehaviorInvicible extends BehaviorExtension {
	public BehaviorInvicible(Weapon owner, BehaviorSoldier s) {
		super(owner, s);
	}

	@Override
	public float parry(float force) {
		return super.parry(0);
	}

	@Override
	public float getInitialHealth() {
		// TODO Auto-generated method stub
		return 0;
	}
}
